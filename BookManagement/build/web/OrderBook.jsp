<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Order Book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Order book</h1>
        
        <form action="/BookManagement/OrderBookServlet" method="get">
            <table>
                <tr><td>ID:</td><td><input type="number" id="id" name="id"/></td></tr>
                <tr><td>Amount:</td><td><input type="number" id="amount" name="amount"/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
            </table>
        </form>
        
        <p>${success}</p>
        <p>${outOfStock}</p>
        <p>${fail}</p>
        <p>${error}</p>
        <a href="index.jsp"><p>Home</p></a>
    </body>
</html>

