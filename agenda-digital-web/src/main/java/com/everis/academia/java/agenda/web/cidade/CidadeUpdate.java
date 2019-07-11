package com.everis.academia.java.agenda.web.cidade;

//package com.everis.academia.java.agenda.web.cidade;
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
//import Entity.Cidade;
//
//@WebServlet(name = "CidadeUpdate", urlPatterns = "/CidadeUpdate")
//public class CidadeUpdate extends HttpServlet {
//	
//	private static final long serialVersionUID = 1L;
//	public static Cidade toBeUpdated;
//
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		
//		Integer codigo =Integer.valueOf(req.getParameter("codigo"))  ;
//		String nome = req.getParameter("nome");
//		toBeUpdated = new Cidade (codigo,nome);
//
//		PrintWriter out = resp.getWriter();
//		out.println("<html>"); 
//		out.println("<body >"); 
//		out.println("<form action=\"CidadeUpdateController\"?antigo=3>"); 
//		out.println("<table border=\"1\">"); 
//		out.println("<tr><td colspan=\"2\">edite a sua cidade</td></tr>"); 
//		out.println( "<tr><td>Nome:</td><td><input type=\"text\" value=\"" + nome +"\" name=\"nome\"/></td></tr>");
//		out.println("<tr><td colspan=\"2\" align=\"center\">"); 
//		out.println("<input type=\"submit\" value=\"Update\"/>"); 
//		out.println("<input type=\"reset\" value=\"Limpar\"/>"); 
//		out.println("</td></tr>"); 
//		out.println("</table>"); 
//		out.println("</form>"); 
//		out.println("</body>"); 
//		out.println("</html>"); 
//	}
//}

//out.println("<tr><td>Nome:</td><td>" + cidade.getNome() + "</td><td><a href=\"CidadeReadController?delete=ok&codigo=" + cidade.getCodigo() +"&nome=" + cidade.getNome() + "\">Delete</td>"
//		+"<td><a href=\"CidadeUpdateController?update=ok&codigo=" + cidade.getCodigo() +"&nome=" + cidade.getNome() + "\">Update</td>"
//		+ "</tr>");



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.business.Cidade.CidadeBusiness;
import com.everis.academia.java.agenda.digital.business.Cidade.ICidadeBusiness;
import com.everis.academia.java.agendadigital.entity.Cidade;

@WebServlet(name = "CidadeUpdate", urlPatterns = "/CidadeUpdate")
public class CidadeUpdate extends HttpServlet {


	private ICidadeBusiness business = new CidadeBusiness();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException,
			IOException {
		
		// Recupera parametro
		Integer codigo = Integer.valueOf(req.getParameter("codigo"));

		// Busca Cidade
//		int indexOf = CidadeDAO.cidades.indexOf(new Cidade(codigo));
//		Cidade cidade = CidadeDAO.cidades.get(indexOf);
		
		Cidade cidade = business.getById(codigo);
		
//				for (Cidade cidade2 : business.read()) {
//					if (cidade2.equals(new Cidade(codigo))) {
//						cidade = cidade2;
//					}
//				}
		
//		int indexOf = dao.read().indexOf(new Cidade(codigo));
//		Cidade cidade = dao.read().get(indexOf);

		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<form action=\"CidadeUpdateController2\">");
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




