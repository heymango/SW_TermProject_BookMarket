import javax.swing.*;
import java.awt.*;

public class BuyBook extends JFrame {
    UI ui = new UI();
    LineList line;
    UserList userList;
    public BuyBook(LineList line, UserList userList){
        super("BuyBOOK");
        setSize(500,360);
        init();
        this.line = line;
        this.userList = userList;
        JPanel background = new JPanel();
        background.setLayout(null);
        baseicGUI(background);
        add(background);

    }

    public void init(){
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    public void baseicGUI(JPanel background){
        background.setBackground(Color.WHITE);
        JLabel title = new JLabel("구매 완료");
        title.setFont(ui.font2);
        title.setForeground(ui.g);
        title.setBounds(10,0,300,40);
        background.add(title);
        String me = userList.whoSignin().getUsername()+userList.whoSignin().getEmail();


        int n=0;
        for(int i =0; i<line.lineArray.size(); i++) {
           if(line.lineArray.get(i).selected){
               String mail = line.lineArray.get(i).book.getUser()+"에게 메일 전송 "+userList.userMail(line.lineArray.get(i).book.getUser());
               JLabel mailL = new JLabel(mail);
               mailL.setFont(ui.font);
               mailL.setForeground(ui.p);
               mailL.setBounds(0,150+25*i,500,25);
               mailL.setHorizontalAlignment(0);
               background.add(mailL);
               n++;
           }
        }
        JLabel m = new JLabel(n+"권의 책을 구매 완료!");
        m.setForeground(ui.g);
        m.setFont(ui.font);
        m.setBounds(0,0,500,50);
        m.setHorizontalAlignment(0);
        background.add(m);



        Button success = new Button("돌아가기");

    }

    public void printBook(){

    }



}
