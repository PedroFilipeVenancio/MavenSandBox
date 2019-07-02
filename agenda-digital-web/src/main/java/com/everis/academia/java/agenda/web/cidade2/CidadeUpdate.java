package com.everis.academia.java.agenda.web.cidade2;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Cidade;

@WebServlet(name = "CidadeUpdate", urlPatterns = "/CidadeUpdate")
public class CidadeUpdate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static Cidade toBeUpdated;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		Integer codigo =Integer.valueOf(req.getParameter("codigo"))  ;
		String nome = req.getParameter("nome");
		toBeUpdated = new Cidade (codigo,nome);
		

		PrintWriter out = resp.getWriter();
		out.println("<html>"); 
		out.println("<body >"); 
		out.println("<form action=\"CidadeUpdateController\"?antigo=3>"); 
		out.println("<table border=\"1\">"); 
		out.println("<tr><td colspan=\"2\">edite a sua cidade</td></tr>"); 
		out.println( "<tr><td>Nome:</td><td><input type=\"text\" value=\"" + nome +"\" name=\"nome\"/></td></tr>");
		out.println("<tr><td colspan=\"2\" align=\"center\">"); 
		out.println("<input type=\"submit\" value=\"Update\"/>"); 
		out.println("<input type=\"reset\" value=\"Limpar\"/>"); 
		out.println("</td></tr>"); 
		out.println("</table>"); 
		out.println("</form>"); 
		out.println("</body>"); 
		out.println("</html>"); 
	}
}

//out.println("<tr><td>Nome:</td><td>" + cidade.getNome() + "</td><td><a href=\"CidadeReadController?delete=ok&codigo=" + cidade.getCodigo() +"&nome=" + cidade.getNome() + "\">Delete</td>"
//		+"<td><a href=\"CidadeUpdateController?update=ok&codigo=" + cidade.getCodigo() +"&nome=" + cidade.getNome() + "\">Update</td>"
//		+ "</tr>");





