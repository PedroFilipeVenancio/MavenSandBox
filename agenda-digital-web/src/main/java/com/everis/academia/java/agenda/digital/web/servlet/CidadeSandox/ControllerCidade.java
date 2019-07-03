package com.everis.academia.java.agenda.digital.web.servlet.CidadeSandox;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Cidade;

@WebServlet(name = "controllerCidade", urlPatterns = "/controllerCidade")
public class ControllerCidade extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
//	public List<Cidade> listaCidades = new ArrayList<Cidade>();
	public static Set<Cidade> listaCidades = new HashSet<Cidade>();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		List<Cidade> listaCidades = new ArrayList<Cidade>();

		this.listaCidades.add(new Cidade(1, "Lisboa"));
		this.listaCidades.add(new Cidade(2, "Porto"));

		if (!(req.getParameter("nome") == null) && (!(Integer.valueOf(req.getParameter("id")) == null))) {
			listaCidades.add(new Cidade(Integer.valueOf(req.getParameter("id")), req.getParameter("nome")));	
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=\"#E6E6FA\">");
		out.println("<form action=\"controllerDelete\">"); 
		out.println("<table border=\"1\">");
		out.println("<tr><td colspan=\"2\">Parametros Recebidos</td></tr>");
		for (Cidade cidade : listaCidades) {
			out.println("<tr><td>Id:</td><td>" + cidade.getCodigo() + "</td></tr>");
			out.println("<tr>"
					+ "<td>Nome:</td>"
					+ "<td>" + cidade.getNome() + "</td>"
					+ "<td> "
//					+"<a href=\"controllerCidade\"" + cidade.getCodigo() + ">Delete</a>"	
					+"<a href=\"controllerCidade\3>Delete</a>"
					+ "</td>"
					+ "<tr>");
						
		}
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}
}
