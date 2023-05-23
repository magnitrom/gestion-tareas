package com.gestiontareas.usuarios.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gestiontareas.usuarios.entities.Usuarios;


public interface UsuariosDao extends CrudRepository<Usuarios, Long>{

	/**
	 * Metodo que obtiene la informacion de la tabla de registros de usuarios realizando la busqueda por usuario
	 * @param usuario Valor se desea buscar en la tabla de registros de usuarios
	 * @return Retorna el registro encontrado
	 */
	@Query(value = "select * from gestareas_registroUsuarios where usuario = :usuario", nativeQuery = true )
	public Usuarios buscarPorUsuario(@Param("usuario") String usuario);
	
	/**
	 * Metodo que obtiene la informacion de la tabla de registros de usuarios realizando la busqueda por id del registro
	 * @param @param idRegistro Numero de Id del registro
	 * @return Retorna el registro encontrado
	 */
	@Query(value = "select * from gestareas_registroUsuarios where idgesTareas_registrosUsuarios = :idRegistro", nativeQuery = true )
	public Usuarios buscarPorId(@Param("idRegistro") Long idRegistro);

	/**
	 * Metodo que valida si existe el registro del usuario a traves del correo electronico y la contrase�a 
	 * @param correoElectronico Correo electronico del usuario
	 * @param contrasenia Valor se desea buscar en la tabla de registros de usuarios
	 * @return Retorna el registro encontrado
	 */
	@Query(value = "select * from gestareas_registroUsuarios where correo_electronico = :correoElectronico and contrasenia = :contrasenia", nativeQuery = true )
	public Usuarios validacionCorreoContrasenia(@Param("correoElectronico") String correoElectronico, @Param("contrasenia") String contrasenia);


	/**
	 * Metodo que valida si existe el registro del usuario a traves del usuario
	 * @param usuario Valor se desea buscar en la tabla de registros de usuarios
	 * @return Retorna el registro encontrado
	 */
	@Query(value = "select * from gestareas_registroUsuarios where usuario = :usuario ", nativeQuery = true )
	public Usuarios validacionUsuario(@Param("usuario") String usuario);


	/**
	 * Metodo que valida si existe el registro del usuario a traves del correo electronico 
	 * @param correoElectronico Correo electronico del usuario
	 * @return Retorna el registro encontrado
	 */
	@Query(value = "select * from gestareas_registroUsuarios where correo_electronico = :correoElectronico", nativeQuery = true )
	public Usuarios validacionCorreo(@Param("correoElectronico") String correoElectronico);

}
