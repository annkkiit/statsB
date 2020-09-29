package com.ankit.myapplication.POJO;

public class Article {

    private String title;
    private String content;
    private int img;

    public Article(String title, String content, int img) {
        this.title = title;
        this.content = content;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getImg() {
        return img;
    }

}
