package com.gestiontareas.entities;

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
@Table(name = "gestareas_tareas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tarea {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    @Column(name = "idgesTareas_tareas") 
    private Long idgesTareas;
    @Column(name = "idgesTareas_registrosUsuarios") 
    private Long idgesTareasRegistrosUsuarios;
    @Column(name = "idgesTareas_estados") 
    private Long idgesTareasEstados;
    @Column(name = "titulo") 
    private String titulo;
    @Column(name = "descripcion") 
    private String descripcion;
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
	public Long getIdgesTareas() {
		return idgesTareas;
	}
	public void setIdgesTareas(Long idgesTareas) {
		this.idgesTareas = idgesTareas;
	}
	public Long getIdgesTareasRegistrosUsuarios() {
		return idgesTareasRegistrosUsuarios;
	}
	public void setIdgesTareasRegistrosUsuarios(Long idgesTareasRegistrosUsuarios) {
		this.idgesTareasRegistrosUsuarios = idgesTareasRegistrosUsuarios;
	}
	public Long getIdgesTareasEstados() {
		return idgesTareasEstados;
	}
	public void setIdgesTareasEstados(Long idgesTareasEstados) {
		this.idgesTareasEstados = idgesTareasEstados;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
    
}
