package com.everis.academia.java.agenda.digital.dao.ServicoPrestado;

import java.util.Collection;

import com.everis.academia.java.agendadigital.entity.ServicoPrestado;

public interface IServicoPrestadoDAO {
	void delete(ServicoPrestado var);

	void update(ServicoPrestado var);

	void create(ServicoPrestado var);
	
	Collection<ServicoPrestado> read();
		
	Boolean jaExiste(ServicoPrestado var );

}
