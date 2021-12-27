package com.company;

import java.util.Date;

public class Minivan extends Vehicle{

    public Minivan(boolean isFilledUp, boolean isNotDamaged){
        super(isFilledUp, isNotDamaged);
    }
    public String toString(){
        return super.toString() + " Minivan : ";
    }
}
