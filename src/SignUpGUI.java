import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SignUpGUI extends JFrame {
    UserList userList;
    BookList bookList;
    private JTextField userid;
    private Boolean checkId = false;
    public SignUpGUI(UserList UserList, BookList BookList){
        super("Sign Up");
        setSize(450, 400);
        userList = UserList;
        bookList = BookList;
        init();
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        signUpPanel(panel);
        add(panel, BorderLayout.CENTER);

    }
    public void init(){
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void signUpPanel(JPanel panel){
        Font font1 = new Font("배달의민족 을지로체 TTF",0,25);
        Font font2 = new Font("배달의민족 을지로체 TTF",0,15);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel signUpText = new JLabel("Sign Up");
        signUpText.setBounds(10, 10, 500, 30);
        signUpText.setFont(font1);
        panel.add(signUpText);

        JLabel userIDText = new JLabel("User ID");
        userIDText.setForeground(new Color(51,51,51));
        userIDText.setBounds(10, 70, 80, 25);
        userIDText.setFont(font2);
        panel.add(userIDText);

        userid = new JTextField(20);
        userid.setBounds(90, 70, 160, 25);
        panel.add(userid);

        Button idCheckBtn = new Button("check");
        idCheckBtn.setBackground(new Color(235, 99, 112));
        idCheckBtn.setBounds(260, 70, 80,25 );
        panel.add(idCheckBtn);


        JLabel pwdText = new JLabel("Password");
        pwdText.setForeground(new Color(51,51,51));
        pwdText.setBounds(10, 110, 80, 25);
        pwdText.setFont(font2);
        panel.add(pwdText);

        JTextField pwd = new JTextField(20);
        pwd.setBounds(90, 110, 160, 25);
        panel.add(pwd);

        JLabel nameText = new JLabel("Name");
        nameText.setForeground(new Color(51,51,51));
        nameText.setBounds(10, 150, 80, 25);
        nameText.setFont(font2);
        panel.add(nameText);

        JTextField name = new JTextField(20);
        name.setBounds(90, 150, 160, 25);
        panel.add(name);

        //phone number
        JLabel phoneText = new JLabel("Phone");
        phoneText.setForeground(new Color(51,51,51));
        phoneText.setBounds(10, 190, 80, 25);
        phoneText.setFont(font2);
        panel.add(phoneText);

        JTextField phone1 = new JTextField(20);
        phone1.setBounds(90, 190, 50, 25);
        panel.add(phone1);

        JLabel p1 = new JLabel("-");
        p1.setBounds(140, 190, 20, 25);
        p1.setFont(font2);
        p1.setHorizontalAlignment(JLabel.CENTER);
        panel.add(p1);

        JTextField phone2 = new JTextField(20);
        phone2.setBounds(160, 190, 70, 25);
        panel.add(phone2);

        JLabel p2 = new JLabel("-");
        p2.setBounds(230, 190, 20, 25);
        p2.setFont(font2);
        p2.setHorizontalAlignment(JLabel.CENTER);
        panel.add(p2);

        JTextField phone3 = new JTextField(20);
        phone3.setBounds(250, 190, 70, 25);
        panel.add(phone3);

        onlyNumber(phone1);
        onlyNumber(phone2);
        onlyNumber(phone3);

        //mail
        JLabel mailText = new JLabel("Email");
        mailText.setForeground(new Color(51,51,51));
        mailText.setBounds(10, 230, 80, 25);
        mailText.setFont(font2);
        panel.add(mailText);

        JTextField mail1 = new JTextField(20);
        mail1.setBounds(90, 230, 130, 25);
        panel.add(mail1);

        JLabel m = new JLabel("@");
        m.setBounds(220, 230, 30, 25);
        m.setFont(font2);
        m.setHorizontalAlignment(JLabel.CENTER);
        panel.add(m);

        JTextField mail2 = new JTextField(20);
        mail2.setBounds(250, 230, 130, 25);
        panel.add(mail2);


        Button signUpbtn = new Button("Sign UP!");
        signUpbtn.setBounds(100, 280,250, 40);
        signUpbtn.setBackground(new Color(235, 99, 112));
        panel.add(signUpbtn);
        signUpbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phone = phone1.getText()+phone2.getText()+phone3.getText();
                String mail = mail1.getText()+"@"+mail2.getText();
                checkSignUp(userid.getText(),pwd.getText(),name.getText(),phone,mail);
            }
        });


        idCheckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkDuplicate();
            }
        });
    }

    private void onlyNumber(JTextField phone) {
        phone.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void checkDuplicate(){
        if(userid.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter the ID");
        }
        else if(userList.isUserThere(userid.getText())){
            JOptionPane.showMessageDialog(null, "Duplicate ID");
            userid.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null, "Available ID");
            checkId = true;
        }
    }

    public void checkSignUp(String Id, String Pwd, String Name, String Phone, String Mail){

        if(Id.equals("")){
            JOptionPane.showMessageDialog(null, "Enter ID");
            return;
        }
        if(!checkId){
            JOptionPane.showMessageDialog(null, "Check ID Duplicate");
            return;
        }
        if(Pwd.equals("")){
            JOptionPane.showMessageDialog(null, "Enter Password");
            return;
        }

        if(Name.equals("")){
            JOptionPane.showMessageDialog(null, "Enter Name");
            return;
        }

        if(Phone.equals("")){
            JOptionPane.showMessageDialog(null, "Enter Phone number");
            return;
        }
        if(Mail.equals("")){
            JOptionPane.showMessageDialog(null, "Enter Email");
            return;
        }
        if(Id.equals("admin")){
            User user = new User(Id,Pwd,Name,Phone,Mail,true);
        }

        User user = new User(Id,Pwd,Name,Phone,Mail,false);
        userList.addUser(user);
        JOptionPane.showMessageDialog(null, "Sign Up Success!");
        new SignInGUI(userList,bookList);
        dispose();
    }




}
