package com.example.ilithyia;

public class User {
    private String email;
    private String password;
    private boolean isPro;

    public User()
    {

    }
    public User(String email,String password, boolean isPro)
    {
        email=email;
        password=password;
        isPro=isPro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPro() {
        return isPro;
    }

    public void setPro(boolean pro) {
        isPro = pro;
    }
}
