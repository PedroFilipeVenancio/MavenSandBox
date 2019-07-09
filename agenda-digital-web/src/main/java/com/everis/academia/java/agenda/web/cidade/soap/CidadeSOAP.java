package com.everis.academia.java.agenda.web.cidade.soap;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;

import Entity.Cidade;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService()
public class CidadeSOAP {

	private ICidadeBusiness<Cidade> business = new CidadeBusiness();

	// não tem de ser igual ao nome do metodo
	@WebMethod(operationName = "create")
	// isto depois gera o "campo" cidade no ws qq coisa wsdl ?!
	@WebResult(name = "cidade")
	public Cidade create(@WebParam(name = "cidade", mode = Mode.IN) Cidade cidade) throws BusinessException {

		business.create(cidade);
		return cidade;
	}

	@WebMethod(operationName = "delete")
	@WebResult(name = "cidade")
	public void delete(@WebParam(name = "cidade", mode = Mode.IN) Cidade cidade) throws BusinessException {
		business.delete(cidade);
	}
	
	@WebMethod(operationName = "read")
	@WebResult(name = "cidade")
	public Collection<Cidade> read() throws BusinessException {	
		return business.read();
	}
	
	@WebMethod(operationName = "update")
	@WebResult(name = "cidade")
	public void update(@WebParam(name = "cidade", mode = Mode.IN) Cidade cidade) throws BusinessException {
		business.update(cidade);
	}

}
