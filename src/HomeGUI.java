import org.w3c.dom.html.HTMLObjectElement;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeGUI extends JFrame {
    HomeGUI homeGUI;
    Font font = new Font("배달의민족 한나체 Pro", 0, 20);
    Font font1 = new Font("배달의민족 한나체 Pro", 0, 50);
    Font font2 = new Font("배달의민족 한나체 Pro", 0, 38);
    Font font3 = new Font("배달의민족 한나체 Pro", 0, 16);
    UserList userList;
    BookList bookList;
    JPanel background;
    JPanel home = new JPanel();;
    Color p = new Color(142, 117, 241);
    Color g = new Color(43, 43, 44);
    Color b = new Color(103, 137, 253);
    Color p2 = new Color(178, 169, 255);
    Color p3 = new Color(154, 143, 243);
    Color p4 = new Color(130, 130, 144);
    Color s = new Color(231, 119, 133);

    public HomeGUI(UserList Userlist, BookList BookList) {
        super("Main");
        setSize(1100, 700);
        setBackground(Color.WHITE);
        userList = Userlist;
        bookList = BookList;
        print();
        homeGUI =this;
        //Background panel
        background = new JPanel();
        background.setBackground(Color.WHITE);
        background.setLayout(null);

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
        bookListArea(background);


        //BookList


    }
    public void top(JPanel background){
        JPanel top = new JPanel();
        top.setBackground(Color.WHITE);
        top.setBounds(0, 0, 1100, 100);
        top.setLayout(null);

        //Head Text
        JLabel HomeTxt = new JLabel("독서의 민족");
        HomeTxt.setBounds(10, 20, 400, 80);
        HomeTxt.setFont(font1);
        HomeTxt.setForeground(g);
        top.add(HomeTxt);
        background.add(top);

        //Search Area
        JPanel search = new JPanel();
        search.setLayout(null);
        search.setBackground(Color.white);
        search.setBounds(550,60,500,40);
        top.add(search);

        Button searchBtn = new Button("책 제목으로 검색");
        searchBtn.setBounds(315,0,150,40);
        searchBtn.setFont(font3);
        searchBtn.setBackground(s);
        searchBtn.setHorizontalAlignment(0);
        searchBtn.setForeground(Color.white);
        search.add(searchBtn);

        JTextField searchField = new JTextField();
        searchField.setBounds(0,0,300,40);
        searchField.setFont(font);
        searchField.setBorder(new BasicBorders.FieldBorder(p4,p4,p4,p4));
        searchField.setForeground(g);
        search.add(searchField);

    }


    public void menu(JPanel background) {
        JPanel menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(p);
        menu.setBounds(10, 107, 200, 550);

        Button addBook = new Button("<html>나의 책<br>등록하기<br></html>");
        addBook.setFont(font2);
        addBook.setBackground(p2);
        addBook.setBounds(0, 0, 200, 183);
        menu.add(addBook);

        Button editBook = new Button("<html>나의 책<br>관리하기<br></html>");
        editBook.setFont(font2);
        editBook.setBackground(p3);
        editBook.setBounds(0, 183, 200, 183);
        menu.add(editBook);

        Button exit = new Button("로그아웃");
        exit.setFont(font2);
        exit.setBackground(p4);
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
                updatePanel();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignInGUI(userList,bookList);
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

    public void bookListArea(JPanel background) {
        System.out.println("redraw");
        //init ui

        home.setLayout(null);
        home.setBackground(Color.white);
        home.setBounds(210, 100, 860, 560);
        TitledBorder border = new TitledBorder(new LineBorder(p, 5), "등록된 책");
        border.setTitleColor(p);
        border.setTitleFont(font);
        home.setBorder(border);

        //set booklist index
        LineGUI bookIndex = new LineGUI();
        bookIndex.setBounds(7, 30, 800, 50);
        bookIndex.setBackground(p);
        home.add(bookIndex);

        Button buyBtn = new Button("구매하기");
        buyBtn.setBounds(660,470,150,60);
        buyBtn.setFont(font3);
        buyBtn.setBackground(s);
        buyBtn.setHorizontalAlignment(0);
        buyBtn.setForeground(Color.white);
        home.add(buyBtn);

        //set booklist panel
        JPanel bookListPanel = new JPanel();
        bookListPanel.setBackground(Color.WHITE);
        bookListPanel.setLayout(null);
        bookListPanel.setVisible(true);

        JScrollPane sc = new JScrollPane(bookListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setViewportBorder(null);
        sc.getVerticalScrollBar().setBackground(Color.WHITE);
        sc.setBorder(BorderFactory.createEmptyBorder());
        int i =0;
        for (i = 0; i < bookList.bookArray.size(); i++) {
            Book book = bookList.getBook(i);
            LineGUI bookInfo = new LineGUI(book.getTitle(), book.getISBN(), book.getAuthor(), book.getPublisher(), book.getPublishYear(), book.getCondition(), book.getUser());
            bookInfo.setBounds(0, 50 * i, 800, 50);
            bookListPanel.add(bookInfo);
        }
        bookListPanel.setPreferredSize(new Dimension(800,50*i));
        sc.setBounds(7, 80, 820, 380);
        sc.setViewportView(bookListPanel);
        home.add(sc);
        background.add(home);
    }

    public void updatePanel(){
        System.out.println("update");
        home.removeAll();
        bookListArea(this.background);
        home.revalidate();
        home.repaint();
    }




}
