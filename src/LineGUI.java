import javax.swing.*;
import java.awt.*;

public class LineGUI extends JPanel {
    Font font = new Font("배달의민족 한나체 Pro",0,17);
    JLabel title, isbn, author, publishyear, publisher, condition, owner,checkbox;
    public LineGUI(){
        setLayout(new GridLayout(1,9));
        setVisible(true);
        setBackground(Color.white);
        checkbox = new JLabel("");

        add(checkbox);
        add(init("제목"));
        add(init("ISBN"));
        add(init("저자"));
        add(init("출판사"));
        add(init("출판년도"));
        add(init("상태"));
        add(init("등록인"));

    }

    public LineGUI(String title, String isbn, String author, String publisher, String publishyear, String condition, String owner){
        setLayout(new GridLayout(1,9));
        setVisible(true);
        setBackground(Color.white);
        JCheckBox checkbox = new JCheckBox("",false);
        checkbox.setBackground(Color.white);
        checkbox.setHorizontalAlignment(0);
        add(checkbox);
        add(init2(title));
        add(init2(isbn));
        add(init2(author));
        add(init2(publisher));
        add(init2(publishyear));
        add(init2(condition));
        add(init2(owner));
    }

    public JLabel init(String s){
        JLabel label = new JLabel(s);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    public JLabel init2(String s){
        JLabel label = new JLabel(s);
        label.setFont(font);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

}
