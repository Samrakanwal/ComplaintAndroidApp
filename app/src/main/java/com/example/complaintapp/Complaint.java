package com.example.complaintapp;

public class Complaint {
    private String id;
    private String name;
    private Integer contact;
    private String address;

    public Complaint(String name) {
        this.name = name;
    }

    public void Complaintcontact(Integer contact) {
        this.contact = contact;
    }

    public void Complaintaddress(String address) {
        this.address = address;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getContact() {
        return contact;
    }
}
