package com.example.myapplication.Object;

public class ItemBudget {
    private  String id,name;
    private int expenesePaid,estimateCost;
    private  Supplier supplier;
    public  ItemBudget()
    {

    }

    public ItemBudget(String id, String name, int expenesePaid, int estimateCost, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.expenesePaid = expenesePaid;
        this.estimateCost = estimateCost;
        this.supplier = supplier;
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

    public int getExpenesePaid() {
        return expenesePaid;
    }

    public void setExpenesePaid(int expenesePaid) {
        this.expenesePaid = expenesePaid;
    }

    public int getEstimateCost() {
        return estimateCost;
    }

    public void setEstimateCost(int estimateCost) {
        this.estimateCost = estimateCost;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
