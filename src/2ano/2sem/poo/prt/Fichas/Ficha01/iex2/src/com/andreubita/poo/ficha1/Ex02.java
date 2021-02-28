package com.andreubita.poo.ficha1;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira duas datas (d:h:m:s)");
        String date1 = scanner.nextLine(), date2 = scanner.nextLine();
        String[] date1Parsed = date1.split(":"), date2Parsed = date2.split(":");

        try{
            Date date1Obj = new Date(
                    Integer.parseInt(date1Parsed[0]),
                    Integer.parseInt(date1Parsed[1]),
                    Integer.parseInt(date1Parsed[2]),
                    Integer.parseInt(date1Parsed[3])
            );
            Date date2Obj = new Date(
                    Integer.parseInt(date2Parsed[0]),
                    Integer.parseInt(date2Parsed[1]),
                    Integer.parseInt(date2Parsed[2]),
                    Integer.parseInt(date2Parsed[3])
            );
            date1Obj.sumDate(date2Obj);
            date1Obj.printDate();
        }catch (NumberFormatException e){
            System.out.println("Numero invalido");
        }
    }
}
