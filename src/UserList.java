import java.util.ArrayList;

public class UserList {
    ArrayList<User> userArray = new ArrayList<User>();


    public int numUser() {
        return userArray.size();
    }

    public void deleteUser(int i) {
        userArray.remove(i);
    }

    public void addUser(User user) {
        this.userArray.add(user);
    }

    public boolean isUserThere(String userid) {
        for (User user : userArray) {
            if (user.getId().equals(userid)) {
                return true;
            }
        }
        return false;
    }

    public String userPwd(String username) {
        String pwd = null;
        for (User user : userArray) {
            if (user.getId().equals(username)) {
                pwd =user.getPassword();
            }
        }
        return pwd;
    }

}