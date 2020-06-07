import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomeGUI extends HomeGUI {
    Button admin;
    AdminHomeGUI homeGUI;
    public AdminHomeGUI(UserList Userlist, BookList BookList) {
        super(Userlist, BookList);
        admin = new Button("관리자");
        admin.setBounds(935,10,100,30);
        super.top.add(admin);

        Button delete = new Button("삭제하기");
        delete.setBounds(500,470,150,60);
        delete.setFont(ui.font3);
        delete.setBackground(ui.p4);
        delete.setHorizontalAlignment(0);
        delete.setForeground(Color.white);
        home.add(delete);
        home.mode = 4;
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


}
