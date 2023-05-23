package com.gestiontareas.estados.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gestiontareas.estados.entities.Estado;

public interface EstadosDao extends CrudRepository<Estado, Long> {

	/**
	 * Metodo que obtiene la informacion de la tabla de estados
	 * realizando la busqueda por nombre de estado
	 * 
	 * @param nombreEstado Nombre del estado que se desea buscar.
	 * @return Retorna el registro encontrado
	 */
	@Query(value = "SELECT * FROM gestareas_estados WHERE UPPER(nombre_estado) = UPPER(:nombreEstado)", nativeQuery = true)
	public Estado buscarPorNombreEstado(@Param("nombreEstado") String nombreEstado);
	
	/**
	 * Metodo que obtiene la informacion de la tabla de estados
	 * realizando la busqueda por numero de id
	 * 
	 * @param idRegistro Numero de Id del registro
	 * @return Retorna el registro encontrado
	 */
	@Query(value = "SELECT * FROM gestareas_estados WHERE idgesTareas_estados = :idRegistro", nativeQuery = true)
	public Estado buscarPorId(@Param("idRegistro") Long idRegistro);

}
