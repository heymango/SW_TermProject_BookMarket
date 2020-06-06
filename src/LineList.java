import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LineList {
    ArrayList<LineGUI> lineArray = new ArrayList<LineGUI>();
    public LineList(ArrayList<Book> bookList, JPanel bookListPanel){
        int i = 0;
        for (i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            LineGUI bookInfo = new LineGUI(book);
            lineArray.add(bookInfo);
            bookInfo.setBounds(0, 50 * i, 800, 50);
            bookListPanel.add(bookInfo);
        }
        bookListPanel.setPreferredSize(new Dimension(800,50*i));

    }
}
