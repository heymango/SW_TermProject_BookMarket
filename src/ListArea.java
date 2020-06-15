
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListArea extends JPanel {
    UI ui = new UI();
    BookList bookList;
    UserList userList;
    LineList lineList;
    LineList lineSearch;
    LineList lineMy;
    LineList lineUser;
    int mode = 0;

    //mode 0 : home
    //mode 1 : admin_home
    //mode 2 : search
    //mode 3 : edit_book
    //mode 4 : edit_user

    public ListArea(BookList bookList, UserList userList, int mode){
        this.bookList= bookList;
        this.userList= userList;
        this.mode = mode;
        listArea(mode);
        if(mode == 0||mode == 1){
            printBook();
        }
        else if(mode ==2){
            //printsearchBook(bookList.bookArray);
        }
        else if(mode == 3){
            printeditBook(bookList.bookArray);
        }
        else{
            printUser(userList,bookList);
        }

    }
/*
    public listArea(UserList userList, BookList bookList, int m){
        this.userList= userList;
        mode = 3;
        bookListArea(mode);
        printUser(userList,bookList);



    }

  */  //Mybook용
    public ListArea(BookList bookList, UserList userList,String userid, int mode){
        this.bookList= bookList;
        this.userList= userList;
        mode = 2;
        printeditBook(bookList.bookArray);
        listArea(mode);
    }


    public void listArea(int mode) {
        //init ui part
        setLayout(null);
        setBackground(Color.white);
        setBounds(210, 100, 1260, 560);

        //상단 코멘트, border
        if(mode<4) {
            TitledBorder border = new TitledBorder(new LineBorder(ui.p, 5), "등록된 책");
            border.setTitleColor(ui.p);
            border.setTitleFont(ui.font);
            setBorder(border);
        }

        //button part


        //mode 0 home
        if(mode == 0){
            Button buyBtn = new Button("구매하기");
            buyBtn.setBounds(860, 470, 150, 60);
            buyBtn.setFont(ui.font3);
            buyBtn.setBackground(ui.s);
            buyBtn.setHorizontalAlignment(0);
            buyBtn.setForeground(Color.white);
            add(buyBtn);

            buyBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int n = 0;

                    for (int i = 0; i < lineList.lineArray.size(); i++) {
                        if (lineList.lineArray.get(i).selected) {
                            bookList.bookArray.remove(lineList.lineArray.get(i).book);
                            n++;
                        }
                    }
                    if (n == 0) {
                        JOptionPane.showMessageDialog(null, "Check Book");

                    } else {
                        BuyBook buyBook = new BuyBook(lineList, userList);
                        updatePanel(mode);
                    }

                    }
            });
            Button reset = new Button("새로고침");
            reset.setBounds(30, 470, 100, 60);
            add(reset);

            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updatePanel(0);
                }
            });

        }


        //mode 1 admin home
        else if(mode == 1){
            Button buyBtn = new Button("구매하기");
            buyBtn.setBounds(860, 470, 150, 60);
            buyBtn.setFont(ui.font3);
            buyBtn.setBackground(ui.s);
            buyBtn.setHorizontalAlignment(0);
            buyBtn.setForeground(Color.white);
            add(buyBtn);

            buyBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int n = 0;

                    for (int i = 0; i < lineList.lineArray.size(); i++) {
                        if (lineList.lineArray.get(i).selected) {
                            bookList.bookArray.remove(lineList.lineArray.get(i).book);
                            n++;
                        }
                    }
                    if (n == 0) {
                        JOptionPane.showMessageDialog(null, "Check Book");

                    } else {
                        BuyBook buyBook = new BuyBook(lineList, userList);
                        updatePanel(mode);
                    }

                }
            });


            Button reset = new Button("새로고침");
            reset.setBounds(30, 470, 100, 60);
            add(reset);

            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updatePanel(1);
                }
            });

            Button delete = new Button("삭제하기");
            delete.setBounds(700,470,150,60);
            delete.setFont(ui.font3);
            delete.setBackground(ui.p4);
            delete.setHorizontalAlignment(0);
            delete.setForeground(Color.white);
            add(delete);
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int n = 0;

                    for (int i = 0; i < lineList.lineArray.size(); i++) {
                        if (lineList.lineArray.get(i).selected) {
                            bookList.bookArray.remove(lineList.lineArray.get(i).book);
                            n++;
                        }
                    }
                    if (n == 0) {
                        JOptionPane.showMessageDialog(null, "Check Book");

                    } else {
                        JOptionPane.showMessageDialog(null, "삭제 완료");
                        updatePanel(1);
                    }

                }
            });
        }

        else if(mode ==2){
            Button buyBtn = new Button("구매하기");
            buyBtn.setBounds(860, 470, 150, 60);
            buyBtn.setFont(ui.font3);
            buyBtn.setBackground(ui.s);
            buyBtn.setHorizontalAlignment(0);
            buyBtn.setForeground(Color.white);
            add(buyBtn);

            buyBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        int n = 0;

                        for (int i = 0; i < lineSearch.lineArray.size(); i++) {
                            if (lineSearch.lineArray.get(i).selected) {
                                bookList.bookArray.remove(lineSearch.lineArray.get(i).book);
                                n++;
                            }
                        }
                        if (n == 0) {
                            JOptionPane.showMessageDialog(null, "Check Book");
                        } else {
                            BuyBook buyBook = new BuyBook(lineSearch, userList);
                            updatePanel(0);
                        }

                    }

            });

            Button gotolist = new Button("목록으로");
            gotolist.setBounds(700,470,150,60);
            gotolist.setFont(ui.font3);
            gotolist.setBackground(ui.p4);
            gotolist.setHorizontalAlignment(0);
            gotolist.setForeground(Color.white);

            add(gotolist);
            gotolist.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updatePanel(0);
                }
            });

        }



        //set booklist index
        if(mode ==4) {
            //유저관리
            LineGUI userIndex = new LineGUI("user");
            userIndex.setBounds(7, 30, 800, 50);
            userIndex.setBackground(ui.p);
            add(userIndex);

        }
        else if(mode ==3){
            LineGUI bookIndex = new LineGUI("edit");
            bookIndex.setBounds(7, 30, 1000, 50);
            bookIndex.setBackground(ui.p);
            add(bookIndex);

        }
        else{
            LineGUI bookIndex = new LineGUI("book");
            bookIndex.setBounds(7, 30, 1000, 50);
            bookIndex.setBackground(ui.p);

            add(bookIndex);

        }


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

        sc.setBounds(7, 80, 1020, 380);
        sc.setViewportView(bookListPanel);
        add(sc);
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
        sc.setBounds(7, 80, 1020, 380);
        sc.setViewportView(bookListPanel);
        add(sc);
    }

    public void printeditBook(ArrayList<Book> bookArray){
        JPanel bookListPanel = new JPanel();
        bookListPanel.setBackground(Color.WHITE);
        bookListPanel.setLayout(null);
        bookListPanel.setVisible(true);

        JScrollPane sc = new JScrollPane(bookListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setViewportBorder(null);
        sc.getVerticalScrollBar().setBackground(Color.WHITE);
        sc.setBorder(BorderFactory.createEmptyBorder());
        lineMy = new LineList(bookArray, bookListPanel,"EDIT");
        sc.setBounds(7, 80, 1020, 380);
        sc.setViewportView(bookListPanel);
        add(sc);


    }

    public void printUser(UserList userList, BookList bookList){
        JPanel bookListPanel = new JPanel();
        bookListPanel.setBackground(Color.WHITE);
        bookListPanel.setLayout(null);
        bookListPanel.setVisible(true);

        JScrollPane sc = new JScrollPane(bookListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setViewportBorder(null);
        sc.getVerticalScrollBar().setBackground(Color.WHITE);
        sc.setBorder(BorderFactory.createEmptyBorder());
        lineUser = new LineList(bookListPanel,userList, bookList);
        sc.setBounds(7, 80, 820, 380);
        sc.setViewportView(bookListPanel);
        add(sc);
        sc.setBackground(Color.RED);
    }


    public void updatePanel(int mode){
        removeAll();
        listArea(mode);

        if(mode == 0||mode == 1){
            printBook();
        }
        else if(mode ==2){
            //printsearchBook(bookList.bookArray);
        }
        else if(mode == 3){
            printeditBook(bookList.bookArray);
        }
        else{
            printUser(userList,bookList);
        }
        revalidate();
        repaint();
    }




}
