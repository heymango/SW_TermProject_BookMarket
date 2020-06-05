import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookGUI extends JFrame {
    UserList userList;
    BookList bookList;
    private Boolean checkId = false;
    public BookGUI(UserList UserList, BookList BookList){
        super("AddBook");
        setSize(450, 450);
        userList = UserList;
        bookList = BookList;
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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void BookPanel(JPanel panel){
        Font font1 = new Font("배달의민족 을지로체 TTF",0,25);
        Font font2 = new Font("배달의민족 을지로체 TTF",0,15);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel BookText = new JLabel("Book Info");
        BookText.setBounds(10, 10, 500, 30);
        BookText.setFont(font1);
        panel.add(BookText);

        JLabel TitleText = new JLabel("Title");
        TitleText.setForeground(new Color(51,51,51));
        TitleText.setBounds(10, 70, 100, 25);
        TitleText.setFont(font2);
        panel.add(TitleText);

        JTextField title = new JTextField(20);
        title.setBounds(120, 70, 160, 25);
        panel.add(title);


        JLabel ISBNText = new JLabel("ISBN");
        ISBNText.setForeground(new Color(51,51,51));
        ISBNText.setBounds(10, 110, 100, 25);
        ISBNText.setFont(font2);
        panel.add(ISBNText);

        JTextField ISBN = new JTextField(20);
        ISBN.setBounds(120, 110, 160, 25);
        panel.add(ISBN);

        JLabel yearText = new JLabel("Publication"+"\n"+"year");
        yearText.setForeground(new Color(51,51,51));
        yearText.setBounds(10, 150, 100, 25);
        yearText.setFont(font2);
        panel.add(yearText);

        JTextField year = new JTextField(20);
        year.setBounds(120, 150, 160, 25);
        panel.add(year);

        JLabel publisherText = new JLabel("Publisher");
        publisherText.setForeground(new Color(51,51,51));
        publisherText.setBounds(10, 190, 100, 25);
        publisherText.setFont(font2);
        panel.add(publisherText);

        JTextField publisher = new JTextField(20);
        publisher.setBounds(120, 190, 160, 25);
        panel.add(publisher);

        JLabel authorText = new JLabel("Author");
        authorText.setForeground(new Color(51,51,51));
        authorText.setBounds(10, 230, 100, 25);
        authorText.setFont(font2);
        panel.add(authorText);

        JTextField author = new JTextField(20);
        author.setBounds(120, 230, 160, 25);
        panel.add(author);

        //phone number
        JLabel conditionText = new JLabel("Condition");
        conditionText.setForeground(new Color(51,51,51));
        conditionText.setBounds(10, 270, 100, 25);
        conditionText.setFont(font2);
        panel.add(conditionText);

        JComboBox<String> condition = new JComboBox<String>();
        condition.addItem("Excellent");
        condition.addItem("Good");
        condition.addItem("Fair");
        condition.setBounds(120, 270, 100, 25);
        condition.setFont(font2);
        panel.add(condition);


        Button signUpbtn = new Button("Add Book!");
        signUpbtn.setBounds(100, 350,250, 40);
        signUpbtn.setBackground(new Color(235, 99, 112));
        panel.add(signUpbtn);
        signUpbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cond = null;
                cond = condition.getSelectedItem().toString();
                checkBook(title.getText(),author.getText(),ISBN.getText(),publisher.getText(),year.getText(),cond);
            }
        });


    }
    public void checkBook(String Title, String Author, String ISBN,String Publisher, String Year, String Condition){
        if(Title.equals("")){
            JOptionPane.showMessageDialog(null, "Enter Book Title");
            return;
        }

        Book book = new Book(Title,ISBN,Author,Publisher,Year,Condition,userList.whoSignin().getId());
        bookList.bookArray.add(book);
        JOptionPane.showMessageDialog(null, "Add Book!");
        new HomeGUI(userList,bookList);
        dispose();
    }

}
