public class Main {
    public static void main(String[] args) throws Exception{
        UserList userList = new UserList();
        BookList bookList = new BookList();
        String Book = "Book.txt";
        String User = "User.txt";
        new ReadFileToList(userList, bookList ,User,Book);
        SignInGUI gui = new SignInGUI(userList,bookList);
        //BookGUI book = new BookGUI(userList,bookList);
        //HomeGUI home = new HomeGUI(userList, bookList);


        for(int i=0; i<userList.numUser(); i++){
            userList.userArray.get(i).print();
        }
        for(int i=0; i<bookList.bookArray.size(); i++){
            bookList.bookArray.get(i).print();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                new SaveToFile(userList, bookList, User,Book);
                System.out.println("closed");
            }
        });

    }
}
