package com.gestiontareas.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiontareas.dao.TareasDao;
import com.gestiontareas.entities.Tarea;
import com.gestiontareas.interfaces.TareasInterfaces;
import com.gestiontareas.model.ResponseObject;
import com.gestiontareas.utils.ResponseUtils;


@Service("TareaServices")
public class TareasService implements TareasInterfaces{

	private static final Logger LOG_MONITOREO = Logger.getLogger("com.gestiontareas.tareas.service");
	
	@Autowired
	TareasDao tareaDao;	

	ResponseUtils response = new ResponseUtils();

	@Override
	public ResponseObject getAllRegistros() {
		try {
			return response.getResponseList((List<Tarea>) tareaDao.findAll());
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}
	
	@Override
	public ResponseObject getRegistroById(Long idRegistro) {
		try {
			return response.getResponse(tareaDao.buscarTareasPorId(idRegistro));
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject buscarTareasPorIdUsuario(Long idUsuario) {
		try {
			return response.getResponseList(tareaDao.buscarTareasPorIdUsuario(idUsuario));
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject buscarTareasPorUsuario(String usuario) {
		try {
			return response.getResponseList(tareaDao.buscarTareasPorUsuario(usuario));
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject createRegistro(Tarea tarea) {
		try {
			tareaDao.save(tarea);
			return response.getResponseCreate();
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject updateRegistro(Tarea tarea) {
		try {
			tareaDao.save(tarea);
			return response.getResponseUpdate();
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject deleteRegistro(Long idRegistro) {
		try {
			tareaDao.deleteById(idRegistro);
			return response.getResponseDelete();
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}



}
