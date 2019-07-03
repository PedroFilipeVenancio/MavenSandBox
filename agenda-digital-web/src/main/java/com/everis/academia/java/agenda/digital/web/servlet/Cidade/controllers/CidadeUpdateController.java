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

@WebServlet(name = "CidadeUpdateController", urlPatterns = {
		"/cidade/update/controller" })
public class CidadeUpdateController extends HttpServlet {

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

		// Recupera parametros
		Integer codigo = Integer.valueOf(req.getParameter("codigo"));
		String nome = req.getParameter("nome");

		// Valida Parametros.
		if (nome == null || nome.trim().isEmpty()) {
			throw new ValidationException("Nome Obrigatório");
		}

		// Verifica se já existe cidade com o nome informado.
		for (Cidade cidade : CidadeDAO.cidades) {

			if (cidade.getNome().trim().equalsIgnoreCase(nome)
					&& !cidade.getCodigo().equals(codigo)) {

				throw new ValidationException(
						"Já existe uma outra cidade cadastrada com o mesmo nome");
			}
		}

		// Atualiza Cidade.
		Cidade cidade = new Cidade(codigo, nome);

		int indexOf = CidadeDAO.cidades.indexOf(cidade);
		CidadeDAO.cidades.set(indexOf, cidade);

		// Imprime Mensagem.
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("Registro Atualizado com Sucesso");
		writer.write("</body>");
		writer.write("</html>");
	}
}
