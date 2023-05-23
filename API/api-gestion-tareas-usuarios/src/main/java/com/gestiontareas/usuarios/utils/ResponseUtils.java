package com.gestiontareas.usuarios.utils;

import com.gestiontareas.usuarios.model.ResponseObject;
import com.gestiontareas.usuarios.utils.Constantes.ESTADO;

import java.util.List;

public class ResponseUtils {

		public ResponseObject getResponse(Object obj) {
			return obj != null 	? new ResponseObject(ESTADO.SUCCESS.toString(), Constantes.REG_ENCONTRADOS_MSJ, obj)
								: new ResponseObject(ESTADO.NO_RECORD.toString(), Constantes.NO_RECORD_MSJ);
		}
		public ResponseObject getResponseList(List<?> list) {
			return !list.isEmpty() 	? new ResponseObject(ESTADO.SUCCESS.toString(), Constantes.REG_ENCONTRADOS_MSJ, list)
									: new ResponseObject(ESTADO.NO_RECORD.toString(), Constantes.NO_RECORD_MSJ);
		}

		public ResponseObject getResponseCreate(Object obj) {
			return obj != null  ? new ResponseObject(ESTADO.SUCCESS.toString(), Constantes.CREATE_MSJ, obj)
								: new ResponseObject(ESTADO.SUCCESS.toString(), Constantes.CREATE_MSJ);
		}
		public ResponseObject getResponseCreate() {
			return new ResponseObject(ESTADO.SUCCESS.toString(), Constantes.CREATE_MSJ);
		}				
		
		public ResponseObject getResponseConExito() {
			return new ResponseObject(ESTADO.SUCCESS.toString(), Constantes.MSJ_CON_EXT);
		}		
		
		public ResponseObject getResponseUpdate() {
			return new ResponseObject(ESTADO.SUCCESS.toString(), Constantes.UPDATE_MSJ);
		}
		
		public ResponseObject getResponseDelete() {
			return new ResponseObject(ESTADO.SUCCESS.toString(), Constantes.DELETE_MSJ);
		}

		public ResponseObject getResponseError(String msjError) {
			return new ResponseObject(ESTADO.ERROR.toString(), Constantes.ERROR_MSJ + msjError);
		}
		

}
