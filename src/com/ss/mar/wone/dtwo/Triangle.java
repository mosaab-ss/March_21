package com.ss.mar.wone.dtwo;

/**
 * Calculates the area of a Triangle in 2 ways
 * @author Mosaab
 */
public class Triangle implements Shape {

    public double sideA = 0;
    public double sideB = 0;
    public double sideC = 0;
    public double area = 0;

    /**
     * Constructor for a right angle triangle or base/height
     * @param sideA
     * @param sideB
     */
    public Triangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
        calculateArea();
    }

    /**
     * Constructor for all 3 sides of a triangle
     * @param sideA
     * @param sideB
     * @param sideC
     */
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        calculateArea();
    }

    /**
     * Calculates the area of the Shape
     */
    @Override
    public void calculateArea() {
        if (sideC == 0) { // no sideC, therefore, right triangle
            this.area = this.sideA * this.sideB / 2;
        } else { // Heron's formula for area from all 3 sides
            double s = (this.sideA + this.sideB + this.sideC) / 2;
            this.area = Math.sqrt(s * (s - this.sideA) * (s - this.sideB) * (s - this.sideC));
        }
    }

    /**
     * Displays the calculated area of the Shape
     */
    @Override
    public void display() {
        System.out.println("The area of the Triangle is "+ this.area);
    }
}
