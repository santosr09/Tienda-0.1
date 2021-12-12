<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tienda 1.0</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <!-- <link href="resources/datatables/media/css/jquery.dataTables.css" rel="stylesheet"> -->
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  -->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
    
    <script>

$(document).ready(function(){

        $("#claveInput").focus();
	
	    $( "#notaTable tbody tr" ).on( "change", function() {
		  var row = $(this).find("#rowNum").text();
		  var cantidad = parseFloat($(this).find("#cantidadInput").val()).toFixed(2);


		  var cantInput = $(this).find("#cantidadInput");
		  var totLinea = $(this).find("#totalLinea");

	    	console.log('RowNum: '+ row);
	    	$.post("/Tienda/compras/updateQty", { rowNum: row, cantidadInput: cantidad })
	            	.done(function(data, status){
	                	var htmlTotLinea = ""+data[row-1].totalLinea+"";
	                	cantInput.html(cantidad);
	                	totLinea.html(htmlTotLinea);
	            	});
	        $("#claveInput").focus();
	    });
    
});

</script>


  </head>
  <body>
  
   <div class="container">
  <div class = "page-header">
   
   <h2>
      Tienda 0.1 V
   </h2>
   
  </div>
  
  <div class="container">
    
    <div class = "row" >
    
    <div class="col-md-2">
    	<%@ include file="menu-acciones.jsp" %>
	</div>
  
  
	<div class="col-md-10">
	<%-- <c:url var="searchAction" value="/precios/search" ></c:url> --%>
	
	<div class="panel panel-default">
  	
  	<div class="panel-heading"><h3>Nota de COMPRA:  <p:spinner />   ${nota.id} </h3></div>
  	
  	<div class="panel-body">
  	<c:url var="searchAction" value="/compras/${nota.id}/agregar-producto" ></c:url>
    	<form:form action="${searchAction}" commandName="producto" id="search-form" role = "form">
		
		<form:label path="producto.clave">
        	<spring:message text="Clave"/>
        </form:label>
		<form:input id="claveInput" path="producto.clave" tabindex="1"/>
		<input type="submit" id="button-search"
			value="<spring:message text="Buscar"/>" />

		</form:form>
	</div>

  	<!-- Table -->
  	<table  class="table table-fixed" id="notaTable">
  	<c:url var="cobrarAction" value="/compras/cobrar" ></c:url>
  	<form:form action="${cobrarAction}" commandName="nota" id="nota-form" role = "form">
  		<thead>
  			<tr>
  				<th class='col-md-1'>No.</th>
  				<th class='col-md-2'>Cantidad</th>
  				<th class='col-md-5'>Producto</th>
  				<th class='col-md-2'>Precio Unit.</th>
  				<th class='col-md-1'>Total</th>
  			</tr>
  		</thead>
  			
  		<tbody>
  			<c:forEach items="${nota.detalleCompra}" var="item">
                    <tr>
                    	<td id='rowNum' class='col-md-1'>${item.rowNum}</td>
                    	<td id='cantidad' class='col-md-1'>
                    	    <input type="text" class="form-control col-md-1"  id='cantidad${item.rowNum}' path='item.unidades' value="${item.unidades}"/>
                    	</td>
                        <td class='col-md-4'>${item.productoAlmacenado.producto.descripcion}</td>
                        <td class='col-md-2'>
                            <input type="text" class="form-control col-md-1" aria-label="Amount (to the nearest dollar)" id='precioInput' path='item.productoAlmacenado.precioCompraUltimo' value="${item.productoAlmacenado.precioCompraUltimo}">
                        </td>
                        <td id='totalLinea' class='col-md-2'>${item.montoTotal}</td>
                    </tr>
                </c:forEach>
  		
  		</tbody>
  		<tfoot>
  		<tr>
  			<td id="totalNota">${nota.montoTotal}</td>
  			<td>
  			<div class="btn-group btn-group-lg" class="btn btn-success">
  				<input type="submit" id="buttonCobrar" 
				value="<spring:message text="Cobrar"/>" />
			</div>
			</td>
		</tr>
  		</tfoot>
  		
  	</form:form>
	</table>
	
	</div>

</div>


</div>
</div>
</div>



  </body>
</html>