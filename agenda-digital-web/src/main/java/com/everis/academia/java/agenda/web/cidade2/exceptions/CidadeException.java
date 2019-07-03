package com.everis.academia.java.agenda.web.cidade2.exceptions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


public class CidadeException extends ServletException {

	public CidadeException(String msg) {
		super(msg);
	}
	
	
}
