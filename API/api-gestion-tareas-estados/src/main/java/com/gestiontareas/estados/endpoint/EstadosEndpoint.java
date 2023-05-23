
package com.gestiontareas.estados.endpoint;

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
import com.gestiontareas.estados.entities.Estado;
import com.gestiontareas.estados.model.ResponseObject;
import com.gestiontareas.estados.service.EstadosService;
import com.gestiontareas.estados.utils.Constantes;
import com.gestiontareas.estados.utils.ResponseUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("/api/estados")
public class EstadosEndpoint {	

	@Autowired
	@Qualifier("EstadoServices")
	EstadosService estadoService;

	private static final Logger LOG_MONITOREO = Logger.getLogger("com.gestiontareas.estados.endpoint");
	
    ResponseUtils response = new ResponseUtils(); 
    
    ObjectMapper mapper = new ObjectMapper();  
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Estados", value = "Metodo que obtiene todos los registros de los estados", notes = "Servicio que obtiene todos los registros de los estados")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETALLREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
	public ResponseObject getAllRegistros() {
        return estadoService.getAllRegistros();
    }	
	
	@GetMapping(path = "/getRegistroById/{idRegistro}",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Estados", value = "Metodo donde obtiene el estado realizando la busqueda por ID", notes = "Servicio donde obtiene el estado realizando la busqueda por ID")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject getRegistroById(
    		@PathVariable @ApiParam(name = "idRegistro", value = "N�mero de id del usuario", example = "1234") Long idRegistro) {
        return estadoService.getRegistroById(idRegistro);
    }
	
	@GetMapping(path = "/getRegistroByNombreEstado/{nombreEstado}",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Estados", value = "Metodo que realiza la busqueda del estado a traves del nombre del estado", notes = "Servicio que realiza la busqueda del estado a traves del nombre del estado")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject getRegistroByNombreEstado
    (@PathVariable @ApiParam(name = "nombreEstado", value = "Cadena que contiene el valor del usuario", example = "jPerez") String nombreEstado) {
        return estadoService.getRegistroByNombreEstado(nombreEstado);
    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Estados", value = "Metodo que guarda un registro en la Base de Datos.", notes = "Servicio para guarda un registro en la base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_CREATE, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject createRegistro(
    		@RequestBody @ApiParam(name = "estado", value = "Objeto que contiene el registro de los campos a guardar", example = Constantes.EJEMPLO_OBJECT) Object estado) {
        try {
            return estadoService.createRegistro(mapper.readValue(mapper.writeValueAsBytes(estado), Estado.class));
        } catch (Exception ex) {
        	LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
            return  response.getResponseError(ex.getMessage());
        }	
    }
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Estados", value = "Metodo que actualiza un registro en la Base de Datos.", notes = "Servicio para actualizar un registro en la base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_UPDATE, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject updateRegistro(
    		@RequestBody @ApiParam(name = "estado", value = "Objeto que contiene el registro de los campos a guardar", example = Constantes.EJEMPLO_OBJECT) Object estado) {
        try {
            return estadoService.updateRegistro(mapper.readValue(mapper.writeValueAsBytes(estado), Estado.class));
        } catch (Exception ex) {
        	LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
            return  response.getResponseError(ex.getMessage());
        }	
    }
	
	@DeleteMapping(path = "/{idRegistro}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Estados", value = "Metodo que elimina un registro en la Base de Datos.", notes = "Servicio para elimina un registro en la base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_DELETE, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject deleteRegistro(
    		@PathVariable  @ApiParam(name = "idRegistro", value = "Numero de id del registro", example = "1234") Long idRegistro) {
        return estadoService.deleteRegistro(idRegistro);
    }
	
}
