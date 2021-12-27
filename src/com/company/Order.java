package com.company;

import java.time.LocalDate;
import java.util.Date;
import java.util.OptionalDouble;

public class Order {

    private Customer customer;
    private Vehicle vehicle;
    private int startDate;
    private int endDate;

    public Order(Customer customer, Vehicle vehicle, int startDate, int endDate){
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String toString(){
        return this.customer + " , Start date : "+this.startDate + " , End date : "+this.endDate;
    }
}
