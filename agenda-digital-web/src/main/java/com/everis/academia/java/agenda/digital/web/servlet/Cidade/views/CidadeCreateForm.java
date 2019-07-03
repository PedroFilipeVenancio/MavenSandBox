package com.everis.academia.java.agenda.digital.web.servlet.Cidade.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CidadeCreateForm", urlPatterns = { "/cidade/create" })
public class CidadeCreateForm extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException,
			IOException {

		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<form action=\"create/controller\">");
		writer.write("<table>");
		writer.write("<tr>");
		writer.write("<td>Nome:</td>");
		writer.write("<td><input type=\"text\" name=\"nome\"></td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>");
		writer.write("<input type=\"submit\" name=\"acao\" value=\"Criar\"\\>");
		writer.write("<input type= \"reset\" name=\"acao\" value=\"Limpar\"\\>");
		writer.write("</td>");
		writer.write("</tr>");
		writer.write("</table>");
		writer.write("</form>");
		writer.write("</body>");
		writer.write("</html>");
	}
}
