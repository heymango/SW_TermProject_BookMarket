import com.google.gson.JsonObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class BookInfo extends JFrame {
    UI ui = new UI();
    public BookInfo(Book book){
        super("Information");
        setSize(950,300);
        init();
        JPanel background = new JPanel();
        background.setLayout(null);
        background.setBackground(Color.WHITE);
        printline(background,book.getBookInfo());
        add(background);
    }

    public void printline(JPanel line, List object){
        URL url = null;
        Image image =null;

        String u = object.getItem(2);
        if(u !=null&&!u.equals("")) {
            try {
                url = new URL(u);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                image = ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            JLabel img = new JLabel(new ImageIcon(image));
            line.add(img);
            img.setBounds(0,0,90,130);

        }
        else{
            JLabel img = new JLabel("No Image");
            line.add(img);
            img.setBounds(0,0,90,130);
            img.setFont(ui.font);
            img.setForeground(ui.p4);
        }


        String t ="<html>"+object.getItem(0)+"</html>";
        JLabel title = new JLabel(t);
        title.setVerticalAlignment(SwingConstants.NORTH);
        title.setFont(ui.font);
        title.setBounds(100,5,400,40);
        title.setBackground(ui.p4);
        line.add(title);

        String info ="<html>"+object.getItem(3)+" 지음 | "+object.getItem(4)+" 출판 | "+object.getItem(5)+" | 원가: "+object.getItem(8)+"</html>";
        JLabel infoL = new JLabel(info);
        infoL.setFont(ui.font4);
        infoL.setBounds(100,55,750,20);
        infoL.setForeground(ui.p4);
        line.add(infoL);

        String isbn13 = object.getItem(6);

        JLabel ISBN = new JLabel("ISBN : "+isbn13);
        ISBN.setFont(ui.font4);
        ISBN.setBounds(610,5,170,40);
        ISBN.setForeground(ui.p4);
        line.add(ISBN);

        String description = "<html>"+object.getItem(7)+"</html>";
        JLabel des = new JLabel(description);
        des.setForeground(ui.g);
        des.setFont(ui.font4);
        des.setBounds(100,80,750,200);
        line.add(des);

        Button link = new Button("네이버 책에서 더보기");
        link.setForeground(ui.p);
        link.setBounds(790,5,140,40);
        link.setBackground(Color.white);
        line.add(link);


        link.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(object.getItem(1)));
                }
                catch (IOException | URISyntaxException err) { err.printStackTrace(); }


            }
        });

    }

    public String isbn13(String isbn){
        if(isbn.length()>10) {
            String[] parse = isbn.split(" ");
            isbn = parse[1];
        }
        return isbn;
    }




    public void init() {
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }


}
