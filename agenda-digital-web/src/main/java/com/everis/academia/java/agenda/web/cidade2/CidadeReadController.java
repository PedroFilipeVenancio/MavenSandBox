package com.everis.academia.java.agenda.web.cidade2;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CidadeReadController", urlPatterns = "/CidadeReadController")
public class CidadeReadController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String nome = req.getParameter("nome");
		Integer idade =Integer.valueOf(req.getParameter("idade"))  ;
		Double salario = Double.valueOf(req.getParameter("salario"));
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body bgcolorW7tFF0000\">");
		out.println("<table border=\"1\">");
		out.println("<tr><td colspan=\"2\">Parametros Recebidos</td></tr>");
		out.println("<tr><td>Nome:</td><td>" + nome + "</td></tr>");
		out.println("<tr><td>Idade:</td><td>" + idade + "</td></tr>");
		out.println("<tr><td>Salario:</td><td>" + salario + "</td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");

	}
}

