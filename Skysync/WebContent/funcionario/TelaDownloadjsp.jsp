<%@ page import="br.com.wsrest.lista.ResourceFileList"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="rest/download/resource" method="post">
		<jsp:useBean id="dao" class="br.com.wsrest.lista.ResourceFileList" />
		<c:forEach var="file" items="${dao.getList()}">
			<c:out value="${file.value}" name="fileName"></c:out>
			 
		</c:forEach>

		<input type="submit" value="Download" />
	</form>

</body>
</html>