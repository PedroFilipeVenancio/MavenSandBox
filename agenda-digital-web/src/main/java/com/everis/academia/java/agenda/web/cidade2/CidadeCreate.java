package com.everis.academia.java.agenda.web.cidade2;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Cidade;

@WebServlet(name = "CidadeCreate", urlPatterns = "/CidadeCreate")
public class CidadeCreate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		out.println("<html>"); 
		out.println("<body >"); 
		out.println("<form action=\"controllerCidade\">"); 
		out.println("<table border=\"1\">"); 
		out.println("<tr><td colspan=\"2\">Crie a sua cidade</td></tr>"); 
//		out.println( "<tr><td>Id:</td><td><input type=\"text\" name=\"id\"/></td></tr>"); 
		out.println( "<tr><td>Nome:</td><td><input type=\"text\" name=\"nome\"/></td></tr>"); 
		out.println("<tr><td colspan=\"2\" align=\"center\">"); 
		out.println("<input type=\"submit\" value=\"Criar\"/>"); 
		out.println("<input type=\"reset\" value=\"Limpar\"/>"); 
		out.println("</td></tr>"); 
		out.println("</table>"); 
		out.println("</form>"); 
		out.println("</body>"); 
		out.println("</html>"); 
	}
}


