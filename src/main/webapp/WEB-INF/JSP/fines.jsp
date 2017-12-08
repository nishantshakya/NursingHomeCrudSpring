<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script >
        function validate() {
            var orating = document.getElementById("orating").value;
            var srating = document.getElementById("srating").value;
            if(!(orating>0 && srating>0)){
                alert("fill all required field");
                return false
            }else if(orating>5 || srating>5){
                alert("rating should be between 1-5");
                return false
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

	<form:form method="post" action="/fines" modelAttribute="fines" onsubmit="return validate()">
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 400px">
			<tr>
				<td>Nursing Home :</td>
				<td><form:input type="text" id="name" path="name" /></td>
			</tr>
			<tr>
				<td>Provider Number:</td>
				<td><form:input type="text" id="number" path="number" /></td>
			</tr>
			<tr>
				<td>Provider Type :</td>
				<td><form:input type="text" id="type" path="type" /></td>
			</tr>
			<tr>
				<td>Overall Rating*(0-5):</td>
				<td><form:input type="number" id ="orating" path="orating" /></td>
			</tr>
			<tr>
				<td>Staff Rating*(0-5):</td>
				<td><form:input type="number" id="srating" path="srating" /></td>
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
	<c:if test="${!empty finesData}">
		<div style="margin-left: 20px	">
	<h3>Search </h3>
	<table class="table table-bordered">
		<tr>
					
			<th>Provider Number</th>
			<th>Provider Name</th>
			<th>Provider Type</th>
			<th>Fines</th>
			<th>Amount of Fines</th>
			<th>Overall Rating</th>
			<th>Staff Rating</th>
		
		</tr>
		<c:forEach items="${finesData}" var="fines">

			<tr>
			
				<td width="60" align="center">${fines.number}</td>
				<td width="60" align="center">${fines.name}</td>
				<td width="60" align="center">${fines.type}</td>
				<td width="60" align="center">${fines.fines}</td>
				<td width="60" align="center">${fines.amountFines}</td>
				<td width="60" align="center">${fines.orating}</td>
				<td width="60" align="center">${fines.srating}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
		</div>
</body>
</html>