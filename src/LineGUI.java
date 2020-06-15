import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LineGUI extends JPanel {
    LineGUI lineGUI;
    Boolean selected = false;
    Book book;
    User user;
    int index;
    UI ui = new UI();
    Button activate;
    Button userBook;
    Font font = new Font("배달의민족 한나체 Pro",0,17);
    JLabel checkbox;
    JTextField title, isbn, author, publisher, publishyear,price;
    JComboBox<String> condition = new JComboBox<String>();
    JLabel owner;

    public LineGUI(String type){
        if(type.equals("book")) {
            setLayout(new GridLayout(1, 11));
            setVisible(true);
            setBackground(Color.white);
            checkbox = new JLabel("");
            add(checkbox);
            add(init("제목"));
            add(init("ISBN"));
            add(init("저자"));
            add(init("출판사"));
            add(init("출판년도"));
            add(init("상태"));
            add(init("판매자"));
            add(init("가격"));
            add(init("상세정보"));
        }
        else if(type.equals("edit")) {
            setLayout(new GridLayout(1, 10));
            setVisible(true);
            setBackground(Color.white);
            checkbox = new JLabel("");
            add(checkbox);
            add(init("제목"));
            add(init("ISBN"));
            add(init("저자"));
            add(init("출판사"));
            add(init("출판년도"));
            add(init("상태"));
            add(init("판매자"));
            add(init("가격"));
        }
        else if(type.equals("user")){
            setLayout(new GridLayout(1,8));
            setVisible(true);
            setBackground(Color.white);
            checkbox = new JLabel("");

            add(checkbox);
            add(init("이름"));
            add(init("아이디"));
            add(init("비밀번호"));
            add(init("메일"));
            add(init("전화번호"));
            add(init("상태"));
            add(init("책"));
        }
    }



    public LineGUI(User user, UserList userList, BookList bookList){
        this.user = user;
        setLayout(new GridLayout(1,8));
        setVisible(true);
        setBackground(Color.white);
        JCheckBox checkbox = new JCheckBox();
        checkbox.setBackground(Color.WHITE);
        String name = user.getUsername();
        String id = user.getId();
        String pwd = user.getPassword();
        String mail = user.getEmail();
        String phone = user.getPhone();

        activate = new Button();
        userBook = new Button("등록한 책");
        add(checkbox);
        add(init2(name));
        add(init2(id));
        add(init2(pwd));
        add(init2(mail));
        add(init2(phone));

        if(user.isActivate()) {
            activate.setText("활성화");
            activate.setBackground(ui.s);

        }
        else{
            activate.setText("비활성화");
            activate.setBackground(ui.g);
        }
        add(activate);
        add(userBook);
        userBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyBook(user,bookList);
            }
        });
        activate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =userList.userArray.indexOf(user);
                userList.userArray.get(i).changeActivate();
                activate.setText(userList.userArray.get(i).isActivate()?"활성화":"비활성화");
                activate.setBackground(userList.userArray.get(i).isActivate()?ui.s:ui.g);

            }
        });


        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selected = !selected;
            }
        });
    }

    public LineGUI(Book book){
        this.book = book;
        String title = book.getTitle();
        String isbn = book.getISBN();
        String author = book.getAuthor();
        String publisher = book.getPublisher();
        String publishyear = book.getPublishYear();
        String condition = book.getCondition();
        String owner= book.getUser();
        String price = book.getPrice();
        setLayout(new GridLayout(1,11));
        setVisible(true);
        setBackground(Color.white);

        JCheckBox checkbox = new JCheckBox("",false);
        checkbox.setBackground(Color.white);
        checkbox.setHorizontalAlignment(0);
        add(checkbox);

        Button info = new Button("상세정보");
        add(init2(title));
        add(init2(isbn));
        add(init2(author));
        add(init2(publisher));
        add(init2(publishyear));
        add(init2(condition));
        add(init2(owner));
        add(init2(price));
        add(info);

        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selected = !selected;
            }
        });

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(book.getBookInfo()!=null){
                    new BookInfo(book);
                }
            }
        });
    }


    public LineGUI(Book book,String edit){
        this.book = book;
        String title = book.getTitle();
        String isbn = book.getISBN();
        String author = book.getAuthor();
        String publisher = book.getPublisher();
        String publishyear = book.getPublishYear();
        String condition = book.getCondition();
        String owner= book.getUser();
        String price = book.getPrice();
        setLayout(new GridLayout(1,11));
        setVisible(true);
        setBackground(Color.white);

        JCheckBox checkbox = new JCheckBox("",false);
        checkbox.setBackground(Color.white);
        checkbox.setHorizontalAlignment(0);
        this.title = new JTextField(title);
        this.author = new JTextField(author);
        this.isbn = new JTextField(isbn);
        this.publisher = new JTextField(publisher);
        this.publishyear = new JTextField(publishyear);
        this.price = new JTextField(price);
        this.condition.addItem("Excellent");
        this.condition.addItem("Good");
        this.condition.addItem("Fair");
        this.condition.setSelectedItem(condition);

        this.condition.setBackground(Color.WHITE);
        this.condition.setBounds(120, 270, 100, 25);
        this.condition.setFont(font);
        this.owner = new JLabel(owner);
        init3(this.title);
        init3(this.isbn);
        init3(this.author);
        init3(this.publisher);
        init3(this.publishyear);
        init3(this.price);
        this.owner.setFont(font);
        this.owner.setHorizontalAlignment(JLabel.CENTER);
        this.owner.setBorder(BorderFactory.createEmptyBorder());
        add(checkbox);
        add(this.title);
        add(this.isbn);
        add(this.author);
        add(this.publisher);
        add(this.publishyear);
        add(this.condition);
        add(this.owner);
        add(this.price);
        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selected = !selected;
            }
        });
    }

    public JLabel init(String s){
        JLabel label = new JLabel(s);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    public JLabel init2(String s){
        JLabel label = new JLabel(s);
        label.setFont(font);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    public void init3(JTextField field){
        field.setFont(font);
        field.setHorizontalAlignment(JLabel.CENTER);
        field.setBorder(BorderFactory.createEmptyBorder());

    }


}
