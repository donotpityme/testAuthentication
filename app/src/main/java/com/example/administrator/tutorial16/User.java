package com.example.administrator.tutorial16;

public class User {
    public String ho;
    public String ten;
    public String email;
    public String pass;

    public User() {
    }

    public User(String ho, String ten, String email, String pass) {
        this.ho = ho;
        this.ten = ten;
        this.email = email;
        this.pass = pass;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
