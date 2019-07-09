package com.everis.academia.java.agenda.web.cidade;

//package com.everis.academia.java.agenda.web.cidade;

//
//
//import java.io.IOException;
//
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.everis.academia.java.agenda.web.cidade2.exceptions.CidadeException;
//
//import Entity.Cidade;
//
//@WebServlet(name = "CidadeUpdateController", urlPatterns = "/CidadeUpdateController")
//public class CidadeUpdateController extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
////		CidadeDao.SingleCidade.delete(CidadeUpdate.toBeUpdated);
//
//		String nome = req.getParameter("nome");
//		
//		
//		if (nome == null || nome.trim().isEmpty()) {
//			resp.setStatus(666);
//			throw new CidadeException("É obrigatorio");	
//		}
//		
////		for (Cidade cidade : CidadeDao.SingleCidade.listaCidades) {
////			if (cidade.getNome().trim().equalsIgnoreCase(nome) && !cidade.getCodigo().equals(CidadeUpdate.toBeUpdated.getCodigo())) {
////				throw new CidadeException("já existe");
////			}
////		}
//		
//		CidadeDao.SingleCidade.create(nome);
//		
//		PrintWriter out = resp.getWriter();
//		out.println("<html>");
//		out.println("<body bgcolorW7tFF0000\">");
//		out.println("<table border=\"1\">");
//		out.println("<tr><td colspan=\"2\">Cidade Adicionada</td></tr>");
//		for (Cidade cidade : CidadeDao.SingleCidade.read()) {
//			out.println("<tr><td>Id:</td><td>" + cidade.getCodigo() + "</td></tr>");
//			out.println("<tr><td>Nome:</td><td>" + cidade.getNome() + "</td></tr>");						
//		}		
//		out.println("</table>");
//		out.println("<button onclick=\"window.location.href='/agenda-digital-web'\">Volte ao inicio</button>");
//		out.println("</body>");
//		out.println("</html>");
//	}
//}

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.Cidade.CidadeBusiness;
import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agenda.digital.dao.Cidade.CidadeDAO;
import com.everis.academia.java.agenda.digital.web.servlet.Cidade.ValidationException;

import Entity.Cidade;

@WebServlet(name = "CidadeUpdateController2", urlPatterns = "/CidadeUpdateController2")
public class CidadeUpdateController extends HttpServlet {

	private ICidadeBusiness<Cidade> business = new CidadeBusiness();
	private IGeralDAO<Cidade> dao = new CidadeDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// // Recupera parametros
			Integer codigo = Integer.valueOf(req.getParameter("codigo"));
			String nome = req.getParameter("nome");
			//
			// // Valida Parametros.
			// if (nome == null || nome.trim().isEmpty()) {
			// throw new ValidationException("Nome Obrigatório");
			// }
			//
			// // Verifica se já existe cidade com o nome informado.
			// for (Cidade cidade : CidadeDAO.cidades) {
			//
			// if (cidade.getNome().trim().equalsIgnoreCase(nome)
			// && !cidade.getCodigo().equals(codigo)) {
			//
			// throw new ValidationException(
			// "Já existe uma outra cidade cadastrada com o mesmo nome");
			// }
			// }

			// Atualiza Cidade.
			Cidade cidade = new Cidade(codigo, nome);

			cidade.setNome(nome);
			cidade.setCodigo(codigo);

			business.update(cidade);

//			int indexOf = CidadeDAO.cidades.indexOf(cidade);
//			CidadeDAO.cidades.set(indexOf, cidade);

			// Imprime Mensagem.
			PrintWriter writer = resp.getWriter();
			writer.write("<html>");
			writer.write("<body>");
			writer.write("Registro Atualizado com Sucesso");
			writer.println("<table border=\"1\">");
			writer.println("<tr><td colspan=\"2\">Cidade Apagada</td></tr>");
			for (Cidade cidade2 : dao.read()) {
				writer.println("<tr><td>Id:</td><td>" + cidade2.getCodigo() + "</td></tr>");
				writer.println("<tr><td>Nome:</td><td>" + cidade2.getNome() + "</td></tr>");						
			}		
			writer.println("</table>");
			writer.println("<button onclick=\"window.location.href='/agenda-digital-web'\">Volte ao inicio</button>");
			writer.write("</body>");
			writer.write("</html>");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
