package com.example.myapplication.Object;

public class FeedBack {
    private String id, content,date;

    public FeedBack(String id, String content, String date) {

        this.id = id;
        this.content = content;
        this.date = date;
    }
    public FeedBack()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
