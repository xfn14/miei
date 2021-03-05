package com.andreubita.poo.ficha1;

import java.util.Scanner;

public class Ex03 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome");
        String nome = scanner.nextLine();
        System.out.println("Insira o saldo");
        double saldo = scanner.nextDouble();
        Ex03 ex03 = new Ex03();
        String msg = ex03.criaDescricaoConta(nome, saldo);
        System.out.println(msg);
        scanner.close();
    }

    public String criaDescricaoConta(String nome, double saldo){
        return "\n-------------------------------\n    O " + ANSI_CYAN + nome + ANSI_RESET + " tem " + ANSI_CYAN + saldo + ANSI_RESET +" na conta.\n-------------------------------";
    }
}
