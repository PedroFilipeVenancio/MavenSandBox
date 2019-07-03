package com.everis.academia.java.agenda.digital.web.servlet.Cidade.controllers;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.web.servlet.Cidade.CidadeDAO;

import Entity.Cidade;

@WebServlet(name = "CidadeDeleteController", urlPatterns = {
		"/cidade/delete/controller" })
public class CidadeDeleteController extends HttpServlet {

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

		// Remove Cidade
		// CODIGO 1
		// Exige implementação do equals() pelo código.
		CidadeDAO.cidades.remove(new Cidade(codigo));

		// CODIGO2
		// Exige implementação do equals() pelo código.
		/*
		 * int index = CidadeDAO.cidades.indexOf(new Cidade(codigo));
		 * CidadeDAO.cidades.remove(index);
		 */

		// CODIGO 3
		// Com loop, sem necessidade de implementação do metodo equals().
		/*
		 * for (int i = 0; i < CidadeDAO.cidades.size(); i++) {
		 * 
		 * Cidade cidade = CidadeDAO.cidades.get(i);
		 * 
		 * if (cidade.getCodigo().equals(codigo)) {
		 * 
		 * CidadeDAO.cidades.remove(i); break; } }
		 */

		// CODIGO 4
		// com loop, com necessidade de implementação do metodo equals().
		/*
		 * for (Cidade cidade : CidadeDAO.cidades) {
		 * 
		 * if (cidade.getCodigo().equals(codigo)) {
		 * 
		 * CidadeDAO.cidades.remove(cidade); break; } }
		 */

		// CODIGO 5
		// Sem loop explicito, sem necessidade de implementação do equals.
		/*
		 * CidadeDAO.cidades.removeIf(cidade ->
		 * cidade.getCodigo().equals(codigo));
		 */
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("Registro Excluído com Sucesso");
		writer.write("</body>");
		writer.write("</html>");
	}
}
