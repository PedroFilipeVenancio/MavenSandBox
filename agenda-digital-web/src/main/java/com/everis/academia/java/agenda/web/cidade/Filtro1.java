package com.everis.academia.java.agenda.web.cidade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
		chain.doFilter(request, response);
		String urRequest = ((HttpServletRequest) request).getRequestURI();
		Integer urResponse = ((HttpServletResponse) response).getStatus();

		Enumeration<String> names = request.getParameterNames();

		for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
			String name = e.nextElement();
			String value = (request.getParameter(name) == null ? "nulo" : request.getParameter(name));
			System.out.println("Olha o request � o: " +urRequest + ", e o nome do parametro � o : " + name + ", e o seu valor �: " + value);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
