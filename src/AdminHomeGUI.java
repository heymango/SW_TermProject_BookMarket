import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomeGUI extends HomeGUI {
    Button admin;
    AdminHomeGUI homeGUI;

    public AdminHomeGUI(UserList Userlist, BookList BookList, int mode) {
        super(Userlist, BookList,mode);
        isAdmin = true;
        homeGUI = this;
    }


    public void menu(JPanel background) {
        JPanel menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(ui.p);
        menu.setBounds(10, 107, 200, 550);


        JLabel adminMode = new JLabel("<관리자모드>");
        adminMode.setFont(ui.font2);
        adminMode.setBounds(0, 0, 200, 183);
        adminMode.setForeground(Color.WHITE);
        adminMode.setHorizontalAlignment(0);
        menu.add(adminMode);

        Button editBook = new Button("회원관리");
        editBook.setFont(ui.font2);
        editBook.setBackground(ui.p3);
        editBook.setBounds(0, 183, 200, 183);
        menu.add(editBook);

        Button exit = new Button("로그아웃");
        exit.setFont(ui.font2);
        exit.setBackground(ui.p4);
        exit.setBounds(0, 366, 200, 184);
        menu.add(exit);


        editBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new EditUser(userList,bookList);
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
