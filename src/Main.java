public class Main {
    public static void main(String[] args) throws Exception{
        UserList userList = new UserList();
        BookList bookList = new BookList();
        String Book = "Book.csv";
        String User = "User.csv";
        new ReadFileToList(userList, bookList ,User,Book);
        SignInGUI gui = new SignInGUI(userList,bookList);



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
