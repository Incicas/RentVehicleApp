package com.company;

import java.util.Date;

public class Sedan extends Vehicle{

    public Sedan(boolean isFilledUp, boolean isNotDamaged){
        super(isFilledUp, isNotDamaged);
    }

    public String toString() {
        return super.toString() + " Sedan : ";
    }
}
