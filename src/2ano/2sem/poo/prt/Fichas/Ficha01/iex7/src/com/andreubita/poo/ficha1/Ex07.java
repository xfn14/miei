package com.andreubita.poo.ficha1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Ex07 {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // A hora de nascimento será sempre a meia noite do dia em questao
        System.out.print("Insira a sua data de nascimento (dd/MM/yyyy): ");
        String dateStr = scanner.nextLine();
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
            Date date2 = new Date(System.currentTimeMillis());
            if(date1.before(date2)){
                LocalDateTime ldt = LocalDateTime.now();
                Duration dif = Duration.between(date1.toInstant(), date2.toInstant());
                System.out.print("(" + ldt.format(dtf) + ") Nasceste à " + dif.toHours() + " horas");
            }else{
                System.out.print("Mentiroso `>_<´");
            }
        } catch (ParseException e) {
            System.out.print("Data invalida");
        }
    }
}
