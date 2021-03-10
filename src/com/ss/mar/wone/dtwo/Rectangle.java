package com.ss.mar.wone.dtwo;

/**
 * Calculates the area of a rectangle
 * @author Mosaab
 */
public class Rectangle implements Shape {

    public double width = 0;
    public double height = 0;
    public double area = 0;

    /**
     * Constructor for the rectangle
     * @param width
     * @param height
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.calculateArea();
    }

    /**
     * Calculates the area of the Shape
     */
    @Override
    public void calculateArea() {
        // area formula: width * height
        this.area = this.width * this.height;
    }

    /**
     * Displays the calculated area of the Shape
     */
    @Override
    public void display() {
        System.out.println("The area of the Rectangle is "+ this.area);
    }
}
