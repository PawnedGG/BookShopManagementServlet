import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Add Book", urlPatterns = "/AddBookServlet")
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        try{//After we take parameters from JSP we create a book object to store in the database.
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");  
            String author = request.getParameter("author");
            int pages = Integer.parseInt(request.getParameter("pages"));
            int copies = Integer.parseInt(request.getParameter("copies"));
            
            Book book = new Book();  
            book.setId(id);  
            book.setTitle(title);  
            book.setAuthor(author);  
            book.setPages(pages);  
            book.setCopies(copies);  
        
            int status = BookDao.insertBook(book);  
            if(status>0){//We check if book insertion was completed successfully the give the appropriate response.
                String success = "Insertion succeded.";
                request.setAttribute("success", success);
                getServletContext().getRequestDispatcher("/InsertBook.jsp").forward(request, response); 
            }else{  
                String fail = "Insertion failed. ID already exists.";
                request.setAttribute("fail", fail);
                getServletContext().getRequestDispatcher("/InsertBook.jsp").forward(request, response);
            } 
        }catch(NumberFormatException ex){//If input is null parseInt fails.
            String error = "All boxes must be filled.";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/InsertBook.jsp").forward(request, response);
        }                
    }
}
