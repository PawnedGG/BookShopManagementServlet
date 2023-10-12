import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Delete Book", urlPatterns = "/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet{//After we take parameters from JSP we delete the desired book from the database.
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int status = BookDao.deleteBook(id);
            if(status == 0){
                String error = "Book could not be deleted. Check the ID again.";
                request.setAttribute("error", error);
            }else{
                String success = "Book deleted successfully";
                request.setAttribute("success", success);
            }
            getServletContext().getRequestDispatcher("/DeleteBook.jsp").forward(request, response);  
        }catch(NumberFormatException ex){
            String fail = "All boxes must be filed.";
            request.setAttribute("fail", fail);
            getServletContext().getRequestDispatcher("/DeleteBook.jsp").forward(request, response);
        }      
    }
}
