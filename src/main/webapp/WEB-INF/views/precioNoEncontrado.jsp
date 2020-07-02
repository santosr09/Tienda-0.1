<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/estilos.css">
<title>P&aacute;gina para Consultar Precios</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body id="agrupar", onFocus="claveInput.focus()", onLoad="claveInput.focus()">
<h1>
    No existe producto con esa clave
</h1>
<c:url var="searchAction" value="/precios/search" ></c:url>
<form:form action="${searchAction}" commandName="producto">
<tr>
        <td>
            <form:label path="clave">
                <spring:message text="Clave"/>
            </form:label>
        </td>
        <td>
            <form:input id="claveInput" 
            onfocus="if (this.value != '') {this.value = '';}" path="clave" />
        </td> 
    </tr>
    <tr>
        <td>
            <input type="submit"
                    value="<spring:message text="Buscar"/>" />
        </td>
    </tr>
</form:form>
<br>
</body>
</html>