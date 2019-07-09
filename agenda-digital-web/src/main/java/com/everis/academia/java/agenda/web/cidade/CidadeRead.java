package com.everis.academia.java.agenda.web.cidade;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agenda.digital.dao.Cidade.CidadeDAO;

import Entity.Cidade;

@WebServlet(name = "CidadeRead", urlPatterns = "/CidadeRead")
public class CidadeRead extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ICidadeBusiness<Cidade> business = new CidadeBusiness();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		PrintWriter out = resp.getWriter();
		out.println("<html>"); 
		out.println("<body >"); 
		out.println("<form action=\"CidadeReadController\">"); 
		out.println("<table border=\"1\">"); 
		out.println("<tr><td colspan=\"2\">Cidades Disponiveis</td></tr>"); 
		for (Cidade cidade : business.read()) {
			out.println("<tr><td>Id:</td><td>" + cidade.getCodigo() + "</td></tr>");
			out.println("<tr><td>Nome:</td><td>" + cidade.getNome() + "</td><td><a href=\"CidadeReadController?delete=ok&codigo=" + cidade.getCodigo() +"&nome=" + cidade.getNome() + "\">Delete</td>"
					+"<td><a href=\"CidadeUpdate?update=ok&codigo=" + cidade.getCodigo() +"&nome=" + cidade.getNome() + "\">Update</td>"
					+ "</tr>");
			
		}			
		out.println("<tr><td colspan=\"2\" align=\"center\">"); 
		out.println("</td></tr>"); 
		out.println("</table>"); 
		out.println("</form>"); 
		out.println("</body>"); 
		out.println("</html>"); 
	}
}





