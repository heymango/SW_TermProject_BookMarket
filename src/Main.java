public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        BookList bookList = new BookList();
        userList.addUser(new User("admin","nayana","Sojeong","010-9312-2709","heymango7393@gmail.com",true));
        userList.userArray.get(0).print();
        SignInGUI gui = new SignInGUI(userList,bookList);
    }
}
