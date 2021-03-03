package com.andreubita.poo.ficha1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("De quantas temperaturas pertende obter as médias?");
        int n = scanner.nextInt();
        System.out.println("Insira as temperaturas (ENTER):");
        ArrayList<Double> temps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            try{
                temps.add(scanner.nextDouble());
            }catch (NumberFormatException e){
                System.out.println("Temperatura invalida");
                i--;
            }
        }

        System.out.println("A média das " + n + " temperaturas foi de " + (temps.stream().mapToDouble(a -> a).sum() / n) + " graus");
    }
}
