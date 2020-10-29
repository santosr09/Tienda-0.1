<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Tienda 1.0</title>

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <!-- <link href="resources/datatables/media/css/jquery.dataTables.css" rel="stylesheet"> -->
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/datatables/media/js/jquery.dataTables.min.js"></script>
    
    <script>
$(document).ready(function(){
	
	$( "#notaTable tbody tr" ).on( "change", function() {
		  var row = $(this).find("#rowNum").text();
		  var cantidad = parseFloat($(this).find("#cantidadInput").val()).toFixed(2);
		  
		  //var cantInput = $(this).find("#cantidad");
		  var cantInput = $(this).find("#cantidadInput");
		  var totLinea = $(this).find("#totalLinea");
		  
		  //var cantInputVal = $(this).find("#cantidadInput").val();
		  //alert('cantInputVal: '+cantInputVal);
	    	console.log('RowNum: '+ row);
	    	$.post("/Tienda/ventas/updateQty", { rowNum: row, cantidadInput: cantidad })
	            	.done(function(data, status){
	                	//var htmlCantidad = "<input id='cantidadInput' path='item.cantidadVenta' value="+data[row-1].cantidad+"/>";
	                	//var htmlCantidad = data[row-1].cantidad;
	                	var htmlTotLinea = ""+data[row-1].totalLinea+"";
	                	cantInput.html(cantidad);
	                	totLinea.html(htmlTotLinea);
	            	});
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
  	
  	<div class="panel-heading"><h3>Nota de Venta  <p:spinner />    </h3></div>
  	
  	<div class="panel-body">
  	<c:url var="searchAction" value="/ventas/search" ></c:url>
    	<form:form action="${searchAction}" modelAttribute="productoView" id="search-form" role = "form">
		<form:label path="clave">
        	<spring:message text="Clave"/>
        </form:label>
		<form:input id="claveInput" path="clave" />
		<input type="submit" id="button-search"
			value="<spring:message text="Buscar"/>" />

		</form:form>
	</div>

  	<!-- Table -->
  	<table  class="table table-fixed" id="notaTable">
  	<c:url var="cobrarAction" value="/ventas/cobrar" ></c:url>
  	<form:form action="${cobrarAction}" commandName="notaView" id="nota-form" role = "form">
  		<thead>
  			<tr>
  				<th class='col-md-1'>No.</th>
  				<th class='col-md-1'>Cantidad</th>
  				<th class='col-md-4'>Producto</th>
  				<th class='col-md-2'>Precio Unit.</th>
  				<th class='col-md-2'>Total</th>
  			</tr>
  		</thead>
  			
  		<tbody>
  			<c:forEach items="${detalleVenta}" var="item">
                    <tr>
                    	<td id='rowNum' class='col-md-1'>${item.rowNum}</td>
                    	<td id='cantidad' class='col-md-1'><input id='cantidadInput' path='item.cantidadVenta' value="${item.cantidad}"/></td>
                        <td class='col-md-4'>${item.productoVenta.producto.descripcion}</td>
                        <td class='col-md-2'>${item.productoVenta.precioVenta}</td>
                        <td id='totalLinea' class='col-md-2'>${item.totalLinea}</td>
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
  		<!-- onclick="form.action='ventas/cobrar';" -->
  		
  	</form:form>
	</table>
	
	</div>

</div>


</div>
</div>
</div>
  </body>
</html>