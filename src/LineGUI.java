import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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
    Button deactivate;
    Button activate;
    Font font = new Font("배달의민족 한나체 Pro",0,17);
    JLabel checkbox;
    JTextField title, isbn, author, publisher, publishyear;
    JComboBox<String> condition = new JComboBox<String>();
    JLabel owner;
    public LineGUI(){
        setLayout(new GridLayout(1,9));
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

    }

    public LineGUI(String user){
        setLayout(new GridLayout(1,7));
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

    }

    public LineGUI(User user, UserList userList, BookList bookList){
        removeAll();

        this.user = user;
        setLayout(new GridLayout(1,7));
        setVisible(true);
        setBackground(Color.white);
        JCheckBox checkbox = new JCheckBox();
        checkbox.setBackground(Color.WHITE);
        String name = user.getUsername();
        String id = user.getId();
        String pwd = user.getPassword();
        String mail = user.getEmail();
        String phone = user.getPhone();
        deactivate = new Button("비활성화");
        activate = new Button("활성화");
        activate.setBackground(ui.s);
        if(user.isActivate()) {
            add(checkbox);
            add(init2(name));
            add(init2(id));
            add(init2(pwd));
            add(init2(mail));
            add(init2(phone));
            add(deactivate);
        }
        else{
            add(checkbox);
            add(init2(name));
            add(init2(id));
            add(init2(pwd));
            add(init2(mail));
            add(init2(phone));
            add(activate);
        }

        deactivate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =userList.userArray.indexOf(user);
                userList.userArray.get(i).changeActivateToFalse();

                update(user,userList,bookList);
                revalidate();
                repaint();


            }
        });

        activate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =userList.userArray.indexOf(user);
                userList.userArray.get(i).changeActivateToTrue();
                update(user,userList,bookList);
                revalidate();
                repaint();

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
        setLayout(new GridLayout(1,9));
        setVisible(true);
        setBackground(Color.white);
        System.out.println(index);
        JCheckBox checkbox = new JCheckBox("",false);
        checkbox.setBackground(Color.white);
        checkbox.setHorizontalAlignment(0);
        add(checkbox);
        add(init2(title));
        add(init2(isbn));
        add(init2(author));
        add(init2(publisher));
        add(init2(publishyear));
        add(init2(condition));
        add(init2(owner));
        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selected = !selected;
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
        setLayout(new GridLayout(1,9));
        setVisible(true);
        setBackground(Color.white);
        System.out.println(index);
        JCheckBox checkbox = new JCheckBox("",false);
        checkbox.setBackground(Color.white);
        checkbox.setHorizontalAlignment(0);
        this.title = new JTextField(title);
        this.author = new JTextField(author);
        this.isbn = new JTextField(isbn);
        this.publisher = new JTextField(publisher);
        this.publishyear = new JTextField(publishyear);
        this.condition.addItem("Excellent");
        this.condition.addItem("Good");
        this.condition.addItem("Fair");
        this.condition.setBackground(Color.WHITE);
        this.condition.setBounds(120, 270, 100, 25);
        this.condition.setFont(font);
        this.owner = new JLabel(owner);
        init3(this.title);
        init3(this.isbn);
        init3(this.author);
        init3(this.publisher);
        init3(this.publishyear);

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
    public void update(User user, UserList userList, BookList bookList){
        removeAll();
        setLayout(new GridLayout(1,7));
        setVisible(true);
        setBackground(Color.white);
        JCheckBox checkbox = new JCheckBox();
        checkbox.setBackground(Color.WHITE);
        String name = user.getUsername();
        String id = user.getId();
        String pwd = user.getPassword();
        String mail = user.getEmail();
        String phone = user.getPhone();
        deactivate = new Button("비활성화");
        activate = new Button("활성화");
        activate.setBackground(ui.s);
        if(user.isActivate()) {
            add(checkbox);
            add(init2(name));
            add(init2(id));
            add(init2(pwd));
            add(init2(mail));
            add(init2(phone));
            add(deactivate);
        }
        else{
            add(checkbox);
            add(init2(name));
            add(init2(id));
            add(init2(pwd));
            add(init2(mail));
            add(init2(phone));
            add(activate);
        }
        revalidate();
        repaint();

    }


}
