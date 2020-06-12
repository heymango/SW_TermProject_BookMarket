import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyBook extends JFrame {
    UI ui = new UI();
    UserList userList;
    BookList bookList;
    BookList myBook = new BookList();
    ListArea edit;
    HomeGUI  home;

    public MyBook(UserList userList, BookList bookList,HomeGUI home){
        super("MyPage");
        this.home = home;
        this.userList = userList;
        this.bookList = bookList;
        setSize(880,640);
        init();
        JPanel background = new JPanel();
        background.setBackground(Color.WHITE);
        background.setLayout(null);
        myBook.bookArray = bookList.searchBook(userList.whoSignin().getId(),"판매자");
        edit = new ListArea(myBook,userList,3);
        background.add(edit);
        edit.setBounds(0,0,860,600);
        button(edit);
        add(background);
    }

    public MyBook(User user, BookList bookList){
        super("User's Book");
        this.bookList = bookList;
        setSize(880,640);
        init();
        JPanel background = new JPanel();
        background.setBackground(Color.WHITE);
        background.setLayout(null);
        myBook.bookArray = bookList.searchBook(user.getId(),"판매자");
        edit = new ListArea(myBook,userList,3);
        background.add(edit);
        edit.setBounds(0,0,860,600);
        add(background);
    }


    public void init() {
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void button(ListArea edit){
        Button editBtn = new Button("수정하기");
        editBtn.setBounds(660, 470, 150, 60);
        editBtn.setFont(ui.font3);
        editBtn.setBackground(ui.s);
        editBtn.setHorizontalAlignment(0);
        editBtn.setForeground(Color.white);
        add(editBtn);
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i =0; i<edit.lineMy.lineArray.size(); i++){
                    String title = edit.lineMy.lineArray.get(i).title.getText();
                    String isbn= edit.lineMy.lineArray.get(i).isbn.getText();
                    String author= edit.lineMy.lineArray.get(i).author.getText();
                    String publisher = edit.lineMy.lineArray.get(i).publisher.getText();
                    String year = edit.lineMy.lineArray.get(i).publishyear.getText();
                    String condition = edit.lineMy.lineArray.get(i).condition.getSelectedItem().toString();
                    String owner = edit.lineMy.lineArray.get(i).owner.getText();
                    Book book = new Book(title,isbn,author,publisher,year,condition,owner);
                    int index = bookList.bookArray.indexOf(edit.lineMy.lineArray.get(i).book);
                    bookList.bookArray.set(index,book);

                }
                dispose();
                home.home.updatePanel(0);
                //home.home.mode = 4;

            }
        });

        Button deleteBtn = new Button("삭제하기");
        deleteBtn.setBounds(480, 470, 150, 60);
        deleteBtn.setFont(ui.font3);
        deleteBtn.setBackground(ui.s);
        deleteBtn.setHorizontalAlignment(0);
        deleteBtn.setForeground(Color.white);
        add(deleteBtn);
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = 0;
                for (int i = 0; i < edit.lineMy.lineArray.size(); i++) {
                    if (edit.lineMy.lineArray.get(i).selected) {
                        bookList.bookArray.remove(edit.lineMy.lineArray.get(i).book);
                        n++;
                    }
                }
                if (n == 0) {
                    JOptionPane.showMessageDialog(null, "Check Book");

                }
                else{
                    dispose();
                    //home.home.mode = 4;
                    home.home.updatePanel(0);


                }
            }
        });
        edit.add(deleteBtn);
        edit.add(editBtn);
    }


}
