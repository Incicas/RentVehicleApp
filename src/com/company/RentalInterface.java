package com.company;

public interface RentalInterface {

    void rent(Order order) throws VehicleNotExistException, EmptyVehiclesException;
}
