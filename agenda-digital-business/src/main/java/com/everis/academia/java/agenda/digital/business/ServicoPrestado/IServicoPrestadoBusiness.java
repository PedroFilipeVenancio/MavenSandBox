package com.everis.academia.java.agenda.digital.business.ServicoPrestado;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agendadigital.entity.ServicoPrestado;

public interface IServicoPrestadoBusiness {
	void delete(ServicoPrestado toDelete);

	void update(ServicoPrestado toUpdate) throws BusinessException;

	void create(ServicoPrestado toCreate) throws BusinessException;
	
	Collection<ServicoPrestado> read();
	
	ServicoPrestado getById(Integer id);
}
