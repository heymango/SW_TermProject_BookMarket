import org.w3c.dom.html.HTMLObjectElement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeGUI extends JFrame {
    Font font = new Font("배달의민족 을지로체 TTF",0,20);
    Font font1 = new Font("배달의민족 을지로체 TTF",0,50);
    UserList userList;
    BookList bookList;
    Color p = new Color(142, 117, 241);
    Color b =new Color(103, 137, 253);
    public HomeGUI(UserList Userlist, BookList BookList) {
        super("Main");
        setSize(1000, 700);
        setBackground(Color.WHITE);
        userList = Userlist;
        bookList = BookList;
        init();
        print();

        JPanel background = new JPanel();
        background.setBackground(Color.WHITE);
        background.setLayout(null);

        JPanel top = new JPanel();
        top.setBackground(Color.WHITE);
        top.setBounds(0,0,1000,100);
        background.add(top);
        top.setLayout(null);

        JLabel HomeTxt = new JLabel("Book Market");
        HomeTxt.setBounds(10,20,400,80);
        HomeTxt.setFont(font1);


        HomeTxt.setForeground(p);
        top.add(HomeTxt);


        JPanel menu = new JPanel();
        menu.setBackground(p);
        menu.setBounds(0,110,200,600);
        background.add(menu);




        JPanel home = new JPanel();
        home.setBackground(Color.WHITE);
        home.setBounds(210,100,760,560);
        TitledBorder border = new TitledBorder(new LineBorder(p,5),"New");
        border.setTitleColor(p);
        border.setTitleFont(font);
        home.setBorder(border);
        background.add(home);
        add(background);

        init();


    }
    public void basicGUI(JPanel panel){

    }

    public void print(){
        for(int i=0; i<userList.numUser(); i++){
            userList.userArray.get(i).print();
        }
        for(int i=0; i<bookList.bookArray.size(); i++){
            bookList.bookArray.get(i).print();
        }
    }

    public void init(){
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



}
