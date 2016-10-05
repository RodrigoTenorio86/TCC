<%@ page import="br.com.wsrest.lista.ResourceFileList"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/cabecalho.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina de Exclusao do arquivos</title>
</head>
<body>
   Quais Arquivos Deseja Excluir:<br />
	<form action="rest/delete/resourceDelete" method="post">
		<jsp:useBean id="dao" class="br.com.wsrest.lista.ResourceFileList" />
		<c:forEach var="nameFile" items="${dao.getList()}">
		    <input type="radio" name="fileName" value="${nameFile.value}">${nameFile.key}<br/>
		</c:forEach>
		<input type="submit" value="Excluir">
	</form>

</body>
<c:import url="/rodape.jsp" />
</html>