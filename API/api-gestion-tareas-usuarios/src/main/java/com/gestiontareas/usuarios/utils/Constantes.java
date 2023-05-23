package com.gestiontareas.usuarios.utils;

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
	public static final String MSJ_CON_OBS = "Finaliz� el proceso con observaciones: ";
	public static final String MSJ_CON_EXT = "Finaliz� el proceso con �xito: ";
	public static final String SIN_ACCION_MSJ = "No se realiz� ninguna acci�n.";
	public static final String TAREA_EXITO = "Tarea realizada con �xito.";
	public static final String REG_FALTANTES = "Registros Faltantes.";

	//Respuesta de Ejemplo
	public static final String EJEMPLO_OBJECT = "{\n    \"idGesTareasRegistrosUsuarios\": 1,\n    \"usuario\": \"jperez\",\n    \"nombre\": \"Juan Perez\",\n    \"correoElectronico\": \"jperez@gmail.com\",\n    \"contrasenia\": \"*******\",\n    \"fechaCreacion\": \"22/05/2023 03:12\",\n    \"usuarioCreacion\": \"admin\",\n    \"fechaModificacion\": null,\n    \"usuarioModificacion\": null\n}\n";
	public static final String RESPONSE_GETALLREGISTROS = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) encontrado(s) exitosamente.\",\n    \"data\": [\n        {\n            \"idGesTareasRegistrosUsuarios\": 1,\n            \"usuario\": \"jperez\",\n            \"nombre\": \"Juan Perez\",\n            \"correoElectronico\": \"jperez@gmail.com\",\n            \"contrasenia\": \"*******\",\n            \"fechaCreacion\": \"22/05/2023 03:12\",\n            \"usuarioCreacion\": \"admin\",\n            \"fechaModificacion\": null,\n            \"usuarioModificacion\": null\n        }\n    ]\n}\n";
	public static final String RESPONSE_GETREGISTROS = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) encontrado(s) exitosamente.\",\n    \"data\": {\n            \"idGesTareasRegistrosUsuarios\": 1,\n            \"usuario\": \"jperez\",\n            \"nombre\": \"Juan Perez\",\n            \"correoElectronico\": \"jperez@gmail.com\",\n            \"contrasenia\": \"*******\",\n            \"fechaCreacion\": \"22/05/2023 03:12\",\n            \"usuarioCreacion\": \"admin\",\n            \"fechaModificacion\": null,\n            \"usuarioModificacion\": null\n        }\n}\n";
	public static final String RESPONSE_VALIDACION = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) encontrado(s) exitosamente.\",\n    \"data\": true\n}\n";
	public static final String RESPONSE_CREATE = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) creado(s) exitosamente.\",\n    \"data\": null\n}\n";
	public static final String RESPONSE_UPDATE = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) actualizado(s) exitosamente.\",\n    \"data\": null\n}\n";
	public static final String RESPONSE_DELETE = "{\n    \"state\": \"SUCCESS\",\n    \"message\": \"Registro(s) borrado(s) exitosamente.\",\n    \"data\": null\n}\n";
	
}
