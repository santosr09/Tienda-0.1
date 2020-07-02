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
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/datatables/media/css/jquery.dataTables.min.css" rel="stylesheet">
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/datatables/media/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
        $('#listadoPrecios').DataTable();
        
        $("#button-search").click(function(){
        	var claveVar = $("#claveInput").val();
        	$.post("/Tienda/precios/search", { clave: claveVar },
        	function(data, status){
            	var htmlStr = "<h2><label><span class='label label-info'>"+data.descripcion+"</span></label><br>"+
       				"<label>$"+data.precioVenta+"<label></h2>";
	            $('#result').html(htmlStr);
            	
        	});
    	}); 
        
    });
    
    
    </script>
    

  </head>
  <body>
  
   <div class="container">
  <div class = "page-header">
   
   <h1>
      Tienda 0.1
   </h1>
   
  </div>
  
  <div class="container">
    
    <div class = "row" >
    
    <div class="col-md-2">
    	<%@ include file="menu-acciones.jsp" %>
	</div>
  
  
	<div class="col-md-10">
	<c:url var="searchAction" value="/precios/search" ></c:url>
<form:form action="${searchAction}" commandName="producto" id="search-form" role = "form">

<form:label path="clave">
                <spring:message text="Clave"/>
            </form:label>

            <form:input id="claveInput" path="clave" />

            <input type="button" id="button-search"
                    value="<spring:message text="Buscar"/>" />

</form:form>

<div id="result" class = "form-group">
</div>

</div>


</div>
</div>
</div>
  </body>
</html>