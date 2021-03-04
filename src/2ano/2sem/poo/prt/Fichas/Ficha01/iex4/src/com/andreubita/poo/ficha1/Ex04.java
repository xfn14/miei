package com.andreubita.poo.ficha1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex04 {
    // TODO Redo with just 4 vars
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
        Ex04 ex04 = new Ex04();
        Tuple<Integer,Integer> biggestVarTuple = ex04.getBiggestVar(temps);
        double biggestVar = temps.get(biggestVarTuple.y) - temps.get(biggestVarTuple.x);
        if(biggestVar == 0){
            System.out.println("A temperatura manteve-se sempre igual");
        }else{
            System.out.println("A maior variação registou-se entre os dias " + (biggestVarTuple.x + 1) + " e " + (biggestVarTuple.y + 1)
                    + ", tendo a temperatura " + (biggestVar > 0 ? "subido ": "descido ") + Math.abs(biggestVar) + " graus");
        }
    }

    public Tuple<Integer,Integer> getBiggestVar(ArrayList<Double> temps){
        int d1 = 0, d2 = 1, b1 = 0, b2 = 0;
        for(; d2 < temps.size(); d2++, d1++){
            double temp1 = temps.get(d1), temp2 = temps.get(d2);
            if(Math.abs(temp1 - temp2) > Math.abs(temps.get(b1) - temps.get(b2))){
                b1 = d1; b2 = d2;
            }
        }
        return new Tuple<>(b1, b2);
    }
}
