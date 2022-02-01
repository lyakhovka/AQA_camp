package models;

public class User {

    private Object email;
    private Object password;

    public String getEmail(){
        return this.email.toString();
    }

    public String getPassword(){
        return this.password.toString();
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public User (Object email, Object password){
        this.email = email;
        this.password = password;
    }
}
