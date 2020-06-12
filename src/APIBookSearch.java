import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class APIBookSearch extends JFrame {
    UI ui = new UI();
    BookGUI bookGUI;
    JPanel background;
    JPanel resultArea;
    public APIBookSearch(BookGUI bookGUI){
        super("Book Info From NAVER BOOK ");
        this.bookGUI = bookGUI;
        setSize(1000, 700);
        setBackground(Color.WHITE);
        background = new JPanel();
        resultArea = new JPanel();
        resultArea.setBounds(0, 60, 1000, 600);
        resultArea.setBackground(Color.WHITE);
        resultArea.setLayout(null);
        background.setBackground(Color.WHITE);
        background.setLayout(null);
        searchLayout();
        background.add(resultArea);
        add(background);
        init();

    }

    public void searchLayout(){
        JPanel search = new JPanel();
        search.setBackground(Color.WHITE);
        search.setLayout(null);

        search.setBounds(0,20,1000,40);

        Button searchBtn = new Button("검색");
        searchBtn.setBounds(870,0,70,40);
        searchBtn.setFont(ui.font3);
        searchBtn.setBackground(ui.s);
        searchBtn.setHorizontalAlignment(0);
        searchBtn.setForeground(Color.white);
        search.add(searchBtn);

        JComboBox<String> searchC = new JComboBox<String>();
        searchC.addItem("제목");
        searchC.addItem("ISBN");
        searchC.addItem("저자");
        searchC.addItem("출판사");
        searchC.setBounds(50,0,130,40);
        searchC.setFont(ui.font);
        searchC.setForeground(ui.g);
        searchC.setBackground(Color.WHITE);
        search.add(searchC);

        JTextField searchField = new JTextField();
        searchField.setBounds(190,0,670,40);
        searchField.setFont(ui.font);
        searchField.setBorder(new BasicBorders.FieldBorder(ui.p4,ui.p4,ui.p4,ui.p4));
        searchField.setForeground(ui.g);
        search.add(searchField);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.removeAll();
                search(searchField.getText(),searchC.getSelectedItem().toString());
                background.repaint();
                background.revalidate();
            }
        });
        background.add(search);
    }


    public void search(String search, String type){

        JsonArray memberArray =getAPI(search,type);
        JPanel searchResult = new JPanel();
        //searchResult.setBackground(Color.WHITE);

        searchResult.setLayout(null);
        JScrollPane sc = new JScrollPane(searchResult, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setViewportBorder(null);
        sc.getVerticalScrollBar().setBackground(Color.WHITE);
        sc.setBorder(BorderFactory.createEmptyBorder());
        sc.setBackground(Color.WHITE);

        for (int i = 0; i < memberArray.size(); i++) {
            JsonObject object = (JsonObject) memberArray.get(i);
            JPanel line = new JPanel();
            line.setBounds(0,135*i,950,130);
            line.setBackground(Color.WHITE);
            line.setLayout(null);
            printLine(line, object);
            searchResult.add(line);

        }
        searchResult.setPreferredSize(new Dimension(950,135*memberArray.size()-1));
        sc.setBounds(10, 0, 950, 550);
        sc.setViewportView(searchResult);
        resultArea.add(sc);
    }


    public void printLine(JPanel line, JsonObject object){
        URL url = null;
        Image image =null;

        String u = object.get("image").getAsString();
        try {
            url = new URL(object.get("image").getAsString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            JLabel img = new JLabel("No Image");
            line.add(img);
            img.setBounds(0,0,90,130);
            img.setFont(ui.font);
            img.setForeground(ui.p4);
        }

        try {
            image = ImageIO.read(url);
            JLabel img = new JLabel(new ImageIcon(image));
            line.add(img);
            img.setBounds(0,0,90,130);

        } catch (IOException e) {
           // e.printStackTrace();
            JLabel img = new JLabel("No Image");
            line.add(img);
            img.setBounds(0,0,90,130);
            img.setFont(ui.font);
            img.setForeground(ui.p4);
        }







        String t ="<html>"+object.get("title").getAsString()+"</html>";
        JLabel title = new JLabel(t);
        title.setVerticalAlignment(SwingConstants.NORTH);
        title.setFont(ui.font);
        title.setBounds(100,5,400,40);
        title.setBackground(ui.p4);
        line.add(title);

        String info ="<html>"+object.get("author").getAsString()+" 지음 | "+object.get("publisher").getAsString()+" 출판 | "+object.get("pubdate").getAsString()+"</html>";
        JLabel infoL = new JLabel(info);
        infoL.setFont(ui.font4);
        infoL.setBounds(100,55,750,20);
        infoL.setForeground(ui.p4);
        line.add(infoL);

        String isbn13 = isbn13(object.get("isbn").getAsString());

        JLabel ISBN = new JLabel("ISBN : "+isbn13);
        ISBN.setFont(ui.font4);
        ISBN.setBounds(610,5,170,40);
        ISBN.setForeground(ui.p4);
        line.add(ISBN);

        String description = "<html>"+object.get("description").getAsString()+"</html>";
        JLabel des = new JLabel(description);
        des.setForeground(ui.g);
        des.setFont(ui.font4);
        des.setBounds(100,80,750,50);
        line.add(des);

        Button link = new Button("네이버 책에서 더보기");
        link.setForeground(ui.p);
        link.setBounds(790,5,140,40);
        link.setBackground(Color.white);
        line.add(link);

        Button getinfo = new Button("<html>정보<br>담기</html>");
        getinfo.setBounds(860,75,70,50);
        getinfo.setBackground(ui.p4);
        line.add(getinfo);

        link.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(object.get("link").getAsString()));
                }
                catch (IOException | URISyntaxException err) { err.printStackTrace(); }


            }
        });

        getinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInfo(object);
            }
        });
    }



    public void getInfo(JsonObject object){
        String title = object.get("title").getAsString().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
        String author = object.get("author").getAsString().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
        String publisher = object.get("publisher").getAsString().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
        String publishyear = object.get("pubdate").getAsString();
        String year = publishyear.substring(0,4);
        String isbn = isbn13(object.get("isbn").getAsString());


        bookGUI.title.setText(title);
        bookGUI.author.setText(author);
        bookGUI.ISBN.setText(isbn);
        bookGUI.publisher.setText(publisher);
        bookGUI.year.setText(year);
        bookGUI.object = object;
        dispose();
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


    public JsonArray getAPI(String search, String type){
        switch (type) {
            case "제목" -> type = "d_titl";
            case "ISBN" -> type = "d_isbn";
            case "저자" -> type = "d_auth";
            case "출판사" -> type = "d_publ";
        }

        String clientId = "v52j4T22yo2wytf7XVU9";
        String clientSecret = "CbVNOBbeBo";

        String query = null;
        try {
            query = URLEncoder.encode(search,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        URL url = null;

        try {
            url = new URL("https://openapi.naver.com/v1/search/book_adv.json?"+type+"="+query+"&display=50");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        URLConnection urlConn= null;
        try {
            urlConn = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonParser json = new JsonParser();

        urlConn.setRequestProperty("X-Naver-Client-ID", clientId);
        urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String msg = null;
        StringBuffer b = new StringBuffer();

        while(true)
        {
            try {
                if ((msg = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            b.append(msg);
        }

        String result = b.toString();
        JsonParser Parser = new JsonParser();
        JsonObject jsonObj = (JsonObject) Parser.parse(result);
        JsonArray memberArray = (JsonArray) jsonObj.get("items");
        return memberArray;
    }



}
