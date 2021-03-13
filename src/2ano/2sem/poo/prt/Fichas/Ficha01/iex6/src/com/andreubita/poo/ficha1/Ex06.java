package com.andreubita.poo.ficha1;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex06 ex06 = new Ex06();
        boolean quit = false;
        while(!quit){
            System.out.println("Insira o numero (-1 para sair):");
            int n = scanner.nextInt();
            if(n != -1){
                if(n <= 1) System.out.println("Nao existem numeros primos inferiores a " + n);
                else{
                    System.out.println("Os numeros primos inferiores a " + n + " sao:");
                    StringBuilder sb = new StringBuilder();
                    for(int i = 2; i < n; i++){
                        if(ex06.isPrime(i))
                            sb.append(i).append(", ");
                    }
                    sb.setLength(sb.length() - 2);
                    System.out.print(sb.toString() + "\n");
                }
            }else{
                quit = true;
            }
        }
        scanner.close();
    }

    public boolean isPrime(int n){
        if(n <= 1) return false;

        for(int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
