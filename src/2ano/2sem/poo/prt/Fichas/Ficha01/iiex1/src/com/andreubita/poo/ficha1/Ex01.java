package com.andreubita.poo.ficha1;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira os graus celsius");
        double graus = scanner.nextDouble();
        Ex01 ex01 = new Ex01();
        double res = ex01.celsiusParaFarenheit(graus);
        System.out.println(graus + "ºC corresponde a " + res + "ºF");
    }

    public double celsiusParaFarenheit(double graus){
        return (graus * 9/5) + 32;
    }
}
