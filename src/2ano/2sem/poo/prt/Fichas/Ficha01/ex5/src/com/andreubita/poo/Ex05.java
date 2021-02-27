package com.andreubita.poo;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira um inteiro.");
        int x = scanner.nextInt(), y;
        System.out.println("Insira outro inteiro.");
        y = scanner.nextInt();

        System.out.println(x > y ? y + " " + x : y + " " + x );
        System.out.println("" + (x+y)/2);

        scanner.close();
    }
}
