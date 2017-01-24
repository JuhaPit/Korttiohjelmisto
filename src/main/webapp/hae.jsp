<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Korttiohjelmisto</title>
</head>
<body>

<h1>Hae osoitetta</h1>

<form action="HakuServlet" method="post">

<p>Hakuperuste: <select name="peruste">
  <option value="henkilonNimi">Henkilön nimi</option>
  <option value="osoite">Katuosoite</option>
  <option value="postinro">Postinumero</option>
  <option value="postitmp">Postitoimipaikka</option>
</select> </p>

<p>Haku: <input type="text" name="haku" size="40"></p>

<input type="submit" name="hae" value="Hae">

</form>

<br>

<a href="index.jsp">Palaa etusivulle</a>

</body>
</html>