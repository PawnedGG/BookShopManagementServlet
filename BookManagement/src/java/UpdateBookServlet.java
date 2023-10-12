import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Update Book", urlPatterns = "/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet{//First we ask user which book he wants to modify. Then we pass to him the values of the entry in order for him to change them.

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        try{//After we check the parameters from the JSP we proceed on giving the values to the user for change.
            int id = Integer.parseInt(request.getParameter("id"));
            Book book = BookDao.getBook(id);
            if(book.getId()!=0){
                request.setAttribute("id", book.getId());
                request.setAttribute("title", book.getTitle());
                request.setAttribute("author", book.getAuthor());
                request.setAttribute("pages", book.getPages());
                request.setAttribute("copies", book.getCopies());
                getServletContext().getRequestDispatcher("/UpdateBook2.jsp").forward(request, response); 
            }else{
                String error = "ID does not exists. Please give a valid ID.";
                request.setAttribute("error", error);
                getServletContext().getRequestDispatcher("/UpdateBook.jsp").forward(request, response);
            }
        }catch(NumberFormatException ex){
            String error = "All boxes must be filled.";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/UpdateBook.jsp").forward(request, response);
        }                
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        try{//Here we commit the changes to the database.
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");  
            String author = request.getParameter("author");
            int pages = Integer.parseInt(request.getParameter("pages"));
            int copies = Integer.parseInt(request.getParameter("copies"));
            
            if(title.equals("") || author.equals("")){
                String error = "All boxes must be filled.";
                request.setAttribute("error", error);
                getServletContext().getRequestDispatcher("/UpdateBook.jsp").forward(request, response);
            }else{
                Book book = new Book();  
                book.setId(id);  
                book.setTitle(title);  
                book.setAuthor(author);  
                book.setPages(pages);  
                book.setCopies(copies);  
        
                int status = BookDao.updateBook(book);  
                if(status>0){  
                    String success = "Updated successfully.";
                    request.setAttribute("success", success);
                    getServletContext().getRequestDispatcher("/UpdateBook.jsp").forward(request, response); 
                }else{  
                    String fail = "Update failed. ID doesn't exist.";
                    request.setAttribute("fail", fail);
                    getServletContext().getRequestDispatcher("/UpdateBook2.jsp").forward(request, response);
                }
            }
        }catch(NumberFormatException ex){
            String error = "All boxes must be filled.";
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/UpdateBook.jsp").forward(request, response);
        }
    }
}
