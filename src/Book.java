public class Book {
    private String title;
    private String ISBN;
    private String author;
    private String publisher;
    private String publishYear;
    private int condition;
    private final String user;
    String[] cond = {"Excellent", "Good", "Fair"};
    public Book(String Title, String isbn, String Author, String Publisher, String PublishYear, int Condition, String User){
        title =Title;
        ISBN =isbn;
        author =Author;
        publisher =Publisher;
        publishYear = PublishYear;
        condition = Condition;
        user = User;
    }

    public int getCondition() {
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

    public String getCond() {
        return cond[condition];
    }

    public String getUser() {
        return user;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCondition(int condition) {
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
}
