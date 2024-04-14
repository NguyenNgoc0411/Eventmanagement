package com.example.myapplication.Object;

import java.util.ArrayList;

public class Event {
    private  String id,name,dateCreate,beginTime,endTime,description;
    private int status,capacity;
    private AddressOrganization address;
    private ArrayList<EventJob> eventjob;
    private ArrayList<Paticipant> paticipant;
    private Budget budget;
    private User user;
    public Event()
    {

    }

    public Event(String id, String name, String dateCreate, String beginTime, String endTime, String description, int status, int capacity, AddressOrganization address, ArrayList<EventJob> eventjob, ArrayList<Paticipant> paticipant, Budget budget, User user) {
        this.id = id;
        this.name = name;
        this.dateCreate = dateCreate;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.description = description;
        this.status = status;
        this.capacity = capacity;
        this.address = address;
        this.eventjob = eventjob;
        this.paticipant = paticipant;
        this.budget = budget;
        this.user = user;
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

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public AddressOrganization getAddress() {
        return address;
    }

    public void setAddress(AddressOrganization address) {
        this.address = address;
    }

    public ArrayList<EventJob> getEventjob() {
        return eventjob;
    }

    public void setEventjob(ArrayList<EventJob> eventjob) {
        this.eventjob = eventjob;
    }

    public ArrayList<Paticipant> getPaticipant() {
        return paticipant;
    }

    public void setPaticipant(ArrayList<Paticipant> paticipant) {
        this.paticipant = paticipant;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
