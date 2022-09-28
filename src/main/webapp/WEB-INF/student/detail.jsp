<%--
  Created by IntelliJ IDEA.
  User: TungDao
  Date: 9/28/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>Title</title>
</head>
<body>
<c:if test='${requestScope["message"] != null}'>
    <span style="color: blue">${requestScope["message"]}</span>
</c:if>
<button type="button" class="btn btn-warning"><a style="color: white" href="/">Back</a></button>
<h2>FORM DETAIL</h2>
<form method="post">
    <table class="table table-bordered" style="width: 50%">
        <tr  class="table-danger">
            <td>NAME</td>
            <td>AGE</td>
        </tr>
        <tr>
            <td>${requestScope["student"].getName()}</td>
            <td>${requestScope["student"].getAge()}</td>
        </tr>
    </table>

<%--    <label>NAME: ${requestScope["student"].getName()}</label><br>--%>
<%--    <label>AGE: ${requestScope["student"].getAge()}</label>--%>
</form>

</body>
</html>
