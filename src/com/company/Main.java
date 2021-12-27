package com.company;



public class Main {

    public static void main(String[] args) throws CustomerExistException, VehicleNotExistException, EmptyVehiclesException {

        Customer c1 = new Customer("Beniamin", " Incicas", "0767625580");
        Vehicle v1 = new Sedan(true, false);


        RentalCarService rentalCarService = new RentalCarService();
        rentalCarService.addCustomer(c1);
        rentalCarService.addVehicle(v1);


        Order order = new Order(c1, v1, 15, 17);

        rentalCarService.addOrder(order);
        rentalCarService.rent(order);
        rentalCarService.returnVehicle(order);
        rentalCarService.listAllOrders();
        System.out.println(rentalCarService);


    }
}
