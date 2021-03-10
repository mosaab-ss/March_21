package com.ss.mar.wone.dtwo;

/**
 * Calculates the area of a circle
 * @author Mosaab
 */
public class Circle implements Shape {

    public double radius = 0;
    public double area = 0;

    /**
     * Constructor for the circle
     * @param radius
     */
    public Circle(double radius) {
        this.radius = radius;
        this.calculateArea();
    }

    /**
     * Calculates the area of the Shape
     */
    @Override
    public void calculateArea() {
        // area formula: radius ^ 2 * PI
        this.area = Math.pow(this.radius, 2) * Math.PI;
    }

    /**
     * Displays the calculated area of the Shape
     */
    @Override
    public void display() {
        System.out.println("The area of the Circle is "+ this.area);
    }
}
