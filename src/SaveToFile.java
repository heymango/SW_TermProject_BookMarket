import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveToFile {
    UserList userList;
    BookList bookList;
    String Book = "Book.csv";
    String User= "User.csv";
    public SaveToFile(UserList UserList, BookList BookList, String UserFileName, String BookFileNme){
        User = UserFileName;
        Book = BookFileNme;
        bookList = BookList;
        userList = UserList;
        saveBook();
        saveUser();

    }
    public SaveToFile(UserList UserList, BookList BookList){
        bookList = BookList;
        userList = UserList;
        saveBook();
        saveUser();

    }

    public void saveBook(){
        BufferedWriter bufWriter = null;
        try{
            bufWriter = Files.newBufferedWriter(Paths.get(Book), StandardCharsets.UTF_8);

            for(Book book : bookList.bookArray){
                bufWriter.write(book.getTitle());
                bufWriter.write(",");
                bufWriter.write(book.getISBN());
                bufWriter.write(",");
                bufWriter.write(book.getAuthor());
                bufWriter.write(",");
                bufWriter.write(book.getPublisher());
                bufWriter.write(",");
                bufWriter.write(book.getPublishYear());
                bufWriter.write(",");
                bufWriter.write(book.getCondition());
                bufWriter.write(",");
                bufWriter.write(book.getUser());
                bufWriter.newLine();
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
                if(bufWriter != null){
                    bufWriter.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void saveUser(){
        BufferedWriter bufWriter = null;
        try{
            bufWriter = Files.newBufferedWriter(Paths.get(User), StandardCharsets.UTF_8);

            for(User user : userList.userArray){
                bufWriter.write(user.getId());
                bufWriter.write(",");
                bufWriter.write(user.getPassword());
                bufWriter.write(",");
                bufWriter.write(user.getUsername());
                bufWriter.write(",");
                bufWriter.write(user.getPhone());
                bufWriter.write(",");
                bufWriter.write(user.getEmail());
                bufWriter.write(",");
                bufWriter.write(Boolean.toString(user.isActivate()));
                bufWriter.write(",");
                bufWriter.write(Boolean.toString(user.isAdmin()));
                bufWriter.write(",");
                bufWriter.write("false");
                bufWriter.newLine();
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
                if(bufWriter != null){
                    bufWriter.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
