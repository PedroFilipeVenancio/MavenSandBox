<%@page import="com.everis.academia.java.agenda.digital.business.ICidadeBusiness"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%-- <%@page import="com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness"%> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="cidadeBusiness" class="com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness"/>

<!DOCTYPE html>

<html>
<body>
	<form action="/CidadeReadController2">
		<table border="1">
			<tr>
				<td colspan="2">Cidades Disponiveis</td>
			</tr>		

			<c:forEach items="${cidadeBusiness.read()}" var="cidade">
				<tr>
					<td>Id:</td>
					<td>${cidade.codigo}</td>
				</tr>

				<tr>
					<td>Nome:</td>
					<td>${cidade.nome}</td>
				<td><a href="<%=request.getContextPath()%>/CidadeReadController?delete=ok&codigo=${cidade.codigo}&nome=${cidade.nome}">Delete</a></td>
				
				<td><a href="<%=request.getContextPath()%>/jsp/cidade//update.jsp?update=ok&codigo=${cidade.getCodigo()}&nome=${cidade.getNome()}">Update</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
