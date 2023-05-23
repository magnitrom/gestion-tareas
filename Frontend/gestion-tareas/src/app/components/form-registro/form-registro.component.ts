import { DatePipe } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { catchError, map } from 'rxjs/operators';
import { forkJoin, from, Observable, of } from 'rxjs';
import { ResponseObject, Usuario } from 'src/app/model/gestionTareas.model';
import { GestionUsuariosService } from 'src/app/services/gestion-usuarios.service';
import { encriptar } from 'src/app/utils/encrypt';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-form-registro',
  templateUrl: './form-registro.component.html',
  styleUrls: ['./form-registro.component.css']
})
export class FormRegistroComponent {

  constructor(private datepipe: DatePipe, private apiGesUsuarios: GestionUsuariosService) { }
  @Output() regresar = new EventEmitter<any>();
  
  formGroup: FormGroup = new FormGroup({
    usuario: new FormControl('', [Validators.required]),
    nombre: new FormControl('', Validators.required),
    correoElectronico: new FormControl('', [Validators.required, Validators.email]),
    contrasenia: new FormControl('', Validators.required),
    contrasenia_2: new FormControl('', Validators.required),    
  });
  
  ngOnInit(){
    this.scrollToTop();
  }

  submit(){
    if(this.validarFormulario())
    {
      debugger
      forkJoin([
        this.validaCorreo(this.formGroup.getRawValue().correoElectronico).pipe(catchError(err => of([])))
      ]).subscribe(([stateCorreos]) => {

        if(String(stateCorreos) == "NO_RECORD")
        {
          forkJoin([
            this.validaUsuarios(this.formGroup.getRawValue().usuario).pipe(catchError(err => of([])))
          ]).subscribe(([stateUsuario]) => {
    
            if(String(stateUsuario) == "NO_RECORD")
            {
              this.guardarUsuario();
            }
            else  
            {
              Swal.fire({
                icon: 'warning',
                title: 'Error al realizar registro',
                text: 'Ya existe un registro con ese usuario.'
              }
              );
            }
          });
        }
        else  
          {
            Swal.fire({
              icon: 'warning',
              title: 'Error al realizar registro',
              text: 'Ya existe un registro con ese correo electrónico.'
            }
            );
          }
      });      
    }
      
  }

  guardarUsuario(){
    let userObj = this.prepararUsuario();
    this.apiGesUsuarios.setCreateUsuarios(userObj).subscribe((response) => {
    
      if (response.state == 'SUCCESS') {
        Swal.fire({
          icon: 'success',
          title: 'Registro Creado',
          text: 'Registro Creado Satisfactoriamente.'
        }
        );
        
       this.btnRegresar();
      }
      else 
        {
          Swal.fire({
            icon: 'info',
            title: 'No se guardo el registro',
            text: "No se pudo guardar la información del registro de usuario. "+response.state+":"+response.message
          }
          );}
    }, (error) => {   
      Swal.fire({
        icon: 'info',
        title: 'No se guardo el registro',
        text: "No se pudo guardar la información del registro de usuario. "+error
      }
      );
      console.error(error);
      console.log("No se pudo recuperar la información de los usuario.");
    });
  }

  btnRegresar(){
    this.formGroup.reset();
    this.regresar.emit(true);
  }
  validarFormulario(): boolean{
    if(this.formGroup.getRawValue().usuario.trim().length === 0 )
    {
      Swal.fire({
        icon: 'info',
        title: 'Campo Vacío',
        text: "El campo usuario se encuentra vacío"
      }
      );
      return false;
    }
    if(this.formGroup.getRawValue().nombre.trim().length === 0 )
    {
      Swal.fire({
        icon: 'info',
        title: 'Campo Vacío',
        text: "El campo nombre se encuentra vacío"
      }
      )
      return false;
    }
    if(this.formGroup.getRawValue().correoElectronico.trim().length === 0 )
    {
      Swal.fire({
        icon: 'info',
        title: 'Campo Vacío',
        text: "El campo correoElectronico se encuentra vacío"
      }
      );
      return false;
    }
   
    if(this.formGroup.getRawValue().contrasenia.trim() != this.formGroup.getRawValue().contrasenia_2.trim())
    {
      Swal.fire({
        icon: 'info',
        title: 'Constraseñas distintas',
        text: "Las contraseñas no coinciden"
      }
      );
      return false;
    }
    if(!this.formGroup.valid)
    {
      Swal.fire({
        icon: 'info',
        title: 'Campos Vacío',
        text: "Tiene que completar todos los datos del formulario."
      }
      );
    }
    return this.formGroup.valid;
  }

  prepararUsuario(): Usuario{
    let user: Usuario = new Usuario();
    return {
      ...user,
      usuario: this.formGroup.getRawValue().usuario.trim(),
      nombre: this.formGroup.getRawValue().nombre.trim(),
      correoElectronico: this.formGroup.getRawValue().correoElectronico.trim(),
      contrasenia: encriptar(this.formGroup.getRawValue().contrasenia.trim()),
      fechaCreacion: String(this.datepipe.transform(new Date(), "dd/MM/yyyy HH:mm")),
      usuarioCreacion: this.formGroup.getRawValue().usuario.trim(),
    }

  }

  validaCorreo(correo: string): Observable<ResponseObject[]> {
    return from(this.apiGesUsuarios.validaCorreo(correo)).pipe(
      map(response => response.state),
      catchError(error => {
        console.error("Error validando correo: " + error.message);
        return of([]);
      }),

    );
  }

  validaUsuarios(usuario: string): Observable<ResponseObject[]> {
    return from(this.apiGesUsuarios.validaUsuarios(usuario)).pipe(
      map(response => response.state),
      catchError(error => {
        console.error("Error validando usuario: " + error.message);
        return of([]);
      }),

    );
  }

  scrollToTop() {
    window.scroll({
        top: 0,
        left: 0,
        behavior: 'smooth'
    });
}
}

