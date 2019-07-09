<%@page import="Entity.Cidade"%>
<%@page
	import="com.everis.academia.java.agenda.digital.business.Cidade.CidadeBusiness"%>
<%@page
	import="com.everis.academia.java.agenda.digital.business.IGeralBusiness"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<form action="<%=request.getContextPath()%>/CidadeUpdateController2">
		<table border="1">
			<tr>
				<td colspan="2">Actualizar</td>
			</tr>
			<%!private IGeralBusiness<Cidade> cidadebusiness = new com.everis.academia.java.agenda.digital.business.Cidade.CidadeBusiness();%>
			<%
				Integer codigo = Integer.valueOf(request.getParameter("codigo"));

				Cidade cidade = (Cidade) cidadebusiness.getById(codigo);
			%>
			<tr>
				<td>Codigo:</td>
				<td><input type="text" name="codigo"
					value="<%=cidade.getCodigo()%>" /></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome"
					value="<%=cidade.getNome()%>" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Update"><a href="read.jsp"></a></td>
			</tr>
		</table>
	</form>
	<br>
	<a href="<%=request.getContextPath()%>/jsp/cidade/inicio.jsp"
		target="self"><input type="submit" Value="Inicio"></a>
</body>
</html>
