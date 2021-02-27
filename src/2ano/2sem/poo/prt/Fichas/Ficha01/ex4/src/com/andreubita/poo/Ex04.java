package com.andreubita.poo;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Ex04 ex04 = new Ex04();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira um valor em euros.");
        double val = scanner.nextDouble(), tax;
        System.out.println("Insira a taxa de conversao para libras.");
        tax = scanner.nextDouble();
        ex04.eurosParaLibras(val, tax);
    }

    public double eurosParaLibras(double valor, double taxaConversao){
        return valor*taxaConversao;
    }
}
