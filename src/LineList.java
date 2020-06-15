import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class LineList {
    ArrayList<LineGUI> lineArray = new ArrayList<LineGUI>();
    ArrayList<List> info = new ArrayList<List>();
    public LineList(ArrayList<Book> bookList, JPanel bookListPanel){
        int i = 0;
        for (i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            LineGUI bookInfo = new LineGUI(book);
            lineArray.add(bookInfo);
            bookInfo.setBounds(0, 50 * i, 1000, 50);
            bookListPanel.add(bookInfo);
        }
        bookListPanel.setPreferredSize(new Dimension(1000,50*i));
    }

    public LineList(ArrayList<Book> bookList, JPanel bookListPanel, String edit){
        int i = 0;
        for (i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            LineGUI bookInfo = new LineGUI(book,edit);
            lineArray.add(bookInfo);
            info.add(book.getBookInfo());
            bookInfo.setBounds(0, 50 * i, 1000, 50);
            bookListPanel.add(bookInfo);
            bookInfo.setBackground(Color.WHITE);
        }
        bookListPanel.setPreferredSize(new Dimension(1000,50*i));
    }


    public LineList(JPanel bookListPanel, UserList userList, BookList bookList){
        int n = 0;
        for (int i = 0; i < userList.userArray.size(); i++) {
            User user = userList.userArray.get(i);
            if(!user.isAdmin()) {
                LineGUI bookInfo = new LineGUI(user, userList, bookList);
                lineArray.add(bookInfo);
                bookInfo.setBounds(0, 50 * n, 800, 50);
                bookListPanel.add(bookInfo);
                bookInfo.setBackground(Color.WHITE);
                n++;
            }
        }
        bookListPanel.setPreferredSize(new Dimension(800,50*n));
    }


}
