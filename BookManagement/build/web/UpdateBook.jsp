<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Update book</h1>
        <h3>Provide the ID of the book you want to update.</h3>

        <form action="/BookManagement/UpdateBookServlet" method="get">
            <table style="padding:5px">
                <tr><td>ID:</td><td><input type="number" id="id" name="id"></td></tr>
                <tr><td colspan="2"><input type="submit" value="Submit"></td></tr>
            </table>
        </form>

        <p>${error}</p>
        <p>${success}</p>
        <p>${fail}</p>
        <a href="index.jsp"><p>Home</p></a>
</body>
</html>
