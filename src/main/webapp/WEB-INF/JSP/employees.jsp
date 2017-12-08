<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nursing home</title>
	<script >
		function validate() {
			var provider_number=document.getElementById("provider_number").value;
			var name=document.getElementById("name").value;
			var phone_number=document.getElementById("phone_number").value;
			var overall_rating=document.getElementById("overall_rating").value;
			var provider_type=document.getElementById("provider_type").value;
			var ownership_type=document.getElementById("ownership_type").value;
			if(testText(60,0,provider_number)){
                alert("Provider name is required and length should be less than 60");
                return false;
            } else if (testText(80,0,name)){
                alert("Name is required and length should be less than 80");
                return false;
			}else if(isNumeric(phone_number)){
                alert("Phone Numbers should be numeric");
                return false;
            }else if(phone_number.length!=10){
                alert("Phone Number should have length of 10");
                return false;
            }else if(provider_type.length == 0){
			    alert("Provider type is required");
                return false;
            }else if(ownership_type.length == 0){
                alert("Ownership type is required");
                return false;
            }
            else if(overall_rating.length == 0){
                alert("Overall rating is required");
                return false;
            }
            else if(overall_rating>5 || overall_rating<0){
			    alert("Overall Rating should be between 0-5");
                return false;
            }

        }

        function testText(maxLength,minLength,value) {
//		    debugger
			return !(value.length>minLength && value.length<=maxLength);
        }
        var numericRegex=new RegExp("^[0-9]*$");

        function isNumeric(val) {
			return !numericRegex.test(val);
        }
	</script>
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
<h3>Add / Edit Nursing Homes!!!</h3>
	<form:form method="post" action="/employee/${id}/" modelAttribute="employee" onsubmit="return validate()">
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 400px">
			<tr>
				<td>Provider Number :</td>
				<td><form:input type="text" disabled="${id!=null}" id="provider_number" path="provider_number" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input type="text" id="name" path="name" /></td>
			</tr>
			<tr>
				<td>Phone number :</td>
				<td><form:input type="text" id="phone_number" path="phone_number" /></td>
			</tr>
			<tr>
				<td>Provider type :</td>
				<td><form:input type="text" id ="provider_type" path="provider_type" /></td>
			</tr>
			<tr>
				<td>Ownership type :</td>
				<td><form:input type="text" id="ownership_type" path="ownership_type"  /></td>
			</tr>
			<tr>
				<td>Overall rating :</td>
				<td><form:input type="number" id="overall_rating" path="overall_rating" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
			</tr>
		</table>
		</div>
	</form:form>
</center>
	<br>
	<br>
	<h3>List of Nursing Homes</h3>
	<table class="table table-bordered" >
		<tr>
			<th>Provider number</th>
			<th>Name</th>
			<th>Phone number</th>
			<th>Provider type</th>
			<th>Ownership type</th>
			<th>Overall rating</th>
			<th>Edit/Delete</th>
		</tr>
		<c:forEach items="${employeeList}" var="employee">

			<tr>
				<td width="60" align="center">${employee.provider_number}</td>
				<td width="60" align="center">${employee.name}</td>
				<td width="60" align="center">${employee.phone_number}</td>
				<td width="60" align="center">${employee.provider_type}</td>
				<td width="60" align="center">${employee.ownership_type}</td>
				<td width="60" align="center">${employee.overall_rating}</td>
				<td width="60" align="center"><a href="/edit/${employee.provider_number}">Edit</a>/<a href="/delete/${employee.provider_number}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>