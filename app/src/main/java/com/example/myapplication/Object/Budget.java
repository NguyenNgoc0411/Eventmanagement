package com.example.myapplication.Object;

import java.util.ArrayList;

public class Budget {
    private String id,dateCreate;
    private int expectBudget;
    private ArrayList<ItemBudget> itembudget;

    public Budget(String id, String dateCreate, int expectBudget, ArrayList<ItemBudget> itembudget) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.expectBudget = expectBudget;
        this.itembudget = itembudget;
    }
    public Budget()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getExpectBudget() {
        return expectBudget;
    }

    public void setExpectBudget(int expectBudget) {
        this.expectBudget = expectBudget;
    }

    public ArrayList<ItemBudget> getItembudget() {
        return itembudget;
    }

    public void setItembudget(ArrayList<ItemBudget> itembudget) {
        this.itembudget = itembudget;
    }
}
