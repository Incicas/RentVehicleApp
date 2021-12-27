package com.company;

public class VehicleNotExistException extends  Exception{

    public VehicleNotExistException(String msg){
        super(msg);
    }
}
