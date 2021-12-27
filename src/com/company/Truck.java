package com.company;

import java.util.Date;

public class Truck extends Vehicle{

    public Truck(boolean isFilledUp, boolean isNotDamaged){
        super(isFilledUp, isNotDamaged);
    }

    public String toString(){
        return super.toString() + " Truck : ";
    }
}
