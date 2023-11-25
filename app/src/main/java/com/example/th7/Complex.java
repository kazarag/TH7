package com.example.th7;

import java.util.Scanner;

public class Complex implements add {
    private double real;
    private double imaginary;

    public Complex() {
        super();
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap Phan Thuc: ");
        this.real = scanner.nextInt();
        System.out.println("Nhap Phan Ao: ");
        this.imaginary = scanner.nextInt();
    }

    @Override
    public Object add(Object other) {
        Complex kq = new Complex();
        Complex sp = (Complex) other;
        kq.real = this.real + sp.real;
        kq.imaginary = this.imaginary + sp.imaginary;
        return kq;
    }

    public String toString() {
        return real + (imaginary < 0 ? "" : "+") + imaginary + "i";
    }
}