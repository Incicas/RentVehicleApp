package com.company;

import java.util.LinkedList;
import java.util.List;

public class RentalCarService implements RentalInterface {

    private List<Vehicle> availableVehicles;
    private List<Order> processedOrders;
    private List<Customer> customers;


    public RentalCarService() {
        this.availableVehicles = new LinkedList<>();
        this.customers = new LinkedList<>();
        this.processedOrders = new LinkedList<>();
    }

    public void addVehicle(Vehicle newVehicle) {
        this.availableVehicles.add(newVehicle);
    }

    public void addCustomer(Customer newCustomer) throws CustomerExistException {
        boolean notFoundCustomer = false;
        for (Customer c : customers) {
            if (!c.equals(newCustomer)) {
                notFoundCustomer = true;
                this.customers.add(newCustomer);
            }
            if (!notFoundCustomer) {
                throw new CustomerExistException("This customer is already registered ! ");
            }
        }
    }

    public void addOrder(Order order) {
        this.processedOrders.add(order);
    }

    public void rent(Order order) throws VehicleNotExistException, EmptyVehiclesException {
        boolean foundVehicle = false;
        if (this.availableVehicles.isEmpty()) {
            throw new EmptyVehiclesException("The list of vehicles is empty.");
        }
        for (Vehicle v : availableVehicles) {
            if (order.getVehicle().equals(v)) {
                foundVehicle = true;
                if (!overlaps(order)) {
                    this.availableVehicles.remove(order.getVehicle());
                }
            }
        }
        if (!foundVehicle) {
            throw new VehicleNotExistException("You cannot rent this vehicle.");
        }
    }

    public void returnVehicle(Order order) throws VehicleNotExistException {
        for (Order o : processedOrders) {
            if (order.getVehicle().equals(o.getVehicle())) {
                calculateBill(o);
                this.availableVehicles.add(order.getVehicle());
            }
            if (!order.getVehicle().equals(o.getVehicle())) {
                throw new VehicleNotExistException("This vehicle does not appear as rented.");
            }
        }
    }

    public double calculateBill(Order order) {
        double bill = (order.getEndDate() - order.getStartDate()) * 10;
        double sumOfBills = 0;
        if (!order.getVehicle().isFilledUp() && !order.getVehicle().isNotDamaged()) {
            bill = bill + 250;
        }
        if (!order.getVehicle().isFilledUp()) {
            bill = bill + 100;
        }
        if (!order.getVehicle().isNotDamaged()) {
            bill = bill + 150;
        }

        return sumOfBills + bill;

    }

    private boolean overlaps(Order order) {
        for (Order o : processedOrders) {
            int currentStartDate = o.getStartDate();
            int currentEndDate = o.getEndDate();

            if (
                    (order.getStartDate() == currentStartDate) || (order.getEndDate() == currentEndDate)
                            || (order.getStartDate() > currentStartDate) && (order.getStartDate() < currentEndDate)
                            || (order.getEndDate() > currentStartDate) && (order.getEndDate() < currentEndDate)) {
                return true;
            }
        }
        return false;
    }

    public void listAllOrders() {
        for (Order o : processedOrders) {
            System.out.println(o);
        }
    }

    public String getProcessedOrders() {
        String orders = "";
        for (Order  o : processedOrders){
            orders = orders + o.getCustomer() + o.getVehicle();
        }
        return orders;
    }

    public String toString(){
        String r =" Rental Car Service : "+ this.getProcessedOrders().toString();
        return r;
    }

}