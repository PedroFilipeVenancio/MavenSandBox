package com.everis.academia.java.agenda.web.cidade.soap;



import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.Holder;

import com.everis.academia.java.agenda.web.cidade.soap.generated.BusinessException_Exception;
import com.everis.academia.java.agenda.web.cidade.soap.generated.Cidade;
import com.everis.academia.java.agenda.web.cidade.soap.generated.CidadeSOAP;
import com.everis.academia.java.agenda.web.cidade.soap.generated.CidadeSOAPService;

public class SOAPMain {

	public static void main(String[] args) throws MalformedURLException, BusinessException_Exception {

		URL url = new URL(
				"http://localhost:8080/agenda-digital-web/soap/ClienteSOAP?wsdl");

		CidadeSOAPService service = new CidadeSOAPService(url);
		CidadeSOAP port = service.getCidadeSOAPPort();
		
		Cidade cidadeTeste = new Cidade();
		cidadeTeste.setNome("Lisboneraaa");
		port.create(new Holder<Cidade> (cidadeTeste));	
		for (Cidade cidade : port.read()) {

			System.out.println(cidade.getNome());
			System.out.println(cidade.getCodigo());
		}
		System.out.println("acabou a primeira iteração");
		
		cidadeTeste.setNome("Lisbon666");
		cidadeTeste.setCodigo(1);
		
		port.update(cidadeTeste);
		
		for (Cidade cidade : port.read()) {

			System.out.println(cidade.getNome());
		}
		
		System.out.println("Acabou de fazer update");
		
		port.delete(cidadeTeste);	
		
	}
}
