package com.gestiontareas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gestiontareas.entities.Tarea;

public interface TareasDao extends CrudRepository<Tarea, Long> {

	/**
	 * Metodo que obtiene las tareas realizando la busqueda por id de usuario 
	 * 
	 * @param idTarea Id de la tarea a buscar
	 * @return Retorna Una lista con los registro encontrados
	 */
	@Query(value = "SELECT * FROM gestareas_tareas WHERE idgesTareas_tareas = :idTarea", nativeQuery = true)
	public Tarea buscarTareasPorId(@Param("idTarea") Long idTarea);
	

	/**
	 * Metodo que obtiene las tareas realizando la busqueda por id de usuario 
	 * 
	 * @param idUsuario Id del usuario que se desea realizar la busqueda
	 * @return Retorna Una lista con los registro encontrados
	 */
	@Query(value = "SELECT * FROM gestareas_tareas gesTareas INNER JOIN gestareas_registrousuarios gesUsuario ON gesTareas.idgesTareas_registrosUsuarios = gesUsuario.idgesTareas_registrosUsuarios WHERE gesTareas.idgesTareas_registrosUsuarios = :idUsuario", nativeQuery = true)
	public List<Tarea> buscarTareasPorIdUsuario(@Param("idUsuario") Long idUsuario);
	

	/**
	 * Metodo que obtiene las tareas realizando la busqueda por el usuario
	 *  
	 * @param usuario Usuario
	 * @return Retorna Una lista con los registro encontrados
	 */
	@Query(value = "SELECT * FROM gestareas_tareas gesTareas INNER JOIN gestareas_registrousuarios gesUsuario ON gesTareas.idgesTareas_registrosUsuarios = gesUsuario.idgesTareas_registrosUsuarios WHERE gesUsuario.usuario = :usuario", nativeQuery = true)
	public List<Tarea> buscarTareasPorUsuario(@Param("usuario") String usuario);
	

}
