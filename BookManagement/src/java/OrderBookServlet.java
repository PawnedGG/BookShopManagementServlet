import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Order Book", urlPatterns = "/OrderBookServlet")
public class OrderBookServlet extends HttpServlet {//After we take and check parameters from JSP we commit the order.

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            Book book = BookDao.getBook(id);
            if(book.getId() == 0){
                String error = "Sorry, this ID does not exist.";
                request.setAttribute("error", error);
                getServletContext().getRequestDispatcher("/OrderBook.jsp").forward(request, response);
            }else if(book.getCopies() == 0){
                String outOfStock = "Sorry, this book is out of stock.";
                request.setAttribute("outOfStock", outOfStock);
                getServletContext().getRequestDispatcher("/OrderBook.jsp").forward(request, response);
            }else if(book.getCopies() - amount < 0){
                String outOfStock = "Sorry, we only have " + book.getCopies() + " books in stock.";
                request.setAttribute("outOfStock", outOfStock);
                getServletContext().getRequestDispatcher("/OrderBook.jsp").forward(request, response);
            }else{
                int status = BookDao.orderBook(book, amount);
                if(status != 0){
                    String success = "Order placed successfully";
                    request.setAttribute("success", success);
                    getServletContext().getRequestDispatcher("/OrderBook.jsp").forward(request, response); 
                }else{
                    String error = "ID does not exist. Please give a valid ID.";
                    request.setAttribute("error", error);
                    getServletContext().getRequestDispatcher("/OrderBook.jsp").forward(request, response);
                }
            }
        }catch(NumberFormatException ex){
            String error = "All boxes must be filled.";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/OrderBook.jsp").forward(request, response);
        }                
    }
}
