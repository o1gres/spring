<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> ${utentiString} </p>

<table border="1">
	<tr>
		<td>Nome</td>
		<td>Età</td>
		<td>Sesso</td>
	</tr>
  <c:forEach items="${utentiList}" var="item">
    <tr>
      <td><c:out value="${item.name}" /></td>
      <td><c:out value="${item.eta}" /></td>
      <td>
	      	<c:choose>
			    <c:when test="${item.sesso=='1'}">
			        Maschio
			    </c:when>    
			    <c:otherwise>
			        Femmina
			    </c:otherwise>
			</c:choose>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
