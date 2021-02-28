package com.andreubita.poo.ficha1;

public class Date {
    private int day;
    private int hour;
    private int minute;
    private int second;

    public Date(int day, int hour, int minute, int second){
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void printDate(){
        System.out.println(this.day + "D " + this.hour + "H " + this.minute + "M " + this.second + "S");
    }

    public void sumDate(Date sum){
        if(this.second + sum.getSecond() >= 60){
            this.second += sum.getSecond() - 60;
            if(this.minute == 23){
                this.minute = 0;
                this.hour++;
            }else{
                this.minute++;
            }
        }else{
            this.second += sum.getSecond();
        }

        if(this.minute + sum.getMinute() >= 60){
            this.minute += sum.getMinute() - 60;
            if(this.hour == 23){
                this.hour = 0;
                this.day++;
            }else{
                this.hour++;
            }
        }else{
            this.minute += sum.getMinute();
        }

        if(this.hour + sum.getHour() >= 24){
            this.hour += sum.getHour() - 24;
            this.day++;
        }else{
            this.hour += sum.getHour();
        }

        this.day += sum.getDay();
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}
