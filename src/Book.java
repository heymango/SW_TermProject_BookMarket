import com.google.gson.JsonObject;

import java.awt.*;


public class Book {
    private String title;
    private String ISBN;
    private String author;
    private String publisher;
    private String publishYear;
    private String condition;
    private final String user;
    private List bookInfo = null;
    private String price;
   // String[] cond = {"Excellent", "Good", "Fair"};
    public Book(String Title, String isbn, String Author, String Publisher, String PublishYear, String Condition, String User, String Price){
        title =Title;
        ISBN =isbn;
        author =Author;
        publisher =Publisher;
        publishYear = PublishYear;
        condition = Condition;
        user = User;
        price = Price;
    }

    public void setBookInfo(List bookInfo) {
        this.bookInfo = bookInfo;
    }

    public List getBookInfo() {
        return bookInfo;
    }

    public String getCondition() {
        return condition;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public String getTitle() {
        return title;
    }

    public String getUser() {
        return user;
    }

    public String getPrice() {
        return price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void print(){
        System.out.println("title:"+title+"user:"+user+"\n");
    }

}
