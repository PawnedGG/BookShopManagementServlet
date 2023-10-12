import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "View Book", urlPatterns = "/ViewBookServlet")
public class ViewBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{//We get a book by its ID, then after some checks we send the appropriate response.
            int id = Integer.parseInt(request.getParameter("id"));
            Book book = BookDao.getBook(id);
            
            if(book.getId()!=0){//0 is the default value our database returns if it doesn't match an ID probably because of an interaction between NULL from database and getInt from ResultSet.
                int flag = 1;//Flag used by JSP page to print the table. 
                request.setAttribute("flag", flag);
                request.setAttribute("book", book);
                getServletContext().getRequestDispatcher("/ViewBook.jsp").forward(request, response); 
            }else{
                String error = "ID does not exists. Please give a valid ID.";
                request.setAttribute("error", error);
                getServletContext().getRequestDispatcher("/ViewBook.jsp").forward(request, response);
            }
        }catch(NumberFormatException ex){//If input is null parseInt fails.
            String fail = "Please give an ID.";
            request.setAttribute("fail", fail);
            getServletContext().getRequestDispatcher("/ViewBook.jsp").forward(request, response);
        }  
    }
}
