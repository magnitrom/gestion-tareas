package com.gestiontareas.interfaces;

import com.gestiontareas.entities.Tarea;
import com.gestiontareas.model.ResponseObject;


public interface TareasInterfaces {

		/**
		 * Metodo que obtiene todos los registros de las tareas
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject getAllRegistros();

		/**
		 * Metodo que obtiene la tareas realizando la busqueda por ID
		 * @param idRegistro Numero de id del registro a buscar
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject getRegistroById(Long idRegistro);


		/**
		 * Metodo que realiza la busqueda de las tareas a traves del id del usuario
		 * @param idUsuario Numero de id del usuario a buscar
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject buscarTareasPorIdUsuario(Long idUsuario);

		/**
		 * Metodo que realiza la busqueda de las tareas a traves del usuario
		 * @param usuario Usuario a buscar
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject buscarTareasPorUsuario(String usuario);
		
		/**
		 * Metodo que guarda en la base de datos el registro
		 * @param tarea Objeto que contiene el registro de tarea a guardar
		 * @return  Se retorna un objeto de tipo ResponseObject
		 */
		public ResponseObject createRegistro(Tarea tarea);
		
		/**
		 * Metodo que actualiza en la base de datos el registro
		 * @param tarea Objeto que contiene la tarea del registro a actualizar
		 * @return  Se retorna un objeto de tipo ResponseObject
		 */
		public ResponseObject updateRegistro(Tarea tarea);
		
		/**
		 * Metodo que elimina en la base de datos el registro
		 * @param idRegistro Numero de id del registro a eliminar
		 * @return  Se retorna un objeto de tipo ResponseObject
		 */
		public ResponseObject deleteRegistro(Long idRegistro);
		
		
}
