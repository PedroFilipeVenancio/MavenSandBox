package com.everis.academia.java.agenda.digital.web.servlet.Cidade;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "error", urlPatterns = { "/erro/page" })
public class Error extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException,
			IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body bgcolorW7tFF0000\">");
		out.println("<h1>é Obrigatorio!!!</h1>");
		out.println("<button onclick=\"window.location.href='/agenda-digital-web'\">Volte ao inicio</button>");
		out.println("</body>");
		out.println("</html>");

//		ValidationException validationException = (ValidationException) req
//				.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
//
//		resp.getWriter().write(
//				validationException.getLocalizedMessage());
	}
}
