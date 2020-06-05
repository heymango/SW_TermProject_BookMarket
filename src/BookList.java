import java.util.ArrayList;

public class BookList {
    ArrayList<Book> bookArray = new ArrayList<Book>();
    public void addBook(Book book) {
        this.bookArray.add(book);
    }
    public Book getBook(int i){
        return this.bookArray.get(i);
    }


}
