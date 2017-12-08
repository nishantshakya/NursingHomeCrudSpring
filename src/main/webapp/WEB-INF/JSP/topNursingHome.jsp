<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: srajbhandari
  Date: 12/2/17
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Top Nursing Homes</title>
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
<h2>Top 50 nursing homes of state</h2>
    <form:form method="get" action="/topnursing">
        <div>
            <div class="small-3 columns">
                <select name="searchState" style="height: 35px">
                    <c:forEach items="${stateList}" var="state">
                        <option value="${state.value}">${state.key}</option>
                    </c:forEach>
                </select>
            </div>
            <br/>

            <div class="small-5 columns end">
                <button id="button-id" type="submit">Search Nursing Home</button>
            </div>
        </div>
    </form:form>
</center>

<br/>
<br/>
<div style="margin: 20px">
    <c:if test="${!empty topNursingHomes.size()}">
        <h3>Search </h3>
        <table class="table table-bordered" >
            <tr>

                <th>Provider Number</th>
                <th>Provider Name</th>
                <th>City</th>
                <th>Overall Rating</th>

            </tr>
            <c:forEach items="${topNursingHomes}" var="topNursinghome">

                <tr>

                    <td width="10%" align="center">${topNursinghome.provider_number}</td>
                    <td width="70%" align="center">${topNursinghome.provider_name}</td>
                    <td width="10%" align="center">${topNursinghome.city}</td>
                    <td width="10%" align="center">${topNursinghome.overall_rating}</td>

                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

</body>
</html>
