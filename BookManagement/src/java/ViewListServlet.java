import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "View List", urlPatterns = "/ViewListServlet")
public class ViewListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{//Here we return all the entries from the database in a list.
        List<Book> list = BookDao.getAllBooks();
        request.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/ViewList.jsp").forward(request, response);
    }
}
