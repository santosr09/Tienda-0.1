<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/estilos.css">
<title>P&aacute;gina para Productos</title>
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
<body id="agrupar", onLoad="clave.focus()">
<h1>
    Agregar Productos
</h1>
<c:url var="addAction" value="/producto/add" ></c:url>
<form:form action="${addAction}" commandName="producto">
<table>
    <c:if test="${!empty producto.descripcion}">
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
        
        <td>
            <form:label path="clave">
                <spring:message text="CLAVE:"/>
            </form:label>
        </td>
        <td>
            <form:input path="clave" readonly="true" size="8"  disabled="true" />
            <form:hidden path="clave" />
        </td>
        
        <td>
            <form:label path="claveAlterna">
                <spring:message text="CLAVE ALTERNA:"/>
            </form:label>
        </td>
        <td>
            <form:input path="claveAlterna" readonly="true" size="8"  disabled="true" />
            <form:hidden path="clave" />
        </td>
         
        <td>
            <form:label path="descripcion">
                <spring:message text="PRODUCTO:"/>
            </form:label>
        </td>
        <td>
            <form:input path="descripcion" readonly="true" size="8"  disabled="true" />
            <form:hidden path="descripcion" />
        </td>
        
        <td>
            <form:label path="presentacionVenta">
                <spring:message text="PRESENTACION:"/>
            </form:label>
        </td>
        <td>
            <form:input path="presentacionVenta" readonly="true" size="8"  disabled="true" />
            <form:hidden path="presentacionVenta" />
        </td>
        
        <td>
            <form:label path="presentacion">
                <spring:message text="PRESENTACION COMPRA:"/>
            </form:label>
        </td>
        <td>
            <form:input path="presentacionCompra" readonly="true" size="8"  disabled="true" />
            <form:hidden path="presentacionCompra" />
        </td>
        
        <td>
            <form:label path="precioVenta">
                <spring:message text="PRECIO:"/>
            </form:label>
        </td>
        <td>
            <form:input path="precioVenta" readonly="true" size="8"  disabled="true" />
            <form:hidden path="precioVenta" />
        </td>
        
        <td>
            <form:label path="marca">
                <spring:message text="MARCA:"/>
            </form:label>
        </td>
        <td>
            <form:input path="marca" readonly="true" size="8"  disabled="true" />
            <form:hidden path="marca" />
        </td>
        
        <td>
            <form:label path="categoria">
                <spring:message text="CATEGORIA:"/>
            </form:label>
        </td>
        <td>
            <form:input path="categoria" readonly="true" size="8"  disabled="true" />
            <form:hidden path="categoria" />
        </td>
        
        <td>
            <form:label path="precioCompra">
                <spring:message text="PRECIO DE COMPRA:"/>
            </form:label>
        </td>
        <td>
            <form:input path="precioCompra" readonly="true" size="8"  disabled="true" />
            <form:hidden path="precioCompra" />
        </td>
        
        <td>
            <form:label path="precioVenta">
                <spring:message text="PRECIO DE VENTA:"/>
            </form:label>
        </td>
        <td>
            <form:input path="precioVenta" readonly="true" size="8"  disabled="true" />
            <form:hidden path="precioVenta" />
        </td>
        
        <td>
            <form:label path="existActual">
                <spring:message text="EXISTENCIA ACTUAL:"/>
            </form:label>
        </td>
        <td>
            <form:input path="existenciaActual" readonly="true" size="8"  disabled="true" />
            <form:hidden path="existenciaActual" />
        </td>
        
        <td>
            <form:label path="existMaxima">
                <spring:message text="EXISTENCIA MAXIMA:"/>
            </form:label>
        </td>
        <td>
            <form:input path="existenciaMaxima" readonly="true" size="8"  disabled="true" />
            <form:hidden path="existenciaMaxima" />
        </td>
        
        <td>
            <form:label path="existMinima">
                <spring:message text="EXISTENCIA MINIMA:"/>
            </form:label>
        </td>
        <td>
            <form:input path="existenciaMinima" readonly="true" size="8"  disabled="true" />
            <form:hidden path="existenciaMinima" />
        </td>
        
        <td>
            <form:label path="lote">
                <spring:message text="LOTE:"/>
            </form:label>
        </td>
        <td>
            <form:input path="lote" readonly="true" size="8"  disabled="true" />
            <form:hidden path="lote" />
        </td>
        
        <td>
            <form:label path="caducidad">
                <spring:message text="CADUCIDAD:"/>
            </form:label>
        </td>
        <td>
            <form:input path="caducidad" readonly="true" size="8"  disabled="true" />
            <form:hidden path="caducidad" />
        </td>
    </tr>
    </c:if>
    
    <!-- TERMINA IF -->
    <tr>
        <td>
            <form:label path="clave">
                <spring:message text="Clave"/>
            </form:label>
        </td>
        <td>
            <form:input id="clave" path="clave" />
        </td> 
    </tr>
        <tr>
        <td>
            <form:label path="claveAlterna">
                <spring:message text="Clave Alterna"/>
            </form:label>
        </td>
        <td>
            <form:input id="claveAlterna" path="claveAlterna" />
        </td> 
    </tr>
    <tr>
    </tr>
    <tr>    
        <td>
            <form:label path="descripcion">
                <spring:message text="PRODUCTO:"/>
            </form:label>
        </td>
        <td>
            <form:input id="descripcion" path="descripcion" />
        </td>
     </tr>
     <tr>
        <td>
            <form:label path="presentacionVenta">
                <spring:message text="PRESENTACION:"/>
            </form:label>
        </td>
        <td>
            <form:input id="presentacionVenta" path="presentacionVenta"/>
        </td>
     </tr>
     <tr>
        <td>
            <form:label path="presentacionCompra">
                <spring:message text="PRESENTACION COMPRA:"/>
            </form:label>
        </td>
        <td>
            <form:input id="presentacionCompra" path="presentacionCompra"/>
        </td>
     </tr>
     <tr>   
        <td>
            <form:label path="precioVenta">
                <spring:message text="PRECIO:"/>
            </form:label>
        </td>
        <td>
            <form:input id="precioVenta" path="precioVenta" />
        </td>
     </tr>
     <tr>   
        <td>
            <form:label path="marca">
                <spring:message text="MARCA:"/>
            </form:label>
        </td>
        <td>
            <form:input id="marca" path="marca"/>
        </td>
     </tr>
     <tr>  
        <td>Categoria: </td>
        <td>
            <form:select path="categoria">
                <form:option value="NONE" label="-- Selecciona --" />
                <form:options items="${listCategorias}" />
            </form:select>
        </td>
     </tr>
     <tr>
        <td>
            <form:label path="precioCompra">
                <spring:message text="PRECIO DE COMPRA:"/>
            </form:label>
        </td>
        <td>
            <form:input id="precioCompra" path="precioCompra"/>
        </td>
     </tr>
     <tr>
        <td>
            <form:label path="precioVenta">
                <spring:message text="PRECIO DE VENTA:"/>
            </form:label>
        </td>
        <td>
            <form:input id="precioVenta" path="precioVenta"/>
        </td>
     </tr>
     <tr>
        <td>
            <form:label path="existenciaActual">
                <spring:message text="EXISTENCIA ACTUAL:"/>
            </form:label>
        </td>
        <td>
            <form:input id="existenciaActual" path="existenciaActual"/>
        </td>
     </tr>
     <tr>   
        <td>
            <form:label path="existenciaMaxima">
                <spring:message text="EXISTENCIA MAXIMA:"/>
            </form:label>
        </td>
        <td>
            <form:input id="existenciaMaxima" path="existenciaMaxima"/>
        </td>
     </tr>
     <tr>   
        <td>
            <form:label path="existenciaMinima">
                <spring:message text="EXISTENCIA MINIMA:"/>
            </form:label>
        </td>
        <td>
            <form:input id="existenciaMinima" path="existenciaMinima"/>
        </td>
     </tr>
     <tr>
        
        <td>
            <form:label path="lote">
                <spring:message text="LOTE:"/>
            </form:label>
        </td>
        <td>
            <form:input id="lote" path="lote"/>
        </td>
     </tr>
     <tr>
        <td>
            <form:label path="caducidad">
                <spring:message text="CADUCIDAD:"/>
            </form:label>
        </td>
        <td>
            <form:input id="caducidad" path="caducidad"/>
        </td>
    </tr>
    
    <tr>
        <td colspan="2">
            <c:if test="${!empty producto.descripcion}">
                <input type="submit"
                    value="<spring:message text="Modificar"/>" />
            </c:if>
            <c:if test="${empty producto.descripcion}">
                <input type="submit"
                    value="<spring:message text="Agregar Producto"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Listado de Productos</h3>
<c:if test="${!empty listProducto}">
    <table class="tg">
    <tr>
        <th>ID</th>
        <th>Clave</th>
        <th>Descripcion</th>
        <th>Marca</th>
        <th>Presentacion</th>
        <th>Precio</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${listProducto}" var="producto">
        <tr>
            <td>${producto.id}</td>
            <td>${producto.clave}</td>
            <td>${producto.descripcion}</td>
            <td>${producto.marca}</td>
            <td>${producto.presentacionVenta}</td>
            <td>${producto.precioVenta}</td>
            <td><a href="<c:url value='/editProducto/${producto.id}' />" >Modificar</a></td>
            <td><a href="<c:url value='/removeProducto/${producto.id}' />" >Eliminar</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>