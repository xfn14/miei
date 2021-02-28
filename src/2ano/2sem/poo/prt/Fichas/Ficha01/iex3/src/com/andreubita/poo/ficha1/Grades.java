package com.andreubita.poo.ficha1;

import java.util.ArrayList;
import java.util.Collections;

public class Grades {
    private ArrayList<Double> grades;

    public Grades(){
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade){
        this.grades.add(grade);
        Collections.sort(this.grades);
    }

    public String getInterval(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.grades.size()-1; i++) {
            if(i == this.grades.size()-2){
                stringBuilder.append("e [").append(this.grades.get(i)).append(",").append(this.grades.get(i + 1)).append("]");
            }else{
                stringBuilder.append("[").append(this.grades.get(i)).append(",").append(this.grades.get(i + 1)).append("[").append(i == this.grades.size() - 3 ? "" : ",").append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
