package com.example.ilithyia;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Message implements Serializable {
    private String key ;
    private String email;
    private String sendTo;
    private String msg;
    private boolean isPublished;
    private String answer;

    public Message(){

    }

    public Message(String email, String sendTo, String msg) {
        this.email = email;
        this.sendTo = sendTo;
        this.msg = msg;
        this.answer="";
        this.isPublished=false;
        this.key="";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean published) {
        isPublished = published;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Message{" +
                "email='" + email + '\'' +
                ", sendTo='" + sendTo + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }


}
