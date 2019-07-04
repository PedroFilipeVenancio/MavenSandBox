


package com.everis.academia.java.agenda.web.cidade;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.business.BusinessException;


@WebServlet(name = "CidadeException", urlPatterns = "/CidadeException")
public class ErrorPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
		
		BusinessException businessException = (BusinessException) req.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
	
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body bgcolorW7tFF0000\">");
		out.println("<h1>" + businessException.getLocalizedMessage() + "</h1>");
		out.println("<button onclick=\"window.location.href='/agenda-digital-web'\">Volte ao inicio</button>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
