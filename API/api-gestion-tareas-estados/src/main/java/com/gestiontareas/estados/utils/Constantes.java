package com.gestiontareas.estados.utils;

public class Constantes {

	Constantes(){
		//Constructor
	}
	
	public enum ESTADO {
		SUCCESS,
        ERROR,
        NO_RECORD,
        SIN_ACCION
    }
	
	public static final String REG_ENCONTRADOS_MSJ = "Registro(s) encontrado(s) exitosamente.";
	public static final String CREATE_MSJ = "Registro(s) creado(s) exitosamente.";
	public static final String CREATE_MSJ_OBS = "Registro(s) creado(s) con observaciones: ";
	public static final String CREATE_ERROR_MSJ = "No se pudo crear el registro.";
	public static final String UPDATE_MSJ = "Registro(s) actualizado(s) exitosamente.";
	public static final String DELETE_MSJ = "Registro(s) borrado(s) exitosamente.";
	public static final String ERROR_MSJ = "Ocurrio el siguiente error: ";
	public static final String NO_RECORD_MSJ = "No se encontraron registros";
	public static final String MSJ_SIN_PARAM = "Parametros Faltantes.";
	public static final String MSJ_CON_OBS = "Finalizo el proceso con observaciones: ";
	public static final String MSJ_CON_EXT = "Finalizo el proceso con exito: ";
	public static final String SIN_ACCION_MSJ = "No se realizo ninguna accion.";
	public static final String TAREA_EXITO = "Tarea realizada con exito.";
	public static final String REG_FALTANTES = "Registros Faltantes.";

	//Respuesta de Ejemplo
	public static final String EJEMPLO_OBJECT = "{\n\"idgesTareasEstados\": 1,\n\"nombreEstado\": \"PENDIENTE\",\n\"descripcionEstado\": \"Tarea que se encuentra pendiente de realización\",\n\"fechaCreacion\": \"22/05/2023 01:27\",\n\"usuarioCreacion\": \"admin\",\n\"fechaModificacion\": null,\n\"usuarioModificacion\": null\n}\n";
	public static final String RESPONSE_GETALLREGISTROS = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) encontrado(s) exitosamente.\",\n    \"data\": [{\n        \"idgesTareasEstados\": 1,\n        \"nombreEstado\": \"PENDIENTE\",\n        \"descripcionEstado\": \"Tarea que se encuentra pendiente de realización\",\n        \"fechaCreacion\": \"22/05/2023 01:27\",\n        \"usuarioCreacion\": \"admin\",\n        \"fechaModificacion\": null,\n        \"usuarioModificacion\": null\n    }]\n}\n";
	public static final String RESPONSE_GETREGISTROS = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) encontrado(s) exitosamente.\",\n    \"data\": {\n        \"idgesTareasEstados\": 1,\n        \"nombreEstado\": \"PENDIENTE\",\n        \"descripcionEstado\": \"Tarea que se encuentra pendiente de realización\",\n        \"fechaCreacion\": \"22/05/2023 01:27\",\n        \"usuarioCreacion\": \"admin\",\n        \"fechaModificacion\": null,\n        \"usuarioModificacion\": null\n    }\n}\n";
	public static final String RESPONSE_CREATE = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) creado(s) exitosamente.\",\n    \"data\": null\n}\n";
	public static final String RESPONSE_UPDATE = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) actualizado(s) exitosamente.\",\n    \"data\": null\n}\n";
	public static final String RESPONSE_DELETE = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) borrado(s) exitosamente.\",\n    \"data\": null\n}\n";
	
}
