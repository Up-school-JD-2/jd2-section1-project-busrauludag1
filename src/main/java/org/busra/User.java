package src.main.java.org.busra;

import java.util.UUID;

public class User {
    private final String id;

    private String name;

    private String password;

    private String eMail;

    public User(String name, String password, String eMail) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
        this.eMail = eMail;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return eMail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString(){
        return "User {" +
                "ID: " + id + ", " +
                "Username: " + name + ", " +
                "Password: " + password + ", " +
                "e-mail: " + eMail +
                "}" + "\n";
    }

}
