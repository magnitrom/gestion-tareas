import { DatePipe } from '@angular/common';
import { Component, Input } from '@angular/core';
import { Estados, ResponseObject, Tarea, Usuario } from 'src/app/model/gestionTareas.model';
import { GestionEstadosService } from 'src/app/services/gestion-estados.service';
import { GestionTareasService } from 'src/app/services/gestion-tareas.service';
import Swal from 'sweetalert2';
declare let $: any;

@Component({
  selector: 'app-gestion-tareas',
  templateUrl: './gestion-tareas.component.html',
  styleUrls: ['./gestion-tareas.component.css']
})
export class GestionTareasComponent {

  constructor(private datepipe: DatePipe, private apiGesTareas: GestionTareasService, private apiGesEstado: GestionEstadosService) { }
  
  userInfo: Usuario = new Usuario();
  tituloTarea: string = "";
  descripcionTarea: string = "";
  dataAMostrarEnTabla: Tarea[]=[];
  catEstados: Estados[] = [];

  ngOnInit(): void {
    
    let sesion = sessionStorage.getItem(btoa('session'));
    if (sesion) {
      let responseUser: ResponseObject = JSON.parse(atob(sesion));
      this.userInfo = responseUser.data;
      this.obtenerEstado();
    }
    this.inicializarComponentes();
  }

  ngAfterOnInit(){    
    this.inicializarComponentes();
  }

  obtenerEstado(){
    this.apiGesEstado.getAllEstado().subscribe((response) => {
      
      if (response.state == 'SUCCESS') {
        this.catEstados = response.data;    
        
      this.obtenerTareasUsuario();    
      }
      else 
        {
          console.log("No se pudo cargar las estados. "+response.state+":"+response.message)
        }
    }, (error) => {   
      console.error(error);
      console.log("No se pudo recuperar la información de los estados.");
    });
  }
  
  obtenerTareasUsuario(){
    this.apiGesTareas.getAllTareasByIdUsuario(this.userInfo.idGesTareasRegistrosUsuarios).subscribe((response) => {
      
      if (response.state == 'SUCCESS') {
        this.dataAMostrarEnTabla = response.data;        
      }
      else if (response.state == 'NO_RECORD')
      {
        this.dataAMostrarEnTabla = [];
      }
      else 
        {
          console.log("No se pudo cargar las tareas. "+response.state+":"+response.message)
        }
    }, (error) => {   
      console.error(error);
      console.log("No se pudo recuperar la información de los usuario.");
    });
  }

  obtenerNombre(id: number): string {
    let objeto = this.catEstados.find(item => item.idgesTareasEstados == id);
    if (objeto) {
      return objeto.nombreEstado;
    } else {
      return '';
    }
  }

  guardarTareas(){
    if(this.validarCamposTareas())
    {
      let tareaObj = this.prepararTarea();
      
      this.apiGesTareas.setCreateTareas(tareaObj).subscribe((response) => {
      
        if (response.state == 'SUCCESS') {
          this.obtenerTareasUsuario();
          this.tituloTarea = "";
          this.descripcionTarea = "";
          Swal.fire({
            icon: 'success',
            title: 'Tarea Guardada',
            text: 'Tarea Guardada Satisfactoriamente.'
          }
          );
          
        }
        else 
          {
            Swal.fire({
              icon: 'info',
              title: 'No se pudo guardar la tarea',
              text: "No se pudo guardar la la tarea. "+response.state+":"+response.message
            }
            );}
      }, (error) => {   
        Swal.fire({
          icon: 'info',
          title: 'No se pudo guardar la tarea',
          text: "No se pudo guardar la información del registro de la tarea. "+error
        }
        );
        console.error(error);
        console.log("No se pudo guardar la información del registro de la tarea. "+error);
      });
    }
  }

  completarTarea(tarea: Tarea){
    Swal.fire({
      icon: 'warning',
      title: '¿Desea completar la tarea?',
      showCancelButton: true,
      confirmButtonText: 'Completar'
    }).then((result) => {
      if (result.isConfirmed) {
        tarea = {
          ...tarea,
          idgesTareasEstados: 2,
          fechaModificacion: String(this.datepipe.transform(new Date(), "dd/MM/yyyy HH:mm")),
          usuarioModificacion: this.userInfo.usuario,
        }
        this.apiGesTareas.setUpdateTareas(tarea).subscribe((response) => {      
          if (response.state == 'SUCCESS') {
            this.obtenerTareasUsuario();
            Swal.fire({
              icon: 'success',
              title: 'Tarea Completada',
              text: 'Tarea Completada Satisfactoriamente.'
            }
            );            
          }
          else 
            {
              Swal.fire({
                icon: 'info',
                title: 'No se pudo completar la tarea',
                text: "No se pudo completar la la tarea. "+response.state+":"+response.message
              }
              );}
        }, (error) => {   
          Swal.fire({
            icon: 'info',
            title: 'No se pudo completar la tarea',
            text: "No se pudo completar la información del registro de la tarea. "+error
          }
          );
          console.error(error);
          console.log("No se pudo completar la información del registro de la tarea. "+error);
        });
      }
    });
    
  }

  eliminarTarea(tarea: Tarea){
    Swal.fire({
      icon: 'warning',
      title: '¿Desea eliminar la tarea?',
      showCancelButton: true,
      confirmButtonText: 'Eliminar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.apiGesTareas.deleteTareas(tarea.idgesTareas).subscribe((response) => {      
          if (response.state == 'SUCCESS') {
            this.obtenerTareasUsuario();
            Swal.fire({
              icon: 'success',
              title: 'Tarea Eliminada',
              text: 'Tarea Eliminada Satisfactoriamente.'
            }
            );            
          }
          else 
            {
              Swal.fire({
                icon: 'info',
                title: 'No se pudo eliminar la tarea',
                text: "No se pudo eliminar la la tarea. "+response.state+":"+response.message
              }
              );}
        }, (error) => {   
          Swal.fire({
            icon: 'info',
            title: 'No se pudo eliminar la tarea',
            text: "No se pudo eliminar la información del registro de la tarea. "+error
          }
          );
          console.error(error);
          console.log("No se pudo eliminar la información del registro de la tarea. "+error);
        });
      }
    });
    
  }

  prepararTarea(): Tarea{
    let tarea: Tarea = new Tarea();
    
    return {
      ...tarea,
      idgesTareas: 0,
      idgesTareasRegistrosUsuarios: this.userInfo.idGesTareasRegistrosUsuarios,
      idgesTareasEstados: 1,
      titulo: this.tituloTarea,
      descripcion: this.descripcionTarea,
      fechaCreacion: String(this.datepipe.transform(new Date(), "dd/MM/yyyy HH:mm")),
      usuarioCreacion: this.userInfo.usuario,
    }

  }


  validarCamposTareas(): boolean{
    if(this.tituloTarea.trim().length === 0)
    {
      Swal.fire({
        icon: 'info',
        title: 'Campo Vacío',
        text: "El campo titulo se encuentra vacío"
      }
      );
      return false;
    }

    if(this.descripcionTarea.trim().length === 0)
    {
      Swal.fire({
        icon: 'info',
        title: 'Campo Vacío',
        text: "El campo descripción se encuentra vacío"
      }
      );
      return false;
    }

    return true;
  }

  inicializarComponentes(){
    $(document).ready(function(){
      $('.tooltipped').tooltip();
    });
  }
}
