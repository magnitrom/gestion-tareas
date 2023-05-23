import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/enviroment/environment';
import { Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { handleError } from '../utils/httpErrorControl';

@Injectable({
  providedIn: 'root'
})
export class GestionEstadosService {
  
  constructor(private http: HttpClient) { }

  urlApiGestionEstados = environment.urlServer+":8080";

  getAllEstado(): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    let options = { headers: headers };     
    let url = `${this.urlApiGestionEstados}/api/estados`;
    return this.http.get<any>(url,  options).pipe(
      retry(1),
      catchError(handleError)
    );
  }
  

}
