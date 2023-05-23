package com.gestiontareas.usuarios.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "gestareas_registroUsuarios")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuarios {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name = "idgesTareas_registrosUsuarios")
	private Long idGesTareasRegistrosUsuarios;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "correo_electronico")
	private String correoElectronico;
	@Column(name = "contrasenia")
	private String contrasenia;
	@Column(name = "fecha_creacion")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm")
	private Date fechaCreacion;
	@Column(name = "usuario_creacion")
	private String usuarioCreacion;
	@Column(name = "fecha_modificacion")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm")
	private Date fechaModificacion;
	@Column(name = "usuario_modificacion")
	private String usuarioModificacion;
    		 
	public String getUsuario() {		
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getContrasenia() {
        int longitudContrasenia = 5;
        contrasenia = "*".repeat(longitudContrasenia);
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	public Long getIdGesTareasRegistrosUsuarios() {
		return idGesTareasRegistrosUsuarios;
	}
	public void setIdGesTareasRegistrosUsuarios(Long idGesTareasRegistrosUsuarios) {
		this.idGesTareasRegistrosUsuarios = idGesTareasRegistrosUsuarios;
	}
	@Override
	public String toString() {
		return "Usuarios [idGesTareasRegistrosUsuarios=" + idGesTareasRegistrosUsuarios + ", usuario=" + usuario
				+ ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + ", contrasenia=" + contrasenia
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + ", fechaModificacion="
				+ fechaModificacion + ", usuarioModificacion=" + usuarioModificacion + "]";
	}
	
	

}
