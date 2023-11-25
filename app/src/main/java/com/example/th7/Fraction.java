package com.example.th7;



import java.util.Scanner;

public class Fraction implements add {
    private double numerator;
    private double denominator;

    public Fraction() {
        super();
    }

    public Fraction(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

//    void nhap() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhap Tu so: ");
//        this.numerator = scanner.nextInt();
//        System.out.print("Mau so: ");
//        this.denominator = scanner.nextInt();
//
//    }

    public double getNumerator() {
        return numerator;
    }

    public double getDenominator() {
        return denominator;
    }

    public Fraction multiply(Fraction other) {
        double newNumerator = this.numerator * other.numerator;
        double newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public Object add(Object other) {
        Fraction kq = new Fraction();
        Fraction Fr = (Fraction) other;
        kq.numerator = (this.numerator * Fr.denominator) + (Fr.numerator * this.denominator);
        kq.denominator = this.denominator * Fr.denominator;
        return kq;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
