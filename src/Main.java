public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        BookList bookList = new BookList();

        String Book = "C:\\Users\\Sojeong\\IdeaProjects\\SW_TermProject\\Book.csv";
        String User = "C:\\Users\\Sojeong\\IdeaProjects\\SW_TermProject\\User.csv";
        new ReadFileToList(userList, bookList ,User,Book);
        SignInGUI gui = new SignInGUI(userList,bookList);
        for(int i=0; i<userList.numUser(); i++){
            userList.userArray.get(i).print();
        }
        for(int i=0; i<bookList.bookArray.size(); i++){
            bookList.bookArray.get(i).print();
        }


    }
}
