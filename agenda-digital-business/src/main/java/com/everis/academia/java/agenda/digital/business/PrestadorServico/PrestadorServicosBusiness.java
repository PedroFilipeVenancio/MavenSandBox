package com.everis.academia.java.agenda.digital.business.PrestadorServico;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.Telefone.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.dao.PrestacaoServico.IPrestacaoServicoDAO;
import com.everis.academia.java.agenda.digital.dao.PrestadorServicos.IPrestadorServicoDAO;
import com.everis.academia.java.agenda.digital.dao.PrestadorServicos.PrestadorServicosDAO;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;
import com.everis.academia.java.agendadigital.entity.Telefone;
@Service
public class PrestadorServicosBusiness implements IPrestadorServicoBusiness {

//	IPrestadorServicoDAO dao = new PrestadorServicosDAO();
	@Autowired
	private IPrestadorServicoDAO dao;
	
	@Autowired
	private ITelefoneBusiness telefonesBusiness;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(PrestadorServico prestadorServicoVar) {
		dao.delete(prestadorServicoVar);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(PrestadorServico prestadorServicoVar) throws BusinessException {

		if (prestadorServicoVar.getNome() == null || prestadorServicoVar.getNome().trim().isEmpty()) {
			throw new BusinessException("É obrigatorio");
		}

		if (!prestadorServicoVar.getNome().matches("[a-zA-Z ]+")) {
			throw new BusinessException("Formato errado, só é permitido letras e espaços");
		}
		
		if (prestadorServicoVar.getNome().length()>=100) {
			throw new BusinessException("Não é permitido mais de 100 Caracteres");
		}
		if (prestadorServicoVar.getBairro().length()>=50) {
			throw new BusinessException("Não é permitido mais de 50 Caracteres");
		}
		if (prestadorServicoVar.getCep().length()>=10) {
			throw new BusinessException("Não é permitido mais de 10 Caracteres");
		}
		if (prestadorServicoVar.getComplemento().length()>=200) {
			throw new BusinessException("Não é permitido mais de 200 Caracteres");
		}
		if (prestadorServicoVar.getLogradouro().length()>=100) {
			throw new BusinessException("Não é permitido mais de 100 Caracteres");
		}
		if (prestadorServicoVar.getEmail().length()>=80) {
			throw new BusinessException("Não é permitido mais de 80 Caracteres");
		}
		if (prestadorServicoVar.getEmail().length()>=80) {
			throw new BusinessException("Não é permitido mais de 80 Caracteres");
		}
		if (!prestadorServicoVar.getEmail().matches(".+\\@.+\\..+")) {
			throw new BusinessException("formato email errado");
		}
		if (!prestadorServicoVar.getNumero().matches("[0-9]+")) {
			throw new BusinessException("so aceita numeros");
		}
		dao.update(prestadorServicoVar);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void createWithPhone (PrestadorServico prestadorServicoVar,Set<Telefone> telefones) throws BusinessException {
		for (Telefone telefone : telefones) {
			telefone.setPrestadorServico(prestadorServicoVar);
		}
		prestadorServicoVar.setTelefones(telefones);	
		dao.create(prestadorServicoVar);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(PrestadorServico prestadorServicoVar) throws BusinessException {
		// valida parametros
		if (prestadorServicoVar.getNome() == null || prestadorServicoVar.getNome().trim().isEmpty()) {
			throw new BusinessException("É obrigatorio colocar nome");
		}

		// verifica se já existe
		if (dao.jaExiste(prestadorServicoVar)) {
			throw new BusinessException("já existe");
		}
		
		if (prestadorServicoVar.getNome() == null || prestadorServicoVar.getNome().trim().isEmpty()) {
			throw new BusinessException("É obrigatorio");
		}

		if (!prestadorServicoVar.getNome().matches("[a-zA-Z ]+")) {
			throw new BusinessException("Formato errado, só é permitido letras e espaços");
		}
		
		if (prestadorServicoVar.getNome().length()>=100) {
			throw new BusinessException("Não é permitido mais de 100 Caracteres");
		}
		if (prestadorServicoVar.getBairro().length()>=50) {
			throw new BusinessException("Não é permitido mais de 50 Caracteres");
		}
		if (prestadorServicoVar.getCep().length()>=10) {
			throw new BusinessException("Não é permitido mais de 10 Caracteres");
		}
		if (prestadorServicoVar.getComplemento().length()>=200) {
			throw new BusinessException("Não é permitido mais de 200 Caracteres");
		}
		if (prestadorServicoVar.getLogradouro().length()>=100) {
			throw new BusinessException("Não é permitido mais de 100 Caracteres");
		}
		if (prestadorServicoVar.getEmail().length()>=80) {
			throw new BusinessException("Não é permitido mais de 80 Caracteres");
		}
		if (prestadorServicoVar.getEmail().length()>=80) {
			throw new BusinessException("Não é permitido mais de 80 Caracteres");
		}
		if (!prestadorServicoVar.getEmail().matches(".+\\@.+\\..+")) {
			throw new BusinessException("formato email errado");
		}
		if (!prestadorServicoVar.getNumero().matches("[0-9]+")) {
			throw new BusinessException("so aceita numeros");
		}
		
		dao.create(prestadorServicoVar);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<PrestadorServico> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
	@Transactional(readOnly = true)
	public PrestadorServico getById(Integer codigo) {
		PrestadorServico PrestadorServicoFound = null;
		for (PrestadorServico prestadorServico : dao.read()) {
			if (prestadorServico.equals(new PrestadorServico(codigo))) {
				PrestadorServicoFound = prestadorServico;
			}
		}
		return PrestadorServicoFound;
	}

}

