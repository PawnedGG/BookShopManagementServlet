<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete Book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Delete book</h1>
        <h3>Fill in the ID of the book you want to be deleted</h3>
        
        <form action="/BookManagement/DeleteBookServlet" method="get">
            <table>
                <tr><td>ID:</td><td><input type="number" id="id" name="id"></td></tr>
                <tr><td colspan="2"><input type="submit" value="Submit"></td></tr>
            </table>
        </form>
        
        <p>${success}</p>
        <p>${error}</p>
        <p>${fail}</p>
        <a href="index.jsp"><p>Home</p></a>
    </body>
</html>
