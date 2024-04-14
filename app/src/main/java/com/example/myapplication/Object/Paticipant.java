package com.example.myapplication.Object;

public class Paticipant {
    private String id,dateReply;
    private int status;
    private FeedBack feedback;
    private User user;

    public Paticipant(String id, String dateReply, int status, FeedBack feedback, User user) {
        this.id = id;
        this.dateReply = dateReply;
        this.status = status;
        this.feedback = feedback;
        this.user = user;
    }
    public Paticipant()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateReply() {
        return dateReply;
    }

    public void setDateReply(String dateReply) {
        this.dateReply = dateReply;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public FeedBack getFeedback() {
        return feedback;
    }

    public void setFeedback(FeedBack feedback) {
        this.feedback = feedback;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
