package com.andreubita.poo;

public class Ex06 {

    public static void main(String[] args) {
        Ex06 ex06 = new Ex06();
        try{
            int n = Integer.parseInt(args[0]);
            long fact = ex06.factorial(n);
            System.out.println("O factorial de " + n + " é " + fact);
        }catch (NumberFormatException e){
            System.out.println("Numero invalido");
        }
    }

    public long factorial(int n){
        int i,fact=1;
        for(i=1; i <= n; i++){
            fact *= i;
        }
        return fact;
    }
}
