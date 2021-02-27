package com.andreubita.poo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex07 {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm.ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Ex07 ex07 = new Ex07();
        long execTime = ex07.tempoGasto();
        System.out.println("O programa demorou " + execTime + "ms");
    }

    public long tempoGasto(){
        LocalDateTime antes = LocalDateTime.now();
        System.out.println(antes.format(dtf));

        long res = factorial(5000);
        System.out.println("Fatorial de 5000: " + res);

        LocalDateTime apos = LocalDateTime.now();
        System.out.println(apos.format(dtf));

        return (apos.getNano() - antes.getNano())/1000;
    }

    public long factorial(int n){
        int i,fact=1;
        for(i=1; i <= n; i++){
            fact *= i;
        }
        return fact;
    }
}
