package com.andreubita.poo.ficha1;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        // TODO exercicio mal interpretado
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira notas. (quando acabar intruduza \"q\")");
        boolean done = false;
        Grades grades = new Grades();
        while(!done){
            String input = scanner.nextLine();
            if(!input.equals("q")){
                try{
                    double n = Integer.parseInt(input);
                    if(n < 0){
                        System.out.println("Numero Invalido");
                    }else{
                        grades.addGrade(n);
                    }
                }catch (NumberFormatException e){
                    System.out.println("Numero Invalido");
                }
            }else{
                done = true;
            }
        }
        System.out.println(grades.getInterval());
        scanner.close();
    }
}
