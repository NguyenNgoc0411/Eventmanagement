package com.example.myapplication.Object;

public class EventJob {
    private String id,name,deadline;
    private int status;

    public EventJob(String id, String name, String deadline, int status) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.status = status;
    }
    public EventJob()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
