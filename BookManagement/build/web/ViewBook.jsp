<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>View Book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>View book</h1>
        <form action="/BookManagement/ViewBookServlet" method="get">
            <table>
                <tr><td>ID:</td><td><input type="number" id="id" name="id"/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
            </table>
        </form>
        
        <p>${fail}</p>
        <p>${error}</p>
        <%-- JSTL if statement to check if table must be shown--%>
        <c:if test = "${flag == 1}">
            <table style="border:1px solid black; padding:5px; border-spacing:2px;">
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Pages</th>
                    <th>Copies</th>
                </tr>
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.pages}</td>
                    <td>${book.copies}</td>
                </tr>
            </table>
        </c:if>
        <a href="OrderBook.jsp"><p>Order book</p></a>
        <a href="index.jsp"><p>Home</p></a>
    </body>
</html>