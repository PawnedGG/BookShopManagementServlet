import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDao{//Use of Data Access Object to have a better structured code. 
    public static List<Book> getAllBooks(){//Use of list to store book objects created from the ResultSet obtained from the SQLquery.
        List<Book> list = new ArrayList<>();
        Connection con = DBManager.initDB();
        
        try{
            PreparedStatement st = con.prepareStatement("SELECT * FROM BOOK;");//Prepared statements for faster execution and security.
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){//Book object creation from the rs.
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPages(rs.getInt(4));
                book.setCopies(rs.getInt(5));
                list.add(book);
            }
            con.close();
        }catch(SQLException ex){
        }
        return list; 
    }
    
    public static Book getBook(int id){//Create a specific book object with information from the database.
        Book book = new Book();
        Connection con = DBManager.initDB();
        
        try{
            PreparedStatement st = con.prepareStatement("SELECT * FROM BOOK WHERE ID =?");
            st.setInt(1, id);//Put value in the correct placeholder.
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                book.setId(rs.getInt(1));
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPages(rs.getInt(4));
                book.setCopies(rs.getInt(5));    
            }
            con.close();
        } catch (SQLException ex) {
        }
        return book;
    }
    
    public static int deleteBook(int id){//Delete a specific book from the database.
        int status = 0;
        Connection con = DBManager.initDB();
        
        try{    
            PreparedStatement st = con.prepareStatement("DELETE FROM BOOK WHERE ID =?;");
            st.setInt(1, id);
            status = st.executeUpdate();
            con.close();            
        } catch (SQLException ex) {
        }
        return status;
    }
    
    public static int updateBook(Book book){//Update information of a book in the database.
        int status = 0;
        Connection con = DBManager.initDB();
        
        try{
            PreparedStatement st = con.prepareStatement("UPDATE BOOK SET TITLE=?, AUTHOR=?, PAGES=?, COPIES=? WHERE id=?");
            st.setString(1,book.getTitle());  
            st.setString(2,book.getAuthor());  
            st.setInt(3,book.getPages());  
            st.setInt(4,book.getCopies()); 
            st.setInt(5,book.getId());
            status=st.executeUpdate();                
            con.close();
        } catch (SQLException ex) {
        }
        return status;
    }
    
    public static int insertBook(Book book){//Insert a new book in the database.
        int status = 0;
        Connection con = DBManager.initDB();
        
        try{
            PreparedStatement st = con.prepareStatement("INSERT INTO BOOK VALUES(?, ?, ?, ?, ?)");
            st.setInt(1, book.getId());
            st.setString(2, book.getTitle());
            st.setString(3, book.getAuthor());
            st.setInt(4, book.getPages());
            st.setInt(5, book.getCopies());
            status = st.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
        return status;
    }
    
    public static int orderBook(Book book, int amount){//By ordering a book we decrease the value of "copies" in the database for that book.
        int status = 0;
        Connection con = DBManager.initDB();
        
        try{
            PreparedStatement st = con.prepareStatement("UPDATE BOOK SET COPIES=? WHERE ID=?");
            st.setInt(1, book.getCopies() - amount);
            st.setInt(2, book.getId());
            status = st.executeUpdate();
            con.close();
        } catch (SQLException ex) {
        }
        return status;
    }
}
