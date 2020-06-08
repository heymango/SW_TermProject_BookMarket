
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

    public listArea(BookList bookList, UserList userList, int mode){
        this.bookList= bookList;
        this.userList= userList;
        this.mode = mode;
        bookListArea(mode);
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
    public listArea(BookList bookList, UserList userList,String userid, int mode){
        this.bookList= bookList;
        this.userList= userList;
        mode = 2;
        printeditBook(bookList.bookArray);
        bookListArea(mode);
    }


    public void bookListArea(int mode) {
        //init ui part
        setLayout(null);
        setBackground(Color.white);
        setBounds(210, 100, 860, 560);

        //상단 코멘트, border
        if(mode<4) {
            TitledBorder border = new TitledBorder(new LineBorder(ui.p, 5), "등록된 책");
            border.setTitleColor(ui.p);
            border.setTitleFont(ui.font);
            setBorder(border);
        }

        //button part
        if(mode <2) {
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

        //mode 0 home
        if(mode == 0){
            Button buyBtn = new Button("구매하기");
            buyBtn.setBounds(660, 470, 150, 60);
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

        }
        //mode 1 admin home
        else if(mode == 1){
            Button buyBtn = new Button("구매하기");
            buyBtn.setBounds(660, 470, 150, 60);
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

            Button delete = new Button("삭제하기");
            delete.setBounds(500,470,150,60);
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
                        updatePanel(0);
                    }

                }
            });
        }

        else if(mode ==2){
            Button buyBtn = new Button("구매하기");
            buyBtn.setBounds(660, 470, 150, 60);
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
                }
            });

        }
/*
        else if(mode ==3){
            Button editBtn = new Button("수정하기");
            editBtn.setBounds(660, 470, 150, 60);
            editBtn.setFont(ui.font3);
            editBtn.setBackground(ui.s);
            editBtn.setHorizontalAlignment(0);
            editBtn.setForeground(Color.white);
            add(editBtn);
            editBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i =0; i<lineMy.lineArray.size(); i++){
                        String title = lineMy.lineArray.get(i).title.getText();
                        String isbn= lineMy.lineArray.get(i).isbn.getText();
                        String author= lineMy.lineArray.get(i).author.getText();
                        String publisher = lineMy.lineArray.get(i).publisher.getText();
                        String year = lineMy.lineArray.get(i).publishyear.getText();
                        String condition = lineMy.lineArray.get(i).condition.getSelectedItem().toString();
                        String owner = lineMy.lineArray.get(i).owner.getText();
                        Book book = new Book(title,isbn,author,publisher,year,condition,owner);
                        int index = bookList.bookArray.indexOf(lineMy.lineArray.get(i).book);
                        bookList.bookArray.set(index,book);

                    }
                    //updatePanel(mode);
                    //home.home.mode = 4;

                }
            });

            Button deleteBtn = new Button("삭제하기");
            deleteBtn.setBounds(480, 470, 150, 60);
            deleteBtn.setFont(ui.font3);
            deleteBtn.setBackground(ui.s);
            deleteBtn.setHorizontalAlignment(0);
            deleteBtn.setForeground(Color.white);
            add(deleteBtn);
            deleteBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int n = 0;
                    for (int i = 0; i < lineMy.lineArray.size(); i++) {
                        if (lineMy.lineArray.get(i).selected) {
                            bookList.bookArray.remove(lineMy.lineArray.get(i).book);
                            n++;
                        }
                    }
                    if (n == 0) {
                        JOptionPane.showMessageDialog(null, "Check Book");

                    }
                    else{

                        //home.home.mode = 4;
                        //updatePanel(0);


                    }
                }
            });
            add(deleteBtn);
            add(editBtn);


        }

*/

        //set booklist index
        if(mode ==4) {
            //유저관리
            LineGUI userIndex = new LineGUI("user");
            userIndex.setBounds(7, 30, 800, 50);
            userIndex.setBackground(ui.p);
            add(userIndex);

        }
        else{
            LineGUI bookIndex = new LineGUI();
            bookIndex.setBounds(7, 30, 800, 50);
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

        sc.setBounds(7, 80, 820, 380);
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
            }
        });


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
        sc.setBounds(7, 80, 820, 380);
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
        bookListArea(mode);

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
