<%@page import="com.everis.academia.java.agenda.digital.business.Cidade.CidadeBusiness"%>
<%@page import="com.everis.academia.java.agenda.digital.business.Cidade.ICidadeBusiness"%>
<%@page import="com.everis.academia.java.agendadigital.entity.Cidade"%>
<%@page import="com.everis.academia.java.agenda.digital.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<table border="1">
		<tr>
			<td colspan="5">Parametros Recebido</td>
		</tr>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th colspan="2">Ação</th>
		</tr>
		<%!private ICidadeBusiness business = new com.everis.academia.java.agenda.digital.business.Cidade.CidadeBusiness();%>
		<%
			for (Cidade cidade : business.read()) {
		%>
		<tr>
			<td><%=cidade.getCodigo()%></td>
			<td><%=cidade.getNome()%></td>
			<td><a href="update.jsp?codigo=<%=cidade.getCodigo()%>">Actualizar</a></td>
			<td><a
				href="<%=request.getContextPath()%>/cidade/delete/controller?codigo=<%=cidade.getCodigo()%>">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<a href="/jsp/cidade/create.jsp" target="self"><input type="submit"
		Value="Criar Cidade"></a>
	<a href="/jsp/cidade/inicio.jsp" target="self"><input type="submit"
		Value="Inicio"></a>
</body>
</html>