package com.everis.academia.java.agenda.web.cidade;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "Filtro1", urlPatterns = "/*")

public class Filtro1 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String nome = request.getParameter("nome");
		String codigo = request.getParameter("codigo");
		chain.doFilter(request, response);
		String urRequest = ((HttpServletRequest) request).getRequestURI();
		Integer urResponse = ((HttpServletResponse) response).getStatus();
		
		System.out.println("Olha o request:" +urRequest + ", e o nome é: " + nome + ", e o ID é : " + codigo);
		System.out.println(urResponse);
		System.out.println();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
