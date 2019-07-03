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

@WebServlet(name = "CidadeReadForm", urlPatterns = { "/cidade/read" })
public class CidadeReadForm extends HttpServlet {

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

		PrintWriter writer = resp.getWriter();

		writer.write("<html>");
		writer.write("<body>");
		writer.write("<a href=\"create\">Criar Nova Cidade</a>");
		writer.write("<table width=\"100%\" border=\"1px\">");
		writer.write("<tr>");
		writer.write("<th width=\"70px\">Código</td>");
		writer.write("<th>");
		writer.write("Nome");
		writer.write("</th>");
		writer.write("<th colspan=\"2\">");
		writer.write("Ações");
		writer.write("</th>");
		writer.write("</tr>");

		for (Cidade cidade : CidadeDAO.cidades) {
			writer.write("<tr>");
			writer.write("<td>" + cidade.getCodigo() + "</td>");
			writer.write("<td>" + cidade.getNome() + "</td>");
			writer.write("<td width=\"70px\"><a href=\"update?codigo="
					+ cidade.getCodigo() + "\">Atualizar</a></td>");
			writer.write(
					"<td width=\"70px\"><a href=\"delete/controller?codigo="
					+ cidade.getCodigo() + "\">Excluir</a></td>");
			writer.write("</tr>");
		}

		writer.write("</table>");
		writer.write("</body>");
		writer.write("</html>");
	}
}