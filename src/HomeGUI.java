import javax.swing.*;
import java.awt.*;

public class HomeGUI extends JFrame {
    public HomeGUI(UserList Userlist, BookList BookList) {
        super("Main");
        setSize(1000, 700);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
