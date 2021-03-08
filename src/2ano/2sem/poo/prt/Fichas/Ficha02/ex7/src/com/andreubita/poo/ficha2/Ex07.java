package com.andreubita.poo.ficha2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ex07 {
    public static void main(String[] args) {
        Ex07 ex07 = new Ex07();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> gameKey = new ArrayList<>();
        ArrayList<Integer> userKey = new ArrayList<>();

        // Numbers (0-4)
        gameKey.add(ex07.getRandom(1,50));
        gameKey.add(ex07.getRandom(1,50));
        gameKey.add(ex07.getRandom(1,50));
        gameKey.add(ex07.getRandom(1,50));
        gameKey.add(ex07.getRandom(1,50));
        // Stars (5-6)
        gameKey.add(ex07.getRandom(1,9));
        gameKey.add(ex07.getRandom(1,9));

        System.out.println(gameKey.toString());

        System.out.println("Insert 5 numbers [1-50]:");
        for(int i = 0; i < 7; i++){
            if(i == 5) System.out.println("Insert 2 stars [1-9]: ");
            int input = scanner.nextInt();
            if(i < 5){
                if(1 <= input && input <= 50){
                    userKey.add(input);
                }else{
                    System.out.println("Número inválido. [1-50]");
                    i--;
                }
            }else{
                if(1 <= input && input <= 9){
                    userKey.add(input);
                }else{
                    System.out.println("Estrela inválido. [1-9]");
                    i--;
                }
            }
        }

        System.out.print("WINNING KEY: " + gameKey.toString() + "\n\nMATCHING NUMBERS:\n");

        ArrayList<Integer> matchKey = ex07.getKeyMatch(gameKey, userKey);
        if(matchKey.size() == 7){
            int offset = 0;
            for (int i = 0; i < 50; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  ".repeat(Math.max(0, offset)));
                stringBuilder.append(matchKey.toString());
                System.out.print(stringBuilder.toString() + "\n");
                offset++;
            }
        }else{
            System.out.print(matchKey.toString());
        }
        scanner.close();
    }

    public ArrayList<Integer> getKeyMatch(ArrayList<Integer> gameKey, ArrayList<Integer> userKey){
        ArrayList<Integer> match = new ArrayList<>();
        for(int n : userKey){
            if(gameKey.contains(n)){
                match.add(n);
            }
        }
        return match;
    }

    public int getRandom(int min, int max){
//        Random random = new Random();
//        return random.nextInt((max - min) + 1) + min;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
