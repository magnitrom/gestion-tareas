import { Component } from '@angular/core';
import { Usuario } from './model/gestionTareas.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  anioActual!: number;
  title = 'gestion-tareas';
  userInfo: Usuario = new Usuario();
  inicioSesion: boolean = true;
  esCrearCuenta: boolean = false;
  sesionAbierta: boolean = false;

  constructor() {
    //
  }

  ngOnInit(): void {
    this.anioActual = new Date().getFullYear();
    let sesion: any = sessionStorage.getItem(btoa('session'));
    if (sesion) {
      let sesionDes: any = JSON.parse(atob(sesion));
      console.log(sesionDes);

      if (sesionDes.state == 'SUCCESS') {
        this.inicioSesion = false;
        this.sesionAbierta = true;
      }
    }
  }

  endSesion() {
    sessionStorage.clear();
    this.inicioSesion = true;
    this.esCrearCuenta = false;
    this.sesionAbierta = false;
  }




  crearCuenta() {
    this.inicioSesion = false;
    this.esCrearCuenta = true;
  }

  btnRegresar(event: any) {
    this.inicioSesion = event;
    this.esCrearCuenta = !event;
  }


  btnLogin(event: any) {
    this.inicioSesion = false;
    this.sesionAbierta = true;
    this.userInfo = event;
    console.log(event)
  }
}
