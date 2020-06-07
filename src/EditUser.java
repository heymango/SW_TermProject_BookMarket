import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditUser extends JFrame {
    UI ui = new UI();
    UserList userList;
    BookList bookList;
    BookList myBook = new BookList();
    listArea edit;
    HomeGUI  homeGUI;
    public EditUser(UserList userList, BookList bookList){
        super("Users");
        this.homeGUI = homeGUI;
        this.userList = userList;
        this.bookList = bookList;
        setSize(880,640);
        init();

        JPanel background = new JPanel();
        background.setBackground(Color.WHITE);
        background.setLayout(null);


        edit = new listArea(background,userList,bookList);
        edit.setBounds(0,0,860,600);
        //button(edit);
        add(background);

        Button delete = new Button("삭제");
        delete.setBounds(660, 470, 150, 60);
        delete.setFont(ui.font3);
        delete.setBackground(ui.s);
        delete.setHorizontalAlignment(0);
        delete.setForeground(Color.white);
        edit.add(delete);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = 0;
                for (int i = 0; i < edit.lineUser.lineArray.size(); i++) {
                    if (edit.lineUser.lineArray.get(i).selected&&!edit.lineUser.lineArray.get(i).user.isActivate()) {
                        userList.userArray.remove(edit.lineUser.lineArray.get(i).user);
                        ArrayList<Book> book = bookList.searchBook(edit.lineUser.lineArray.get(i).user.getId(),"판매자");
                        for(int j =0; j<book.size(); j++){
                            bookList.bookArray.remove(book.get(j));
                        }

                        n++;
                    }
                }
                if (n == 0) {
                    JOptionPane.showMessageDialog(null, "Check User");
                } else {
                    edit.background.removeAll();
                    edit.bookListArea(background);
                    edit.printUser(userList,bookList);
                    edit.background.revalidate();
                    edit.background.repaint();
                    edit.setBounds(0,0,860,600);
                }
            }
        });

    }

    public void init() {
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
