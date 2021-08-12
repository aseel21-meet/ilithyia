package com.example.ilithyia;

public class User {
    private String email;
    private String password;
    private boolean isPro;
    private int score;

    public User()
    {

    }
    public User(String email,String password, boolean isPro)
    {
        email=email;
        password=password;
        isPro=isPro;
        score=0;
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

    public boolean getIsPro() {
        return isPro;
    }

    public void setIsPro(boolean pro) {
        isPro = pro;
    }

   public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
