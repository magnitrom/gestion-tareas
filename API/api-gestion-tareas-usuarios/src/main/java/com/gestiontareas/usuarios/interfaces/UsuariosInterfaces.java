package com.gestiontareas.usuarios.interfaces;

import com.gestiontareas.usuarios.entities.Usuarios;
import com.gestiontareas.usuarios.model.ResponseObject;


public interface UsuariosInterfaces {

		/**
		 * Metodo que obtiene todos los usuarios a nivel de BDD
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject getAllRegistros();

		/**
		 * Metodo donde obtiene el usuario solicitado por ID
		 * @param idUsuario N�mero de id del usuario
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject getRegistroById(Long idUsuario);


		/**
		 * Metodo que realiza la busqueda por usuario
		 * @param usuario Cadena que contiene el valor del usuario
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject getRegistroByUser(String usuario);
		
		/**
		 * Metodo donde registra los campos del usuario
		 * @param usuario Objeto que contiene el registro de los campos a guardar
		 * @return  Se retorna un objeto de tipo ResponseObject
		 */
		public ResponseObject createRegistro(Usuarios usuario);
		
		/**
		 * Metodo que actualiza los campos del usuario
		 * @param usuario Objeto que contiene los campos del registro a actualizar
		 * @return  Se retorna un objeto de tipo ResponseObject
		 */
		public ResponseObject updateRegistro(Usuarios usuario);
		
		/**
		 * Metodo donde se elimina el usuario de la tabla
		 * @param idUsuario N�mero de id del usuario
		 * @return  Se retorna un objeto de tipo ResponseObject
		 */
		public ResponseObject deleteRegistro(Long idUsuario);
		

		/**
		 * Metodo que realiza la validaci�n del Correo electronico y contrasenia
		 * @param correoElectronico Cadena que contiene el valor del correo electronico
		 * @param contrasenia Cadena que contiene el valor de la contrasenia encriptada
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject getValidacionRegistro(String correoElectronico, String contrasenia);

		/**
		 * Metodo que realiza la validaci�n del usuario y contrasenia
		 * @param correoElectronico Cadena que contiene el valor del correo electronico
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		ResponseObject getValidacionRegistroCorreo(String correoElectronico);

		/**
		 * Metodo que realiza la validaci�n del usuario y contrasenia
	 * @param usuario Valor se desea buscar en la tabla de registros de usuarios
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		ResponseObject getValidacionRegistroUsuario(String usuario);
		
}
