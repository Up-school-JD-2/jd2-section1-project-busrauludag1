package src.main.java.org.busra;

import java.util.ArrayList;

public class UserManager{
    private final ArrayList<User> users;

    public UserManager(){
        users = new ArrayList<>();
    }

    public UserManager addUser(User user){
        users.add(user);
        return this;
    }

    public UserManager addUser(String name, String password, String eMail){
        return addUser(new User(name, password, eMail));
    }

    public UserManager deleteUser(User user){
        users.remove(user);
        return this;
    }

    public void deleteUser(String name, String password, String eMail){
        users.removeIf(user -> user.getName().equalsIgnoreCase(name)
                && user.getPassword().equals(password)
                && user.getEmail().equals(eMail));
    }

    public User searchUserById(String id){
        User searchedUser = null;
        for (User user : users){
            if (user.getId().equals(id)){
                searchedUser = user;
                break;
            }
        }
        return searchedUser;
    }

    public User searchUserByName(String userName){
        User searchedUser = null;
        for (User user : users)
            if (user.getName().equalsIgnoreCase(userName)){
                searchedUser = user;
            }
        return searchedUser;
    }

    public void printUserByName(String userName){
        for (User user : users)
            if (user.getName().equalsIgnoreCase(userName)){
                System.out.println(user);
            }
    }
    public User searchUserByPassword(String password){
        User searchedUser = null;
        for (User user : users) {
            if (user.getPassword().equalsIgnoreCase(password)) {
                searchedUser = user;
                break;
            }
        }
        return searchedUser;
    }

    public User searchUserByEmail(String eMail){
        User searchedUser = null;
        for (User user : users) {
            if (user.getEmail().equals(eMail)) {
                searchedUser = user;
                break;
            }
        }
        return searchedUser;
    }

    public void listUsers(){
        for (User user : users){
            System.out.println(user.toString());
        }
    }

}
