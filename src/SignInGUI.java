import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class SignInGUI extends JFrame {
    UI ui = new UI();
    private JTextField userid;
    private JPasswordField userpwd;
    UserList userList;
    BookList bookList;

    public SignInGUI(UserList User, BookList BookList) {
        super("Sign In");
        userList = User;
        bookList = BookList;
        setSize(300, 160);
        init();
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        loginPanel(panel);
        add(panel, BorderLayout.CENTER);
        setFont(ui.font3);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                new SaveToFile(userList, bookList, "User.txt","Book.txt");
                System.out.println("!!!!!!!!!!!!!!!!!");
            }
        });
    }

    public void init() {
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void loginPanel(JPanel panel) {
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        JLabel userLabel = new JLabel("User ID");
        userLabel.setForeground(new Color(51, 51, 51));
        userLabel.setBounds(10, 10, 80, 25);
        userLabel.setFont(ui.font3);
        panel.add(userLabel);

        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(new Color(51, 51, 51));
        passLabel.setBounds(10, 40, 80, 25);
        passLabel.setFont(ui.font3);
        panel.add(passLabel);

        userid = new JTextField(20);
        userid.setBounds(100, 10, 160, 25);
        panel.add(userid);

        userpwd = new JPasswordField(20);
        userpwd.setBounds(100, 40, 160, 25);
        panel.add(userpwd);

        Button signinbtn = new Button("Sign In");
        signinbtn.setBounds(170, 80, 90, 30);
        signinbtn.setBackground(new Color(235, 99, 112));
        panel.add(signinbtn);
        signinbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkSignIn();
            }
        });

        Button signupbtn = new Button("Sign Up");
        signupbtn.setBounds(10, 80, 90, 30);
        panel.add(signupbtn);
        signupbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUpGUI(userList, bookList);
                dispose();
            }
        });
    }

    public void checkSignIn() {

        String p = String.valueOf(userpwd.getPassword());
        System.out.println(p);
        if (userid.getText().equals("") || p.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the User ID and Password");
        } else if (userList.isUserThere(userid.getText())) {
            if (p.equals(userList.userPwd(userid.getText()))) {
                System.out.println("success");
                userList.changeUserState(userid.getText());
                if (userid.getText().equals("admin")) {
                    new AdminHomeGUI(userList, bookList, 1);
                    dispose();
                } else {
                    if (userList.getUser(userid.getText()).isActivate()) {
                        new HomeGUI(userList, bookList, 0);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Deactivated user");
                    }
                }

            } else {
                System.out.println("false");
                JOptionPane.showMessageDialog(null, "Wrong Password Retry");
            }
        } else {
            System.out.println("false");
            JOptionPane.showMessageDialog(null, "Unknown User, Sign Up First!");
        }
    }

}
