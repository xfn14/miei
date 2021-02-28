package com.andreubita.poo.ficha1;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        final String[] diasDaSemana =
                {
                        "Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira",
                        "Quinta-Feira", "Sexta-Feira", "Sabado"
                };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira uma data (dd/mm/yyyy)");
        String input = scanner.nextLine();
        String[] parser = input.split("/");
        int d, m, y;
        try{
            d = Integer.parseInt(parser[0]);
            m = Integer.parseInt(parser[1]);
            y = Integer.parseInt(parser[2]);

            Ex01 ex01 = new Ex01();
            System.out.println("Em " + input + " era " + diasDaSemana[ex01.calcDaysBefore(d, m, y)]);
        }catch (NumberFormatException e){
            System.out.println("Numero invalido.");
        }
    }

    public int calcDaysBefore(int day, int month, int year){
        int calc = (year - 1900) * 365 + ((year - 1900)/4);
        if(calc == year && (day == 1 || day == 2)) calc--;
        calc += calcDaysPassedYear(day, month);
        return calc % 7;
    }

    public int calcDaysPassedYear(int day, int month){
        month--;
        int days = 0;
        boolean swt = true;
        for (int i = 0; i < 12; i++) {
            if(i == month){
                days += day;
                break;
            }else if(month == 1){
                days += 28;
            }else{
                if(swt) days += 31;
                else days += 30;
            }
            swt = !swt;
        }
        return days;
    }
}
