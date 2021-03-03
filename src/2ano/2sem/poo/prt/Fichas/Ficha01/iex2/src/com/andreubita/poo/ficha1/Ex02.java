package com.andreubita.poo.ficha1;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira duas datas (d:h:m:s)");
        String date1 = scanner.nextLine(), date2 = scanner.nextLine();
        String[] date1Parsed = date1.split(":"), date2Parsed = date2.split(":");

        try{
            int dia1 = Integer.parseInt(date1Parsed[0]),
                hora1 = Integer.parseInt(date1Parsed[1]),
                minuto1 = Integer.parseInt(date1Parsed[2]),
                segundo1 = Integer.parseInt(date1Parsed[3]);
            int dia2 = Integer.parseInt(date2Parsed[0]),
                hora2 = Integer.parseInt(date2Parsed[1]),
                minuto2 = Integer.parseInt(date2Parsed[2]),
                segundo2 = Integer.parseInt(date2Parsed[3]);
            if((0 <= hora1 && hora1 <= 24) && (0 <= minuto1 && minuto1 <= 60) && (0 <= segundo1 && segundo1 <= 60)
            && (0 <= hora2 && hora2 <= 24) && (0 <= minuto2 && minuto2 <= 60) && (0 <= segundo2 && segundo2 <= 60)){
                Date date1Obj = new Date(dia1, hora1, minuto1, segundo1);
                Date date2Obj = new Date(dia2, hora2, minuto2, segundo2);
                date1Obj.sumDate(date2Obj);
                date1Obj.printDate();
            }else{
                System.out.println("Data invalida");
            }
        }catch (NumberFormatException e){
            System.out.println("Numero invalido");
        }
    }
}
