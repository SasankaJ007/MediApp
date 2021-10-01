package com.example.delivery;

public class DeliveryModel {

    String name, address, mobile, email, iurl;

    DeliveryModel()
    {

    }

    public DeliveryModel(String name, String address, String mobile, String email, String iurl) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.iurl = iurl;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIurl() { return iurl; }
    
    public void setIurl(String iurl) { this.iurl = iurl; }
    
    
}
