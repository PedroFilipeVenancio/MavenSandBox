package com.everis.academia.java.agenda.web.cidade;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;
import com.everis.academia.java.agenda.digital.dao.impl.CidadeDAO;
import com.everis.academia.java.agenda.digital.dao.impl.CidadeDAO2;

import Entity.Cidade;

@WebServlet(name = "CidadeReadController", urlPatterns = "/CidadeReadController")
public class CidadeReadController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ICidadeBusiness<Cidade> business = new CidadeBusiness();
	private ICidadeDAO<Cidade> dao = new CidadeDAO2();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer codigo =Integer.valueOf(req.getParameter("codigo"))  ;
		String nome = req.getParameter("nome");
		if (req.getParameter("delete").equals("ok")) {
			dao.delete(new Cidade(codigo,nome));
		}
		
//		if (req.getParameter("update").equals("ok")) {
//			CidadeDao.update(new Cidade(codigo,nome));
//		}
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body bgcolorW7tFF0000\">");
		out.println("<table border=\"1\">");
		out.println("<tr><td colspan=\"2\">Cidade Apagada</td></tr>");
		for (Cidade cidade : dao.read()) {
			out.println("<tr><td>Id:</td><td>" + cidade.getCodigo() + "</td></tr>");
			out.println("<tr><td>Nome:</td><td>" + cidade.getNome() + "</td></tr>");						
		}		
		out.println("</table>");
		out.println("<button onclick=\"window.location.href='/agenda-digital-web'\">Volte ao inicio</button>");
		out.println("</body>");
		out.println("</html>");

	}
}

