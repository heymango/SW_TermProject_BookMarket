import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomeGUI extends HomeGUI {
    Button admin;
    AdminHomeGUI homeGUI;

    public AdminHomeGUI(UserList Userlist, BookList BookList) {
        super(Userlist, BookList);
        isAdmin = true;
        mode = 1;
        admin = new Button("관리자");
        admin.setBounds(935,10,100,30);
        super.top.add(admin);
        homeGUI = this;
        Button delete = new Button("삭제하기");
        delete.setBounds(500,470,150,60);
        delete.setFont(ui.font3);
        delete.setBackground(ui.p4);
        delete.setHorizontalAlignment(0);
        delete.setForeground(Color.white);
        home.add(delete);
        //home.mode = 4;
        /*
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = 0;

                for (int i = 0; i < home.lineList.lineArray.size(); i++) {
                    if (home.lineList.lineArray.get(i).selected) {
                        bookList.bookArray.remove(home.lineList.lineArray.get(i).book);
                        n++;
                    }
                }
                if (n == 0) {
                    JOptionPane.showMessageDialog(null, "Check Book");

                } else {
                    JOptionPane.showMessageDialog(null, "삭제 완료");
                    home.updatePanel(0);
                }

            }
        });
*/

        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new EditUser(userList,bookList);
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
                new SignInGUI(userList,bookList);
            }
        });

        background.add(menu);

    }


}
