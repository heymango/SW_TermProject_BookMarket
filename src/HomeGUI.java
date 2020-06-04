import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeGUI extends JFrame {
    Font font = new Font("배달의민족 을지로체 TTF",0,13);
    UserList userList;
    BookList bookList;

    public HomeGUI(UserList Userlist, BookList BookList) {
        super("Main");
        setSize(1000, 700);
        userList = Userlist;
        bookList = BookList;
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        for(int i=0; i<userList.numUser(); i++){
            userList.userArray.get(i).print();
        }
        for(int i=0; i<bookList.bookArray.size(); i++){
            bookList.bookArray.get(i).print();
        }
        new BookGUI(userList,bookList);

    }

}
