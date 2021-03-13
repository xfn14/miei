package com.andreubita.poo.ficha1;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        Ex05 ex05 = new Ex05();
        while(!done){
            System.out.println("Insira o valor da base");
            double base = scanner.nextDouble();
            if(base != 0){
                System.out.println("Insira o valor da altura");
                double height = scanner.nextDouble();
                System.out.println("Um triângulo retângulo com base " + base + " e altura " + height + " tem:");
                System.out.printf("Area: %.5f; Perimetro: %.5f\n", ex05.calcArea(base, height), ex05.calcPerimeter(base, height));
            }else{
                done = true;
            }
        }
        scanner.close();
    }

    public double calcArea(double base, double height){
        return (base * height)/2;
    }

    public double calcPerimeter(double base, double height){
        return Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2)) + base + height;
    }
}
