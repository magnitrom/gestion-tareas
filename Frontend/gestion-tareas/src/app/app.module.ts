import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { FormRegistroComponent } from './components/form-registro/form-registro.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { DatePipe } from '@angular/common';
import { CommonModule } from '@angular/common';

import { ToastrModule } from 'ngx-toastr';
import { GestionTareasComponent } from './components/gestion-tareas/gestion-tareas.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FormRegistroComponent,
    GestionTareasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot()
  ],
  providers: [    
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
