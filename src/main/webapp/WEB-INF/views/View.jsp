<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Customer Page</title>
    <style type="text/css">
        .empTable  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .empTable td{font-family:Arial, sans-serif;font-size:16px;padding:10px 5px;border-
                              style:solid;border-width:2px;overflow:hidden;word-break:normal;border-
                              color:#ccc;color:#00FF00;background-color:#FF0000;}
        .empTable th{font-family:Arial, sans-serif;font-size:16px;font-weight:normal;padding:10px
                              5px;border-style:solid;border-width:2px;overflow:hidden;word-break:normal;border-
                              color:#ccc;color:#000000;background-color:#FF4500;}
        .empTable .empTable-4eph{background-color:#C0C0C0}
    </style>
</head>
<body>
 
    <c:if test="${empty Customer.CustomerId}">
    <h1>
    <spring:message code="AddCustomer"/>
    </h1>
    </c:if>
 
 
<c:url var="addAction" value="/Customer/add" ></c:url>
 
<form:form action="${addAction}" modelAttribute="Customer">
<table>
    <c:if test="${not empty Customer.CustomerId}">
    <h1><spring:message code="EditCustomer"/></h1>
    <tr>
        <td>
            <form:label path="CustomerId">
                <spring:message code="CustomerID"/>
            </form:label>
        </td>
        <td>
            <form:input path="CustomerId" readonly="true" size="8"  disabled="true" />
            <form:hidden path="CustomerId" />
        </td>
    </tr>
    </c:if>
 
    <tr>
        <td>
            <form:label path="firstName">
                <spring:message code="FirstName"/>
            </form:label>
        </td>
        <td>
            <form:input path="firstName" />
        </td>
    </tr>
 
    <tr>
        <td>
            <form:label path="lastName">
                <spring:message code="LastName"/>
            </form:label>
        </td>
        <td>
            <form:input path="lastName" />
        </td>
    </tr>
 
    <tr>
        <td>
            <form:label path="age">
                <spring:message code="Age"/>
            </form:label>
        </td>
        <td>
            <form:input path="age" />
        </td>
    </tr>
 
    <tr>
        <td>
            <form:label path="email">
                <spring:message code="email"/>
            </form:label>
        </td>
        <td>
            <form:input path="email" />
        </td>
    </tr>
 
    <tr>
        <td>
            <form:label path="city">
                <spring:message code="city"/>
            </form:label>
        </td>
        <td>
            <form:input path="city" />
        </td>
    </tr>
 
    <tr>
        <td colspan="2">
                <input type="submit"
                    value="<spring:message code="Submit"/>" />
        </td>
    </tr>
 
</table>   
</form:form>
<br>
 
<c:if test="${not empty CustomerList}">
<h3><spring:message code="CustomerList"/></h3>
    <table class="empTable">
    <tr>
        <th width="80">ID</th>
        <th width="120">First Name</th>
        <th width="120">Last Name</th>
        <th width="120">Age</th>
        <th width="120">email</th>
        <th width="120">city</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
 
    <c:forEach items="${CustomerList}" var="Customer">
        <tr>
            <td>${Customer.CustomerId}</td>
            <td>${Customer.firstName}</td>
            <td>${Customer.lastName}</td>
            
            <td><a href="<c:url value='/Customer/edit/${Customer.CustomerId}' />" >Edit</a></td>
            <td><a href="<c:url value='Customer/reCustomermployee.CustomerId}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>
