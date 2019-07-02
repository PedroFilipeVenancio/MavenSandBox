package com.everis.academia.java.agenda.web.cidade2;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Cidade;

@WebServlet(name = "CidadeUpdateController", urlPatterns = "/CidadeUpdateController")
public class CidadeUpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CidadeDao.delete(CidadeUpdate.toBeUpdated);

		String nome = req.getParameter("nome");

		if (nome == null || nome.trim().isEmpty()) {
			throw new ServletException("É obrigatorio");	
		}
		
		CidadeDao.create(nome);
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body bgcolorW7tFF0000\">");
		out.println("<table border=\"1\">");
		out.println("<tr><td colspan=\"2\">Cidade Adicionada</td></tr>");
		for (Cidade cidade : CidadeDao.read()) {
			out.println("<tr><td>Id:</td><td>" + cidade.getCodigo() + "</td></tr>");
			out.println("<tr><td>Nome:</td><td>" + cidade.getNome() + "</td></tr>");						
		}		
		out.println("</table>");
		out.println("<button onclick=\"window.location.href='/agenda-digital-web'\">Volte ao inicio</button>");
		out.println("</body>");
		out.println("</html>");
	}
}


