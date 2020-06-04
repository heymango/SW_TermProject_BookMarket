import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
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
                String[] array = line.split(",");
                //배열에서 리스트 반환
                userList.addUser(new User(array[0],array[1],array[2],array[3],array[4],Boolean.parseBoolean(array[5])));
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
            //Charset.forName("UTF-8");
            String line = "";
            while((line = br2.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                String[] array = line.split(",");
                bookList.addBook(new Book(array[0],array[1],array[2],array[3],array[4],array[5],array[6]));
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