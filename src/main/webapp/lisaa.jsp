<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Korttiohjelmisto</title>
</head>
<body>

<h1>Lisää uusi osoite</h1>

<form action="LisaaServlet" method="post">
<p>Vastaanottajan nimi:</p>
<input type="text" name="henkilonNimi" size="40">

<p>Katuosoite:</p>
<input type="text" name="osoite" size="40">

<p>Postinumero:</p>
<input type="text" name="postinro" size="40">

<p>Postitoimipaikka:</p> 
<input type="text" name="postitmp" size="40">

<br>
<br>
<input type="submit" name="tallenna" value="Tallenna">

</form>
<br>
<br>
<a href="index.jsp">Palaa etusivulle</a>

</body>
</html>