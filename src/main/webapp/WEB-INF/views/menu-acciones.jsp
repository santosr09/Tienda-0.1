<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="UTF-8" ?>
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="false"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<div class = "btn-group-vertical">

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>



    	<a type="button" class="btn btn-default" href="${contextPath}/ventas/crea-nota"><h4>Ventas</h4></a>
    	<a type="button" class="btn btn-default" href="${contextPath}/compras/crea-nota"><h4>Compras</h4></a>
    	<button type="button" class="btn btn-default"><h4>Inventario</h4></button>
  		<button type="button" class="btn btn-default"><h4>Productos</h4></button>
<%--   		<button type="button" class="btn btn-default" href="location.href='${precioUrl}'"><h4>Precios</h4></button> --%>
  		<a type="button" class="btn btn-default" href="precios"><h4>Precios</h4></a>
	</div>
</html>