package com.example.th7;

// RealNumber.java
public class RealNumber implements add{
    private double value;
    public RealNumber(){super();}
    public RealNumber(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Object add(Object other) {
        RealNumber kq = new RealNumber();
        RealNumber r = (RealNumber) other;
        kq.value = this.value+ r.value;

        return kq;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
