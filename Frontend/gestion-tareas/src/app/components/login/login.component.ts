import { Component, EventEmitter, Output } from '@angular/core';
import { GestionUsuariosService } from 'src/app/services/gestion-usuarios.service';
import { encriptar } from 'src/app/utils/encrypt';

import Swal from 'sweetalert2';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  constructor(private apiGesUsuarios: GestionUsuariosService) { }

  @Output() login = new EventEmitter<any>();
  correo_electronico: string = "";
  pass: string = "";

  btnLogin() {
    this.apiGesUsuarios.loginRegistro(this.correo_electronico.trim(), encriptar(this.pass.trim())).subscribe((response) => {

      if (response.state == 'SUCCESS') {
        this.correo_electronico = "";
        this.pass = "";
        sessionStorage.setItem(btoa('session'), btoa(JSON.stringify(response)));        
        this.login.emit(response.data);

      }
      else {
        Swal.fire({

          icon: 'warning',
          title: 'Error al iniciar sesión',
          text: 'Usuario y/o contraseña incorrectos.'
        }
        );
      }
    }, (error) => {
      console.error(error);
      Swal.fire({
        icon: 'error',
        title: 'No se pudo realizar el inicio de sesión.'
      });
    });


  }



}
