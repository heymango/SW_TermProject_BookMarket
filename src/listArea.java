
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class listArea extends JPanel {
    UI ui = new UI();
    JPanel background;
    BookList bookList;
    UserList userList;
    LineList lineList;
    LineList lineSearch;
    Boolean SearchMode = false;

    public listArea(JPanel background, BookList bookList, UserList userList){
        this.background = background;
        this.bookList= bookList;
        this.userList= userList;
        bookListArea(background);
        printBook();
        background.add(this);
    }

    public listArea(JPanel background, UserList userList){
        this.background = background;
        this.userList= userList;
        bookListArea(background);
        printBook();
        background.add(this);
    }
    public void bookListArea(JPanel background) {
        //init ui
        setLayout(null);
        setBackground(Color.white);
        setBounds(210, 100, 860, 560);
        TitledBorder border = new TitledBorder(new LineBorder(ui.p, 5), "등록된 책");
        border.setTitleColor(ui.p);
        border.setTitleFont(ui.font);
        setBorder(border);

        //set booklist index
        LineGUI bookIndex = new LineGUI();
        bookIndex.setBounds(7, 30, 800, 50);
        bookIndex.setBackground(ui.p);
        add(bookIndex);

        Button buyBtn = new Button("구매하기");
        buyBtn.setBounds(660,470,150,60);
        buyBtn.setFont(ui.font3);
        buyBtn.setBackground(ui.s);
        buyBtn.setHorizontalAlignment(0);
        buyBtn.setForeground(Color.white);
        add(buyBtn);
        //set booklist panel
        buyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SearchMode) {
                    for (LineGUI l : lineSearch.lineArray) {
                        System.out.println(l.selected);
                    }
                    System.out.println(lineSearch.lineArray.size());


                }
                else {
                    BuyBook buyBook = new BuyBook(lineList,userList);
                    for(int i =0; i<lineList.lineArray.size(); i++){


                    }
                }
            }
        });

    }

    public void printBook(){
        JPanel bookListPanel = new JPanel();
        bookListPanel.setBackground(Color.WHITE);
        bookListPanel.setLayout(null);
        bookListPanel.setVisible(true);

        JScrollPane sc = new JScrollPane(bookListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setViewportBorder(null);
        sc.getVerticalScrollBar().setBackground(Color.WHITE);
        sc.setBorder(BorderFactory.createEmptyBorder());

        lineList = new LineList(bookList.bookArray, bookListPanel);

        sc.setBounds(7, 80, 820, 380);
        sc.setViewportView(bookListPanel);
        add(sc);
        background.add(this);
    }

    public void printsearchBook(ArrayList<Book> bookArray){
        JPanel bookListPanel = new JPanel();
        bookListPanel.setBackground(Color.WHITE);
        bookListPanel.setLayout(null);
        bookListPanel.setVisible(true);

        JScrollPane sc = new JScrollPane(bookListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setViewportBorder(null);
        sc.getVerticalScrollBar().setBackground(Color.WHITE);
        sc.setBorder(BorderFactory.createEmptyBorder());
        lineSearch = new LineList(bookArray, bookListPanel);
        sc.setBounds(7, 80, 820, 380);
        sc.setViewportView(bookListPanel);
        add(sc);

        Button gotolist = new Button("목록으로");
        gotolist.setBounds(500,470,150,60);
        gotolist.setFont(ui.font3);
        gotolist.setBackground(ui.p4);
        gotolist.setHorizontalAlignment(0);
        gotolist.setForeground(Color.white);

        add(gotolist);
        gotolist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePanel(0);
                SearchMode = false;
            }
        });


        background.add(this);
    }


    public void updatePanel(int i){
        removeAll();
        bookListArea(background);
        if(i==0) {
            printBook();
            revalidate();
            repaint();
        }
    }




}
