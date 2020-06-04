import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SignInGUI extends JFrame {
        private JTextField userid;
        private JPasswordField userpwd;
        //private boolean signinCheck = true;
        private int errorcode;
        UserList user;
        BookList bookList;
        public SignInGUI(UserList User, BookList BookList){
            super("Sign In");
            setSize(300,160);
            setVisible(true);
            setResizable(false);
            setLayout(new BorderLayout());
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            user = User;
            bookList = BookList;
            JPanel panel = new JPanel();
            loginPanel(panel);
            add(panel,BorderLayout.CENTER);
            setVisible(true);
        }

    public void loginPanel(JPanel panel) {
        Font font = new Font(null,Font.BOLD,13);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        JLabel userLabel = new JLabel("User ID");
        userLabel.setForeground(new Color(51,51,51));
        userLabel.setBounds(10, 10, 80, 25);
        userLabel.setFont(font);
        panel.add(userLabel);

        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(new Color(51,51,51));
        passLabel.setBounds(10, 40, 80, 25);
        passLabel.setFont(font);
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
                new SignUpGUI(user,bookList);
                dispose();
            }
        });
    }

    public void checkSignIn(){
            String p = String.valueOf(userpwd.getPassword());
        System.out.println(p);
        if(userid.getText().equals("")||p.equals("")){
            JOptionPane.showMessageDialog(null, "Enter the User ID and Password");
        }
        else if(user.isUserThere(userid.getText())){
            if(p.equals(user.userPwd(userid.getText()))){
                System.out.println("success");
                new HomeGUI(user,bookList);
            }

            else{
                System.out.println("false");
                JOptionPane.showMessageDialog(null, "Wrong Password Retry");
            }
        }
        else{
            System.out.println("false");
            JOptionPane.showMessageDialog(null, "Unknown User, Sign Up First!");
        }
    }

}
