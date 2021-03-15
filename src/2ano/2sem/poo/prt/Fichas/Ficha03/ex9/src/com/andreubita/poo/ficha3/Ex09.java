package com.andreubita.poo.ficha3;

public class Ex09 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(
                new Point<>(0.0,1.0),
                new Point<>(3.0,0.0),
                new Point<>(2.0,-1.0)
        );
        System.out.println(triangle.toString());
        System.out.println(triangle.calcArea());
        System.out.println(triangle.calcPerimeter());
    }
}
