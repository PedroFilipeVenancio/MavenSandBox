package com.everis.academia.java.agenda.digital.web.servlet.Cidade.controllers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.web.servlet.Cidade.CidadeDAO;
import com.everis.academia.java.agenda.digital.web.servlet.Cidade.ValidationException;

import Entity.Cidade;

@WebServlet(name = "CidadeCreateController", urlPatterns = {
		"/cidade/create/controller" })
public class CidadeCreateController extends HttpServlet {

	private int id = 0;

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

		// Recupera Parametros.
		String nome = req.getParameter("nome");

		// Valida Parametros.
		if (nome == null || nome.trim().isEmpty()) {
			throw new ServletException("Nome Obrigatório");
		}

		// Verifica se já existe cidade com o nome informado.
		for (Cidade cidade : CidadeDAO.cidades) {

			if (cidade.getNome().trim().equalsIgnoreCase(nome)) {

				throw new ValidationException(
						"Já existe uma cidade cadastrada com o mesmo nome");
			}
		}

		// Adiciona Cidade.
		Cidade cidade = new Cidade();
		cidade.setCodigo(id++);
		cidade.setNome(nome);

		CidadeDAO.cidades.add(cidade);

		// Imprime Mensagem.
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("Registro Incluído com Sucesso");
		writer.write("</body>");
		writer.write("</html>");
	}
}
