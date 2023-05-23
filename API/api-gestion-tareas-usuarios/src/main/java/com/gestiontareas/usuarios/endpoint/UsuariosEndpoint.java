
package com.gestiontareas.usuarios.endpoint;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestiontareas.usuarios.entities.Usuarios;
import com.gestiontareas.usuarios.model.ResponseObject;
import com.gestiontareas.usuarios.service.UsuariosService;
import com.gestiontareas.usuarios.utils.Constantes;
import com.gestiontareas.usuarios.utils.ResponseUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("/api/usuarios")
public class UsuariosEndpoint {	

	@Autowired
	@Qualifier("UsuarioServices")
	UsuariosService usuariosService;

	private static final Logger LOG_MONITOREO = Logger.getLogger("com.gestiontareas.usuarios.endpoint");
	
    ResponseUtils response = new ResponseUtils(); 
    
    ObjectMapper mapper = new ObjectMapper();  
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Usuarios", value = "Metodo que obtiene todos los usuarios a nivel de BDD.", notes = "Servicio para obtener todos los usuarios a nivel de BDD.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETALLREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
	public ResponseObject getAllRegistros() {
        return usuariosService.getAllRegistros();
    }	
	
	@GetMapping(path = "/getRegistroById/{idUsuario}",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Usuarios", value = "Metodo que obtiene el registros solicitado.", notes = "Servicio para obtiene el registros solicitado a partir del id.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject getRegistroById(
    		@PathVariable @ApiParam(name = "idUsuario", value = "Numero de id del usuario", example = "1234") Long idUsuario) {
        return usuariosService.getRegistroById(idUsuario);
    }
	
	@GetMapping(path = "/getRegistroByUser/{usuario}",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Usuarios", value = "Metodo que obtiene el registros solicitado.", notes = "Servicio para obtiene el registros solicitado a partir del usuario.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject getRegistroByUser
    (@PathVariable @ApiParam(name = "usuario", value = "Cadena que contiene el valor del usuario", example = "jPerez") String usuario) {
        return usuariosService.getRegistroByUser(usuario);
    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Usuarios", value = "Metodo que guarda un registro en la Base de Datos.", notes = "Servicio para guarda un registro en la base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_CREATE, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject createRegistro(
    		@RequestBody @ApiParam(name = "usuario", value = "Objeto que contiene el registro de los campos a guardar", example = Constantes.EJEMPLO_OBJECT) Object usuario) {
        try {
            return usuariosService.createRegistro(mapper.readValue(mapper.writeValueAsBytes(usuario), Usuarios.class));
        } catch (Exception ex) {
        	LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
            return  response.getResponseError(ex.getMessage());
        }	
    }
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Usuarios", value = "Metodo que actualiza un registro en la Base de Datos.", notes = "Servicio para actualizar un registro en la base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_UPDATE, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject updateRegistro(
    		@RequestBody @ApiParam(name = "usuario", value = "Objeto que contiene el registro de los campos a guardar", example = Constantes.EJEMPLO_OBJECT) Object usuario) {
        try {
            return usuariosService.updateRegistro(mapper.readValue(mapper.writeValueAsBytes(usuario), Usuarios.class));
        } catch (Exception ex) {
        	LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
            return  response.getResponseError(ex.getMessage());
        }	
    }
	
	@DeleteMapping(path = "/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Usuarios", value = "Metodo que elimina un registro en la Base de Datos.", notes = "Servicio para elimina un registro en la base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_DELETE, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject deleteRegistro(
    		@PathVariable  @ApiParam(name = "idUsuario", value = "N�mero de id del usuario", example = "1234") Long idUsuario) {
        return usuariosService.deleteRegistro(idUsuario);
    }
	
	@GetMapping(path = "/getValidacionRegistro", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Validacion Usuarios", value = "Metodo que realiza la validacion en la Base de Datos.", notes = "Servicio para realiza la validaci�n del correoElectronico y contrasenia en la base de datos base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_GETREGISTROS, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject getValidacionRegistro(
    		@RequestParam("correoElectronico")  @ApiParam(name = "user", value = "Correo electronico a realizar la validacion", example = "jperez@mail.com") String correoElectronico, 
    		@RequestParam("pass")  @ApiParam(name = "pass", value = "Password a realizar la validacion", example = "****") String contrasenia) {
        return usuariosService.getValidacionRegistro(correoElectronico, contrasenia);
    }
	

	
	@GetMapping(path = "/getValidacionRegistroUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Validacion Usuarios", value = "Metodo que realiza la validacion en la Base de Datos.", notes = "Servicio para realiza la validacion del usuario en la base de datos base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_VALIDACION, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject getValidacionRegistroUsuario(
    		@RequestParam("usuario")  @ApiParam(name = "usuario", value = "Cadena que contiene el valor del usuario", example = "jPerez") String usuario) {
        return usuariosService.getValidacionRegistroUsuario(usuario);
    }
	

	
	@GetMapping(path = "/getValidacionRegistroCorreo", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	@ApiOperation(tags = "Validacion Usuarios", value = "Metodo que realiza la validacion en la Base de Datos.", notes = "Servicio para realiza la validacion del correoElectronico en la base de datos base de datos.")
	@ApiResponse(code = 200, message = "Respuesta del servicio.", response = ResponseObject.class, examples = @Example(value = @ExampleProperty(value = Constantes.RESPONSE_VALIDACION, mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseObject getValidacionRegistroCorreo(
    		@RequestParam("correoElectronico")  @ApiParam(name = "user", value = "Correo electronico a realizar la validacion", example = "jperez@mail.com") String correoElectronico 
    		){
        return usuariosService.getValidacionRegistroCorreo(correoElectronico);
    }
}
