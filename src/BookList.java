import java.util.ArrayList;

public class BookList {
    ArrayList<Book> bookArray = new ArrayList<Book>();
    public void addBook(Book book) {
        this.bookArray.add(book);
    }
    public Book getBook(int i){
        return this.bookArray.get(i);
    }

    public boolean isBookThere(String bookname) {
        for (Book book : bookArray) {
            if (book.getTitle().equals(bookname)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> searchBook(String search, String selected) {
        ArrayList<Book> searchResult = new ArrayList<Book>();
        for (Book book : bookArray) {
            if (selected.equals("제목")&&book.getTitle().equals(search)) {
                searchResult.add(book);
            }
            else if (selected.equals("ISBN")&&book.getISBN().equals(search)) {
                searchResult.add(book);
            }
            else if (selected.equals("저자")&&book.getAuthor().equals(search)) {
                searchResult.add(book);
            }
            else if (selected.equals("출판사")&&book.getPublisher().equals(search)) {
                searchResult.add(book);
            }
            else if (selected.equals("판매자")&&book.getUser().equals(search)) {
                searchResult.add(book);
            }
        }
        return searchResult;
    }


}
