import java.util.ArrayList;

public class User {
    private final String id;
    private final String password;
    private final String username;
    private final String phone;
    private final String email;
    private final boolean isAdmin;
    private boolean isActivate;
    private boolean isOn = false;
   /* ArrayList<Book> userBookList = new ArrayList<Book>();
    public void addBookToUser(Book book){
        userBookList.add(book);
    }

    */
    public User(String Id, String Password, String Username, String Phone, String Email, boolean IsActivate, boolean IsAdmin){
        id = Id;
        password = Password;
        username = Username;
        phone = Phone;
        email = Email;
        isAdmin = IsAdmin;
        isActivate = IsActivate;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isActivate() {
        return isActivate;
    }

    public void changeActivate() {
        isActivate =!isActivate;
    }


    public boolean isOn() {
        return isOn;
    }

    public void setOn() {
        isOn = !isOn;
    }

    public void print(){
        System.out.println("id:"+id+" pw:"+password+" name:"+username+" phone:"+phone+" email:"+email+" isActive:"+isActivate+" isAdmin:"+isAdmin+" State:"+isOn+"\n");
    }

}
