import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BookGUI extends JFrame {
    UI ui = new UI();
    UserList userList;
    BookList bookList;
    BookGUI bookGUI;
    List info = null;
    private JTextField title;
    private JTextField ISBN;
    private JTextField author;
    private JTextField publisher;
    private JTextField year;
    private JLabel price = new JLabel("");
    JTextField priceT;

    private Boolean checkId = false;
    public BookGUI(UserList UserList, BookList BookList){
        super("AddBook");
        setSize(450, 450);
        userList = UserList;
        bookList = BookList;
        bookGUI = this;
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        BookPanel(panel);
        add(panel, BorderLayout.CENTER);
        init();

    }
    public void init(){
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void BookPanel(JPanel panel){
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel BookText = new JLabel("책 정보 입력");
        BookText.setBounds(10, 10, 200, 30);
        BookText.setFont(ui.font2);
        panel.add(BookText);

        Button searchBook = new Button("책 정보 검색하기");
        searchBook.setBounds(230,10,150,30);
        panel.add(searchBook);

        JLabel TitleText = new JLabel("제목");
        setUI(TitleText);
        TitleText.setBounds(10, 70, 100, 25);
        panel.add(TitleText);

        title = new JTextField(20);
        title.setBounds(100, 70, 160, 25);
        panel.add(title);


        JLabel ISBNText = new JLabel("ISBN");
        setUI(ISBNText);
        ISBNText.setBounds(10, 110, 100, 25);
        panel.add(ISBNText);

        ISBN = new JTextField(20);
        ISBN.setBounds(100, 110, 160, 25);
        panel.add(ISBN);

        JLabel yearText = new JLabel("출판년도");
        setUI(yearText);
        yearText.setBounds(10, 150, 130, 25);
        panel.add(yearText);

        year = new JTextField(20);
        year.setBounds(100, 150, 160, 25);
        panel.add(year);

        JLabel publisherText = new JLabel("출판사");
        setUI(publisherText);
        publisherText.setBounds(10, 190, 100, 25);
        panel.add(publisherText);

        publisher = new JTextField(20);
        publisher.setBounds(100, 190, 160, 25);
        panel.add(publisher);

        JLabel authorText = new JLabel("저자");
        setUI(authorText);
        authorText.setBounds(10, 230, 100, 25);
        panel.add(authorText);

        author = new JTextField(20);
        author.setBounds(100, 230, 160, 25);
        panel.add(author);

        //phone number
        JLabel conditionText = new JLabel("상태");
        setUI(conditionText);
        conditionText.setBounds(10, 270, 100, 25);
        panel.add(conditionText);

        JComboBox<String> condition = new JComboBox<String>();
        condition.addItem("Excellent");
        condition.addItem("Good");
        condition.addItem("Fair");
        condition.setBounds(100, 270, 160, 25);
        condition.setFont(ui.font);
        condition.setBackground(Color.WHITE);
        panel.add(condition);


        JLabel priceText = new JLabel("가격");
        setUI(priceText);
        priceText.setBounds(10, 310, 100, 25);
        panel.add(priceText);

        priceT = new JTextField(20);
        priceT.setBounds(100, 310, 160, 25);
        panel.add(priceT);

        JLabel priceL = new JLabel("원가: ");
        priceL.setFont(ui.font3);
        priceL.setForeground(ui.p4);
        priceL.setBounds(270, 310, 40, 25);
        panel.add(priceL);

        price.setFont(ui.font3);
        price.setForeground(ui.p4);
        price.setBounds(310, 310, 70, 25);
        panel.add(price);

        priceT.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        Button signUpbtn = new Button("Add Book!");
        signUpbtn.setBounds(100, 350,250, 40);
        signUpbtn.setBackground(new Color(235, 99, 112));
        panel.add(signUpbtn);
        signUpbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cond = null;
                cond = condition.getSelectedItem().toString();
                checkBook(title.getText(),author.getText(),ISBN.getText(),publisher.getText(),year.getText(),cond,priceT.getText());
            }
        });

        searchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new APIBookSearch(bookGUI);
            }
        });


    }
    public void checkBook(String Title, String Author, String ISBN,String Publisher, String Year, String Condition, String Price){
        if(Title.equals("")){
            JOptionPane.showMessageDialog(null, "Enter Book Title");
            return;
        }

        Book book = new Book(Title,ISBN,Author,Publisher,Year,Condition,userList.whoSignin().getId(),Price);
        bookList.bookArray.add(book);
        book.setBookInfo(info);
        JOptionPane.showMessageDialog(null, "Add Book!");
        dispose();

    }

    public void setUI(JLabel label){
        label.setForeground(new Color(51,51,51));
        label.setFont(ui.font);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setPublisher(String publisher) {
        this.publisher.setText(publisher);
    }

    public void setISBN(String ISBN) {
        this.ISBN.setText(ISBN);
    }

    public void setAuthor(String author) {
        this.author.setText(author);
    }

    public void setPrice(String price) {
        this.price.setText(price);
    }
    public void setYear(String year){
        this.year.setText(year);
    }
}
