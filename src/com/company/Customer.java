package com.company;

public class Customer {

    private String first_name;
    private String last_name;
    private String phoneNumber;

    public Customer(String first_name, String last_name, String phoneNumber) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phoneNumber = phoneNumber;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String name) {
        this.first_name = name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }
    public String getLast_name(){
        return this.last_name;
    }


    public boolean equals(Object o){
        if (o instanceof Customer){
            Customer c = (Customer) o;
            return this.first_name.equals(c.first_name) && this.last_name.equals(c.last_name) && this.phoneNumber.equals(c.phoneNumber);
        }
        return false;
    }

    public String toString(){
        return "Customer : "+this.first_name + " , "+ this.last_name + " , "+this.phoneNumber;
    }
}
