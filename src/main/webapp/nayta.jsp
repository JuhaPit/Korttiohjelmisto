<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Korttiohjelmisto</title>
</head>
<body>

<h1>Tallennetut osoitteet</h1>

<c:forEach items="${osoitteet}" var="os">
					
<c:out value="${os.henkilonNimi}" /><br>
<c:out value="${os.osoite}" /><br>
<c:out value="${os.postinro}" /><br>
<c:out value="${os.postitmp}" /><br><br><br>

</c:forEach>

<a href="index.jsp">Palaa etusivulle</a>



</body>
</html>