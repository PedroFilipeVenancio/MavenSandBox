package com.everis.academia.java.agenda.digital.business.Cidade;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.dao.Cidade.ICidadeDAO;
import com.everis.academia.java.agendadigital.entity.Cidade;
@Service
public class CidadeBusiness implements ICidadeBusiness {

//	IGeralDAO<Cidade> dao = new CidadeDAO();
	
	@Autowired
	private ICidadeDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Cidade cidade) {
		dao.delete(cidade);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Cidade cidade) throws BusinessException {
		// valida parametros
		if (cidade.getNome() == null || cidade.getNome().trim().isEmpty()) {
			throw new BusinessException("� obrigatorio");
		}
		// verifica se j� existe
		if (dao.jaExiste(cidade)) {
		}
		
		dao.update(cidade);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Cidade cidade) throws BusinessException {
		System.out.println("no business" + cidade.getCodigo());
		// valida parametros
		if (cidade.getNome() == null || cidade.getNome().trim().isEmpty()) {
			throw new BusinessException("� obrigatorio");
		}

		// verifica se j� existe
		if (dao.jaExiste(cidade)) {
			throw new BusinessException("j� existe");
		}

		if (!cidade.getNome().matches("[a-zA-Z]+")) {
			throw new BusinessException("Formato errado");

		}

		dao.create(cidade);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cidade> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
	@Transactional(readOnly = true)
	public Cidade getById(Integer codigo) {
		Cidade cidadeFound = null;
		for (Cidade cidade : dao.read()) {
			if (cidade.equals(new Cidade(codigo))) {
				cidadeFound = cidade;
			}
		}
		return cidadeFound;
	}

}
