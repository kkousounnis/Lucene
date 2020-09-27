<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
</head>
<body>
<table border=1>
	<thead>
		<tr>
			<th>NUMBER</th>
			<th>ISBN</th>
			<th>Title-TextStart</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.Texts}" var="T1">
			<tr>
				<td><c:out value="${T1.counter}"/></td>
				<td><c:out value="${T1.isbn}"/></td>
				<td>Title:<c:out value="${T1.title}"/></td>
				<td><a href="UserController?action=ViewFullText&isbn=<c:out value="${T1.isbn}"/>">ViewFullText</a></td>
				
			</tr>
		</c:forEach>
			
	</tbody>
</table>	

<a href="Index.jsp">StartPage</a>
</body>
</html>