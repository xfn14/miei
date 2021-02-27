package com.andreubita.poo.ficha1;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira dois numeros");
        int a = scanner.nextInt(), b = scanner.nextInt();
        Ex02 ex02 = new Ex02();
        int max = ex02.maximoNumeros(a, b);
        System.out.println("Entre " + a + " e " + b + " o maior é o " + max);
    }

    public int maximoNumeros(int a, int b){
        // return Math.max(a, b);
        return a > b ? a : b;
    }
}
