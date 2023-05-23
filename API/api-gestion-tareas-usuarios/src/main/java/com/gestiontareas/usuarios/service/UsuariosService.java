package com.gestiontareas.usuarios.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiontareas.usuarios.dao.UsuariosDao;
import com.gestiontareas.usuarios.entities.Usuarios;
import com.gestiontareas.usuarios.interfaces.UsuariosInterfaces;
import com.gestiontareas.usuarios.model.ResponseObject;
import com.gestiontareas.usuarios.utils.ResponseUtils;


@Service("UsuarioServices")
public class UsuariosService implements UsuariosInterfaces{

	private static final Logger LOG_MONITOREO = Logger.getLogger("com.gestiontareas.usuarios.service");
	
	@Autowired
	UsuariosDao usuarioDao;	

	ResponseUtils response = new ResponseUtils();

	@Override
	public ResponseObject getAllRegistros() {
		try {
			return response.getResponseList((List<Usuarios>) usuarioDao.findAll());
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}
	
	@Override
	public ResponseObject getRegistroById(Long idUsuario) {
		try {
			return response.getResponse(usuarioDao.buscarPorId(idUsuario));
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject getRegistroByUser(String usuario) {
		try {
			return response.getResponse(usuarioDao.buscarPorUsuario(usuario));
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject createRegistro(Usuarios usuario) {
		try {
			usuarioDao.save(usuario);
			return response.getResponseCreate();
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject updateRegistro(Usuarios usuario) {
		try {
			usuarioDao.save(usuario);
			return response.getResponseUpdate();
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject deleteRegistro(Long idUsuario) {
		try {
			usuarioDao.deleteById(idUsuario);
			return response.getResponseDelete();
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject getValidacionRegistro(String correoElectronico, String contrasenia) {
		try {
			Usuarios user = usuarioDao.validacionCorreoContrasenia(correoElectronico, contrasenia);
			return response.getResponse(user);
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}	
	}

	@Override
	public ResponseObject getValidacionRegistroUsuario(String usuario) {
		try {
			Usuarios user = usuarioDao.validacionUsuario(usuario);
			if(user != null)
				return response.getResponse(true);
			else
				return response.getResponse(null);
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}	
	}
	
	@Override
	public ResponseObject getValidacionRegistroCorreo(String correoElectronico) {
		try {
			Usuarios user = usuarioDao.validacionCorreo(correoElectronico);
			if(user != null)
				return response.getResponse(true);
			else
				return response.getResponse(null);
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}	
	}


}
