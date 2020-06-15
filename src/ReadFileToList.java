import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ReadFileToList {
    UserList userList;
    BookList bookList;
    String Book;
    String User;
    public ReadFileToList(UserList UserList, BookList BookList, String UserFileName, String BookFileNme){
        User = UserFileName;
        Book = BookFileNme;
        bookList = BookList;
        userList = UserList;
        readBook();
        readUser();

    }



    public void readUser(){
        BufferedReader br1 = null;
        try{
            br1 = Files.newBufferedReader(Paths.get(User));
            //Charset.forName("UTF-8");
            String line = "";
            while((line = br1.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                String[] array = line.split("\\|");
                //배열에서 리스트 반환
                userList.addUser(new User(array[0],array[1],array[2],array[3],array[4],Boolean.parseBoolean(array[5]),Boolean.parseBoolean(array[6])));
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
                if(br1 != null){
                    br1.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }

    public void readBook(){
        BufferedReader br2 = null;
        try{
            br2 = Files.newBufferedReader(Paths.get(Book));

            String line = "";
            line = br2.readLine();
            while((line = br2.readLine()) != null){
                String [] array =line.split("\\|");
                Book book = new Book(array[0],array[1],array[2],array[3],array[4],array[5],array[6],array[7]);
                if(array.length>8) {
                    List info = new List();
                    info.add(array[8]);
                    info.add(array[9]);
                    info.add(array[10]);
                    info.add(array[11]);
                    info.add(array[12]);
                    info.add(array[13]);
                    info.add(array[14]);
                    info.add(array[15]);
                    info.add(array[16]);
                    book.setBookInfo(info);
                }
                bookList.addBook(book);
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
                if(br2 != null){
                    br2.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }


}