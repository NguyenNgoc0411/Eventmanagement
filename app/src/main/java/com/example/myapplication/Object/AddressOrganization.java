package com.example.myapplication.Object;

public class AddressOrganization {
    private String id,name,address;
    private int status,price;
    public  AddressOrganization()
    {

    }

    public AddressOrganization(String id, String name, String address, int status, int price) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.price = price;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
