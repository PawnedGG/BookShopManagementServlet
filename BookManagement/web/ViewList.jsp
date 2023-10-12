<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>View List</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>List of all books.</h1>
        <p>View specific book for more details by using its ID.</p>
        <table style="border:1px solid black; padding:5px; border-spacing:2px;">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
            </tr>
            <%-- JSTL function for for loop in order to create the table --%>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.title}</td>
                    <td>${item.author}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="ViewBook.jsp"><p>View Book</p></a>
        <a href="index.jsp"><p>Home</p></a>
    </body>
</html>

