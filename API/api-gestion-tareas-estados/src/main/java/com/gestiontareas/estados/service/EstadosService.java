package com.gestiontareas.estados.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiontareas.estados.dao.EstadosDao;
import com.gestiontareas.estados.entities.Estado;
import com.gestiontareas.estados.interfaces.EstadosInterfaces;
import com.gestiontareas.estados.model.ResponseObject;
import com.gestiontareas.estados.utils.ResponseUtils;


@Service("EstadoServices")
public class EstadosService implements EstadosInterfaces{

	private static final Logger LOG_MONITOREO = Logger.getLogger("com.gestiontareas.estados.service");
	
	@Autowired
	EstadosDao estadoDao;	

	ResponseUtils response = new ResponseUtils();

	@Override
	public ResponseObject getAllRegistros() {
		try {
			return response.getResponseList((List<Estado>) estadoDao.findAll());
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}
	
	@Override
	public ResponseObject getRegistroById(Long idRegistro) {
		try {
			return response.getResponse(estadoDao.buscarPorId(idRegistro));
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject getRegistroByNombreEstado(String nombreEstado) {
		try {
			return response.getResponse(estadoDao.buscarPorNombreEstado(nombreEstado));
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject createRegistro(Estado estado) {
		try {
			estadoDao.save(estado);
			return response.getResponseCreate();
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject updateRegistro(Estado estado) {
		try {
			estadoDao.save(estado);
			return response.getResponseUpdate();
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}

	@Override
	public ResponseObject deleteRegistro(Long idRegistro) {
		try {
			estadoDao.deleteById(idRegistro);
			return response.getResponseDelete();
		} catch (Exception ex) {
			LOG_MONITOREO.log(Level.SEVERE, ex.getMessage());
			return response.getResponseError(ex.getMessage());
		}
	}



}
