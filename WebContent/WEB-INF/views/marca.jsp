<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/estilos.css">
<title>P&aacute;gina para Marcas</title>
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
<body id="agrupar">
<h1>
    Agregar una Marca
</h1>
 
<c:url var="addAction" value="/marca/add" ></c:url>
 
<form:form action="${addAction}" commandName="marca">
<table>
    <c:if test="${!empty marca.descripcion}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="descripcion">
                <spring:message text="Descripcion"/>
            </form:label>
        </td>
        <td>
            <form:input path="descripcion" />
        </td> 
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty marca.descripcion}">
                <input type="submit"
                    value="<spring:message text="Editar"/>" />
            </c:if>
            <c:if test="${empty marca.descripcion}">
                <input type="submit"
                    value="<spring:message text="Agregar"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Listado de Marcas</h3>
<c:if test="${!empty listMarcas}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Descripcion</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listMarcas}" var="marca">
        <tr>
            <td>${marca.id}</td>
            <td>${marca.descripcion}</td>
            <td><a href="<c:url value='/edit/${marca.id}' />" >Modificar</a></td>
            <td><a href="<c:url value='/remove/${marca.id}' />" >Eliminar</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>