<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Insert Book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Insert book</h1>
        <form action="/BookManagement/AddBookServlet" method="post">
            <table>
                <tr><td>ID:</td><td><input type="number" id="id" name="id"/></td></tr>
                <tr><td>Title:</td><td><input type="text" id="title" name="title"/></td></tr>
                <tr><td>Author:</td><td><input type="text" id="author" name="author"/></td></tr>
                <tr><td>Pages:</td><td><input type="number" id="pages" name="pages"/></td></tr>
                <tr><td>Copies:</td><td><input type="number" id="copies" name="copies"/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
            </table>
        </form>

        <p>${error}</p>
        <p>${success}</p>
        <p>${fail}</p>
        <a href="index.jsp"><p>Home</p></a>
    </body>
</html>
