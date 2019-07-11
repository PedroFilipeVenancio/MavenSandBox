package com.everis.academia.java.agenda.digital.business.ServicoPrestado;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.IGeralBusiness;
import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agenda.digital.dao.ServicoPrestado.IServicoPrestadoDAO;
import com.everis.academia.java.agenda.digital.dao.ServicoPrestado.ServicoPrestadoDAO;
import com.everis.academia.java.agendadigital.entity.ServicoPrestado;

public class ServicoPrestadoBusiness implements IServicoPrestadoBusiness {

	IServicoPrestadoDAO dao = new ServicoPrestadoDAO();

	@Override
	public void delete(ServicoPrestado servicoPrestadoVar) {
		dao.delete(servicoPrestadoVar);
	}

	@Override
	public void update(ServicoPrestado servicoPrestadoVar) throws BusinessException {
		// valida parametros
		if (servicoPrestadoVar.getCodigo() == null) {
			throw new BusinessException("É obrigatorio");
		}

		// verifica se já existe
		if (dao.jaExiste(servicoPrestadoVar)) {
			throw new BusinessException("já existe");
		}
		
		dao.update(servicoPrestadoVar);
	}

	@Override
	public void create(ServicoPrestado servicoPrestadoVar) throws BusinessException {

		// valida parametros
		if (servicoPrestadoVar.getCodigo() == null) {
			throw new BusinessException("É obrigatorio");
		}

		// verifica se já existe
		if (dao.jaExiste(servicoPrestadoVar)) {
			throw new BusinessException("já existe");
		}

		dao.create(servicoPrestadoVar);
	}

	@Override
	public Collection<ServicoPrestado> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
	public ServicoPrestado getById(Integer codigo) {
		ServicoPrestado ServicoPrestadoFound = null;
		for (ServicoPrestado ServicoPrestado : dao.read()) {
			if (ServicoPrestado.equals(new ServicoPrestado(codigo))) {
				ServicoPrestadoFound = ServicoPrestado;
			}
		}
		return ServicoPrestadoFound;
	}

}


