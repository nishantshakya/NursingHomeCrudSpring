<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script >
    function validate() {
        var inspection_cycle = document.getElementById("inspection_cycle").value;
        var total_defiencies = document.getElementById("total_defiencies").value;
        if(!(inspection_cycle.length>0 && total_defiencies>0)){
            alert("fill all required field");
            return false
		}else if(inspection_cycle>3){
            alert("inspection cycle should be 1-3");
            return false;
		}
    }

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nursing home</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-inverse" style="border-radius: 0">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/">Home</a>
		</div>
	</div>
</nav>
<center>
<h3>Search form</h3>

	<form:form method="post" action="/deficiency" modelAttribute="deficiency" onsubmit="return validate()" novalidate="true">
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 400px">
			<tr>
				<td>Nursing Home :</td>
				<td><form:input type="text" id="name" path="name" /></td>
			</tr>
			<tr>
				<td>Total Deficiency* :</td>
				<td><form:input type="text" id ="total_defiencies" path="total_defiencies"  required="required"/></td>
			</tr>
			<tr>
				<td>Inspection Cycle*:</td>
				<td><form:input type="number" id="inspection_cycle" path="inspection_cycle" required="required" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-primary btn-sm" type="submit" value="Search" /></td>
			</tr>
		</table>
		</div>
	</form:form>
</center>
	<br>
	<br>
<div style="margin-left: 20px">
	<h3>Search </h3>
	<table class="table table-bordered" >
		<tr>
					
			<th>Name</th>
			<th>Total Deficiency</th>
			<th>Inspection Cycle</th>
		
		</tr>
		<c:forEach items="${deficienyData}" var="deficiency">

			<tr>
			
				<td width="60" align="center">${deficiency.name}</td>
				<td width="60" align="center">${deficiency.total_defiencies}</td>
				<td width="60" align="center">${deficiency.inspection_cycle}</td>
				
				
			
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>