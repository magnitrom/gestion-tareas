import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/enviroment/environment';
import { Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { handleError } from '../utils/httpErrorControl';

@Injectable({
  providedIn: 'root'
})
export class GestionUsuariosService {

  urlApiGestionUsuario = environment.urlServer+":8090";

  constructor(private http: HttpClient) { }

  setCreateUsuarios(user: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    let options = { headers: headers };     
    let url = `${this.urlApiGestionUsuario}/api/usuarios`;
    return this.http.post<any>(url, user, options).pipe(
      retry(1),
      catchError(handleError)
    );
  }

  validaUsuarios(user: string): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    let options = { headers: headers };     
    let url = `${this.urlApiGestionUsuario}/api/usuarios/getValidacionRegistroUsuario?usuario=${user}`;
    return this.http.get<any>(url, options).pipe(
      retry(1),
      catchError(handleError)
    );
  }

  validaCorreo(correo: string): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    let options = { headers: headers };     
    let url = `${this.urlApiGestionUsuario}/api/usuarios/getValidacionRegistroCorreo?correoElectronico=${correo}`;
    return this.http.get<any>(url, options).pipe(
      retry(1),
      catchError(handleError)
    );
  }

  loginRegistro(correo: string, pass: string): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    let options = { headers: headers };     
    let url = `${this.urlApiGestionUsuario}/api/usuarios/getValidacionRegistro?correoElectronico=${correo}&pass=${pass}`;
    return this.http.get<any>(url, options).pipe(
      retry(1),
      catchError(handleError)
    );
  }
}
