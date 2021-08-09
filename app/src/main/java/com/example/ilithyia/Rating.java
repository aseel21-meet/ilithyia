package com.example.ilithyia;

import com.google.firebase.database.IgnoreExtraProperties;

public class Rating {
    private String title;
    private int score;

    public Rating()
    {

    }
    public Rating (String title,int  score)
    {
        this.title=title;
        this.score=score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "title='" + title + '\'' +
                ", score=" + score +
                '}';
    }
}
