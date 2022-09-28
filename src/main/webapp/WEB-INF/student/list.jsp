<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>JSP - Hello World</title>
</head>
<body>
<h1 style="text-align: center">Student Manager</h1>
<br/>
<div style="padding-left: 480px"><button type="button" class="btn btn-success"><a href="students?action=create" style="color: white">Create</a></button></div>
<table align="center" border="1", style="width: 50%; text-align: center" class="table table-hover">

    <tr class="table-warning">
        <td>STT</td>
        <td>Name</td>
        <td>Age</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="st" items='${requestScope["listStudent"]}'>
        <tr class="table-danger">
            <td>${st.id}</td>
            <td><a href="students?action=detail&id=${st.id}" style="color: black">${st.name}</a></td>
            <td>${st.age}</td>
            <td>
                <button type="button" class="btn btn-info"><a href="students?action=edit&id=${st.id}" style="color: white">Edit</a></button>
            </td>
            <td>
                <buttonn type="button" class="btn btn-danger"><a href="students?action=delete&id=${st.id}" style="color: white">Delete</a></buttonn>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>