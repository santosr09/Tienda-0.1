<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/estilos.css">
<title>P&aacute;gina para Categorias</title>
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
    Agregar una Categoría
</h1>
 
<c:url var="addAction" value="/categoria/add" ></c:url>
 
<form:form action="${addAction}" commandName="categoria">
<table>
    <c:if test="${!empty categoria.descripcion}">
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
            <c:if test="${!empty categoria.descripcion}">
                <input type="submit"
                    value="<spring:message text="Editar Categoria"/>" />
            </c:if>
            <c:if test="${empty categoria.descripcion}">
                <input type="submit"
                    value="<spring:message text="Agregar Categoria"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Listado de Categorias</h3>
<c:if test="${!empty listCategoria}">
    <table class="tg">
    <tr>
        <th width="80">Categoria ID</th>
        <th width="120">Categoria Descripcion</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listCategoria}" var="categoria">
        <tr>
            <td>${categoria.id}</td>
            <td>${categoria.descripcion}</td>
            <td><a href="<c:url value='/edit/${categoria.id}' />" >Modificar</a></td>
            <td><a href="<c:url value='/remove/${categoria.id}' />" >Eliminar</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>