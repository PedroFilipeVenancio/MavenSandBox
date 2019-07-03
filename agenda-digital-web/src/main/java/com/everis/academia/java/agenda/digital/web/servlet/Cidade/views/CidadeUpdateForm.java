package com.everis.academia.java.agenda.digital.web.servlet.Cidade.views;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.web.servlet.Cidade.CidadeDAO;

import Entity.Cidade;

@WebServlet(name = "CidadeUpdateForm", urlPatterns = { "/cidade/update" })
public class CidadeUpdateForm extends HttpServlet {

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
		
		// Recupera parametro
		Integer codigo = Integer.valueOf(req.getParameter("codigo"));

		// Busca Cidade
		int indexOf = CidadeDAO.cidades.indexOf(new Cidade(codigo));
		Cidade cidade = CidadeDAO.cidades.get(indexOf);

		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<form action=\"update/controller\">");
		writer.write("<table>");
		writer.write("<tr>");
		writer.write("<td>Código:</td>");
		writer.write("<td>");
		writer.write("<input type=\"text\" name=\"codigo\" value=\""
				+ cidade.getCodigo() + "\" readonly=\"true\">");
		writer.write("</td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>Nome:</td>");
		writer.write("<td>");
		writer.write("<input type=\"text\" name=\"nome\" value=\""
				+ cidade.getNome() + "\">");
		writer.write("</td>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>");
		writer.write(
				"<input type=\"submit\" name=\"acao\" value=\"Atualizar\"\\>");
		writer.write(
				"<input type= \"reset\" name=\"acao\" value=\"Limpar\"\\>");
		writer.write("</td>");
		writer.write("</tr>");
		writer.write("</table>");
		writer.write("</form>");
		writer.write("</body>");
		writer.write("</html>");
	}
}
