package com.everis.academia.java.agenda.web.cidade;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;
import com.everis.academia.java.agenda.digital.dao.impl.CidadeDAO;
import com.everis.academia.java.agenda.digital.dao.impl.CidadeDAO2;
import com.everis.academia.java.agenda.web.cidade2.exceptions.CidadeException;

import Entity.Cidade;

@WebServlet(name = "CidadeCreateController2", urlPatterns = "/CidadeCreateController2")
public class CidadeCreateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ICidadeBusiness<Cidade> business = new CidadeBusiness();
	private ICidadeDAO<Cidade> dao = new CidadeDAO2();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String nome = req.getParameter("nome");

//		if (!(req.getParameter("nome") == null) && (!(Integer.valueOf(req.getParameter("id")) == null))) {
//		listaCidades.add(new Cidade(Integer.valueOf(req.getParameter("id")), req.getParameter("nome")));	
//	}
//		if (nome == null || nome.trim().isEmpty()) {
//			throw new CidadeException("É obrigatorio");	
//		}

//			if (!nome.matches("[a-zA-Z]+")) {
//				throw new CidadeException("Formato errado");	
//				
//			}

//		// verifica se já existe
//		for (Cidade cidade : CidadeDao.SingleCidade.listaCidades) {
//			if (cidade.getNome().trim().equalsIgnoreCase(nome)) {
//				resp.setStatus(666);
//				throw new CidadeException("já existe");
//			}
//		}
			Cidade cidade = new Cidade();
			cidade.setNome(nome);

			business.create(cidade);
//			resp.sendRedirect(req.getContextPath() + "/teste");

//		CidadeDao.SingleCidade.create(nome);

			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body bgcolorW7tFF0000\">");
			out.println("<table border=\"1\">");
			out.println("<tr><td colspan=\"2\">Cidade Adicionada com Sucesso!</td></tr>");
			for (Cidade cidade2 : dao.read()) {
				out.println("<tr><td>Id:</td><td>" + cidade2.getCodigo() + "</td></tr>");
				out.println("<tr><td>Nome:</td><td>" + cidade2.getNome() + "</td></tr>");
			}
			out.println("</table>");
			out.println("<button onclick=\"window.location.href='/agenda-digital-web'\">Volte ao inicio</button>");
			out.println("</body>");
			out.println("</html>");

		} catch (BusinessException e) {
			throw new ServletException(e);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
}
