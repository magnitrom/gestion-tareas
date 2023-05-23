import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/enviroment/environment';
import { Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { handleError } from '../utils/httpErrorControl';

@Injectable({
  providedIn: 'root'
})
export class GestionTareasService {
  
  constructor(private http: HttpClient) { }

  urlApiGestionTareas = environment.urlServer+":8070";

  setCreateTareas(tarea: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    let options = { headers: headers };     
    let url = `${this.urlApiGestionTareas}/api/tarea`;
    return this.http.post<any>(url, tarea, options).pipe(
      retry(1),
      catchError(handleError)
    );
  }

  
  setUpdateTareas(tarea: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    let options = { headers: headers };     
    let url = `${this.urlApiGestionTareas}/api/tarea`;
    return this.http.put<any>(url, tarea, options).pipe(
      retry(1),
      catchError(handleError)
    );
  }

  getAllTareasByIdUsuario(idUsuario: number): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    let options = { headers: headers };     
    let url = `${this.urlApiGestionTareas}/api/tarea/buscarTareasPorIdUsuario/${idUsuario}`;
    return this.http.get<any>(url,  options).pipe(
      retry(1),
      catchError(handleError)
    );
  }

  
  deleteTareas(idTarea: number): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    let options = { headers: headers };     
    let url = `${this.urlApiGestionTareas}/api/tarea/${idTarea}`;
    return this.http.delete<any>(url, options).pipe(
      retry(1),
      catchError(handleError)
    );
  }

}
