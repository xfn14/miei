package com.andreubita.poo.ficha2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

public class Ex03 {

    private LocalDate[] datasArr = new LocalDate[0];

    public static void main(String[] args) {
        Ex03 ex03 = new Ex03();
        LocalDate date = LocalDate.now();
        ex03.insertDate(date);
        System.out.print(ex03.toString());
    }

    public void insertDate(LocalDate data){
        LocalDate[] newArr = Arrays.copyOf(this.datasArr, this.datasArr.length + 1);
        newArr[newArr.length-1] = data;
        this.datasArr = newArr;
    }

    public LocalDate nearestDate(LocalDate data){
        LocalDate closest = null;
        Duration duration = null;
        for (LocalDate localDate : this.datasArr) {
            Duration crtDuration = Duration.between(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant(), data.atStartOfDay(ZoneId.systemDefault()).toInstant());
            if (duration == null) {
                duration = crtDuration;
                closest = localDate;
            } else {
                if (Math.abs(crtDuration.toNanos()) < Math.abs(duration.toNanos())) {
                    duration = crtDuration;
                    closest = localDate;
                }
            }
        }
        return closest;
    }

    @Override
    public String toString() {
        return Arrays.toString(datasArr);
    }
}
