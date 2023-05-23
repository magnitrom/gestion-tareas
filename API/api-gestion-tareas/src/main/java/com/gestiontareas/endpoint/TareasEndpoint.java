
package com.gestiontareas.endpoint;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestiontareas.entities.Tarea;
import com.gestiontareas.model.ResponseObject;
import com.gestiontareas.service.TareasService;
import com.gestiontareas.utils.Constantes;
import com.gestiontareas.utils.ResponseUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("/api/tarea")
public class TareasEndpoint {	

	@Autowired
	@Qualifier("TareaServices")
	TareasService tareaService;

	private static final Logger LOG_MONITOREO = Logger.getLogger("com.gestiontareas.endpoint");
	
    ResponseUtils response = new ResponseUtils(); 
    
    ObjectMapper mapper = new ObjectMapper();  
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Tareas", value = "Metodo que obtiene todos los registros de las Tareas", notes = "Servicio que obtiene todos los registros de las Tareas")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETALLREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
	public ResponseObject getAllRegistros() {
        return tareaService.getAllRegistros();
    }	
	
	@GetMapping(path = "/getRegistroById/{idRegistro}",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Tareas", value = "Metodo donde obtiene la tarea realizando la busqueda por ID", notes = "Servicio donde obtiene la tarea realizando la busqueda por ID")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject getRegistroById(
    		@PathVariable @ApiParam(name = "idRegistro", value = "Numero de id de la tarea", example = "1234") Long idRegistro) {
        return tareaService.getRegistroById(idRegistro);
    }
	
	@GetMapping(path = "/buscarTareasPorIdUsuario/{idUsuario}",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Tareas", value = "Metodo donde obtiene las tareas realizando la busqueda por ID del usuario", notes = "Servicio donde obtiene las tareas realizando la busqueda por ID del usuario")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETALLREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject buscarTareasPorIdUsuario
    (@PathVariable @ApiParam(name = "idUsuario", value = "Numero de Id del Usuario", example = "12345") Long idUsuario) {
        return tareaService.buscarTareasPorIdUsuario(idUsuario);
    }
	
	@GetMapping(path = "/buscarTareasPorUsuario/{usuario}",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Tareas", value = "Metodo donde obtiene las tareas realizando la busqueda por usuario", notes = "Servicio donde obtiene las tareas realizando la busqueda por usuario")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETALLREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject buscarTareasPorIdUsuario
    (@PathVariable @ApiParam(name = "usuario", value = "Usuario para realizar la busqueda", example = "jperez") String usuario) {
        return tareaService.buscarTareasPorUsuario(usuario);
    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Tareas", value = "Metodo que guarda un registro en la Base de Datos.", notes = "Servicio para guarda un registro en la base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_CREATE, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject createRegistro(
    		@RequestBody @ApiParam(name = "tarea", value = "Objeto que contiene el registro de los campos a guardar", example = Constantes.EJEMPLO_OBJECT) Object tarea) {
        try {
            return tareaService.createRegistro(mapper.readValue(mapper.writeValueAsBytes(tarea), Tarea.class));
        } catch (Exception ex) {
        	LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
            return  response.getResponseError(ex.getMessage());
        }	
    }
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Tareas", value = "Metodo que actualiza un registro en la Base de Datos.", notes = "Servicio para actualizar un registro en la base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_UPDATE, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject updateRegistro(
    		@RequestBody @ApiParam(name = "tarea", value = "Objeto que contiene el registro de los campos a guardar", example = Constantes.EJEMPLO_OBJECT) Object tarea) {
        try {
            return tareaService.updateRegistro(mapper.readValue(mapper.writeValueAsBytes(tarea), Tarea.class));
        } catch (Exception ex) {
        	LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
            return  response.getResponseError(ex.getMessage());
        }	
    }
	
	@DeleteMapping(path = "/{idRegistro}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Tareas", value = "Metodo que elimina un registro en la Base de Datos.", notes = "Servicio para elimina un registro en la base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_DELETE, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject deleteRegistro(
    		@PathVariable  @ApiParam(name = "idRegistro", value = "Numero de id del registro", example = "1234") Long idRegistro) {
        return tareaService.deleteRegistro(idRegistro);
    }
	
}
