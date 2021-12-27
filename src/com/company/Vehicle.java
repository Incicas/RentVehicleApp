package com.company;

import java.sql.Timestamp;
import java.util.Date;

public abstract class Vehicle {
    private boolean isFilledUp;
    private boolean isNotDamaged;

    public Vehicle(boolean isFilledUp, boolean isNotDamaged){
        this.isFilledUp = isFilledUp;
        this.isNotDamaged = isNotDamaged;
    }

    public boolean isFilledUp() {
        return isFilledUp;
    }

    public void setFilledUp(boolean filledUp) {
        isFilledUp = filledUp;
    }

    public boolean isNotDamaged() {
        return isNotDamaged;
    }

    public void setNotDamaged(boolean notDamaged) {
        isNotDamaged = notDamaged;
    }

    public String toString(){
        return " Vehicle : " + this.isNotDamaged +" , "+ this.isFilledUp;
    }
}
