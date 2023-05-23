package com.gestiontareas.estados.interfaces;

import com.gestiontareas.estados.entities.Estado;
import com.gestiontareas.estados.model.ResponseObject;


public interface EstadosInterfaces {

		/**
		 * Metodo que obtiene todos los registros de los estados
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject getAllRegistros();

		/**
		 * Metodo donde obtiene el estado realizando la busqueda por ID
		 * @param idRegistro Numero de id del registro a buscar
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject getRegistroById(Long idRegistro);


		/**
		 * Metodo que realiza la busqueda del estado a traves del nombre del estado
		 * @param nombreEstado Nombre del Estado a buscar
		 * @return  Se retorna un objeto de tipo ResponseObject con el resultado de la respuesta
		 */
		public ResponseObject getRegistroByNombreEstado(String nombreEstado);
		
		/**
		 * Metodo que guarda en la base de datos el registro
		 * @param estado Objeto que contiene el registro de los campos a guardar
		 * @return  Se retorna un objeto de tipo ResponseObject
		 */
		public ResponseObject createRegistro(Estado estado);
		
		/**
		 * Metodo que actualiza en la base de datos el registro
		 * @param estado Objeto que contiene los campos del registro a actualizar
		 * @return  Se retorna un objeto de tipo ResponseObject
		 */
		public ResponseObject updateRegistro(Estado estado);
		
		/**
		 * Metodo que elimina en la base de datos el registro
		 * @param idRegistro Numero de id del registro a eliminar
		 * @return  Se retorna un objeto de tipo ResponseObject
		 */
		public ResponseObject deleteRegistro(Long idRegistro);
		
		
}
