package com.example.myapplication.Object;

public class Supplier {
    private String id,name,address,description,hotline;
    public  Supplier()
    {

    }

    public Supplier(String id, String name, String address, String description, String hotline) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.hotline = hotline;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }
}
