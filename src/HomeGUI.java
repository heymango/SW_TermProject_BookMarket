import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeGUI extends JFrame {
    HomeGUI homeGUI;
    UI ui = new UI();
    UserList userList;
    BookList bookList;
    JPanel background;
    JPanel top;
    listArea home;
    String user;
    int mode;
    boolean isAdmin;
    public HomeGUI(UserList Userlist, BookList BookList) {
        super("Main");
        isAdmin = false;
        mode = 0;
        setSize(1100, 700);
        setBackground(Color.WHITE);
        userList = Userlist;
        bookList = BookList;
        print();
        user = userList.whoSignin().getId();
        homeGUI =this;
        //Background panel
        background = new JPanel();
        background.setBackground(Color.WHITE);
        background.setLayout(null);

        home = new listArea(bookList,userList,mode);
        background.add(home);
        basicGUI(background);
        add(background);
        init();

    }

    public void basicGUI(JPanel background) {
        //Top area

        top(background);
        //Menu Panel
        menu(background);


        //Book Area
        //BookList

    }
    public void top(JPanel background){
        top = new JPanel();
        top.setBackground(Color.WHITE);
        top.setBounds(0, 0, 1100, 100);
        top.setLayout(null);

        //Head Text
        JLabel HomeTxt = new JLabel("독서의 민족");
        HomeTxt.setBounds(10, 20, 400, 80);
        HomeTxt.setFont(ui.font1);
        HomeTxt.setForeground(ui.g);
        top.add(HomeTxt);

        JLabel userTxt = new JLabel(user+" 님도 역시");
        userTxt.setBounds(10, 0, 400, 20);
        userTxt.setFont(ui.font);
        userTxt.setForeground(ui.g);
        top.add(userTxt);

        background.add(top);

        //Search Area
        JPanel search = new JPanel();
        search.setLayout(null);
        search.setBackground(Color.white);
        search.setBounds(550,60,500,40);
        top.add(search);

        Button searchBtn = new Button("검색");
        searchBtn.setBounds(415,0,70,40);
        searchBtn.setFont(ui.font3);
        searchBtn.setBackground(ui.s);
        searchBtn.setHorizontalAlignment(0);
        searchBtn.setForeground(Color.white);
        search.add(searchBtn);

        JComboBox<String> searchC = new JComboBox<String>();
        searchC.addItem("제목");
        searchC.addItem("ISBN");
        searchC.addItem("저자");
        searchC.addItem("출판사");
        searchC.addItem("판매자");
        searchC.setBounds(0,0,130,40);
        searchC.setFont(ui.font);
        searchC.setForeground(ui.g);
        searchC.setBackground(Color.WHITE);
        search.add(searchC);

        JTextField searchField = new JTextField();
        searchField.setBounds(150,0,250,40);
        searchField.setFont(ui.font);
        searchField.setBorder(new BasicBorders.FieldBorder(ui.p4,ui.p4,ui.p4,ui.p4));
        searchField.setForeground(ui.g);
        search.add(searchField);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchResult(searchField.getText(),searchC.getSelectedItem().toString());
            }
        });

    }


    public void menu(JPanel background) {
        JPanel menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(ui.p);
        menu.setBounds(10, 107, 200, 550);

        Button addBook = new Button("<html>나의 책<br>등록하기<br></html>");
        addBook.setFont(ui.font2);
        addBook.setBackground(ui.p2);
        addBook.setBounds(0, 0, 200, 183);
        menu.add(addBook);

        Button editBook = new Button("<html>나의 책<br>관리하기<br></html>");
        editBook.setFont(ui.font2);
        editBook.setBackground(ui.p3);
        editBook.setBounds(0, 183, 200, 183);
        menu.add(editBook);

        Button exit = new Button("로그아웃");
        exit.setFont(ui.font2);
        exit.setBackground(ui.p4);
        exit.setBounds(0, 366, 200, 184);
        menu.add(exit);

        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookGUI(userList,bookList,homeGUI);
            }
        });

        editBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyBook(userList,bookList,homeGUI);

            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userList.whoSignin().setOn();
                dispose();
                new SignInGUI(userList,bookList)
;
            }
        });

        background.add(menu);

    }


    public void print() {
        for (int i = 0; i < userList.numUser(); i++) {
            userList.userArray.get(i).print();
        }
        for (int i = 0; i < bookList.bookArray.size(); i++) {
            bookList.bookArray.get(i).print();
        }
    }

    public void init() {
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void searchResult(String search,String selected){
        ArrayList<Book> searchResult = bookList.searchBook(search, selected);
        if(searchResult!=null){
            home.updatePanel(2);
            home.printsearchBook(searchResult);
            home.revalidate();
            home.repaint();
        }

    }



}
