package com.everis.academia.java.agenda.digital.dao.ServiçoPrestado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agendadigital.entity.ServicoPrestado;

public class ServiçoPrestadoDAO implements IGeralDAO<ServicoPrestado> {
	
	public static List<ServicoPrestado> servicoPrestadoColl = new ArrayList<ServicoPrestado>();
//	public static Collection<ServicoPrestado> servicoPrestadoColl = new HashSet<ServicoPrestado>();

	private static int id = 0;

	@Override
	public void delete(ServicoPrestado servicoPrestadoVar) {
		servicoPrestadoColl.remove(servicoPrestadoVar);
	}

	@Override
	public void update(ServicoPrestado servicoPrestadoVar) {
		
		
		int indexOf = servicoPrestadoVar.getCodigo();
		servicoPrestadoColl.remove(servicoPrestadoVar);
		servicoPrestadoColl.add(servicoPrestadoVar);
//		Integer indexOf = servicoPrestadoVar. indexOf(servicoPrestadoVar);
//		servicoPrestadoVar.set(indexOf, servicoPrestadoVar);
	}

	@Override
	public void create(ServicoPrestado servicoPrestadoVar) {
		id++;
		servicoPrestadoVar.setCodigo(id);
		servicoPrestadoColl.add(servicoPrestadoVar);
		
	}


	@Override
	public Boolean jaExiste(ServicoPrestado servicoPrestadoVar) {
		
		for (ServicoPrestado servicoPrestado : servicoPrestadoColl) {
			if (servicoPrestado.getCodigo().equals(servicoPrestadoVar.getCodigo())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Collection<ServicoPrestado> read() {
		return servicoPrestadoColl;
	}

}

