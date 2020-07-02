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
	<h1>Precio del Producto</h1>
	
	<c:url var="searchAction" value="/precios/search" ></c:url>
<form:form action="${searchAction}" commandName="producto">
	
	<%-- <c:url var="searchAction" value="/precios"></c:url>
	<form:form action="${searchAction}" commandName="producto" method="GET"> --%>
		<table>
			<tr>
				<td><form:label path="descripcion">
						<spring:message text="PRODUCTO: " />
					</form:label></td>
				<td>
					<h2>${producto.descripcion}</h2>
				</td>
			</tr>

			<td><form:label path="presentacionVenta">
					<spring:message text="PRESENTACION: " />
				</form:label></td>
			<td>
				<h2>${producto.presentacionVenta}</h2>
			</td>

			<td><form:label path="precioVenta">
					<spring:message text="PRECIO: " />
				</form:label></td>
			<td>
				<h1>${producto.precioVenta}</h1>
			</td>
			<tr>
        <td>
            <form:label path="clave">
                <spring:message text="Clave"/>
            </form:label>
        </td>
        <td>
            <form:input id="claveInput" path="clave" 
            onfocus="if (this.value != '') {this.value = '';}"/>
        </td> 
    </tr>
    <tr>
        <td>
            <input type="submit"
                    value="<spring:message text="Buscar"/>" />
        </td>
    </tr>
		</table>
	</form:form>
	<br>
</body>
</html>