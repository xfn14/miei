package com.andreubita.poo.ficha3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Lamp {
    private ArrayList<Tuple<Instant,State>> switches;

    public Lamp(){
        this.switches = new ArrayList<>(20);
    }

    public Lamp(State state){
        this.switches = new ArrayList<>(20);
        this.switches.add(new Tuple<>(Instant.now(), state));
    }

    public Lamp(ArrayList<Tuple<Instant, State>> switches){
        this.switches = switches;
    }

    public Lamp(Lamp newLamp){
        this.switches = newLamp.getSwitches();
    }

    public enum State{
        ON(3),
        ECO(1.5),
        OFF(0),
        RESET(-1);

        public final double rate;

        State(double rate){
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "State{" +
                    "rate=" + rate +
                    '}';
        }
    }

    public void lampON(){
        if(this.switches.get(this.switches.size()-1).y.equals(State.ON)) return;
        this.switches.add(new Tuple<>(Instant.now(), State.ON));
    }

    public void lampECO(){
        if(this.switches.get(this.switches.size()-1).y.equals(State.ECO)) return;
        this.switches.add(new Tuple<>(Instant.now(), State.ECO));
    }

    public void lampOFF(){
        if(this.switches.get(this.switches.size()-1).y.equals(State.OFF)) return;
        this.switches.add(new Tuple<>(Instant.now(), State.OFF));
    }

    /**
     * When the lamp is reset it's considered that has it's turned off
     */
    public void reset(){
        this.switches.add(new Tuple<>(Instant.now(), State.RESET));
    }

    public double totalExpenses(){
        double expense = 0;
        int i = 0;
        for (int j = 1; j < this.switches.size(); j++, i++)
            expense += calculateExpense(this.switches.get(i), this.switches.get(j));
        return expense;
    }

    public double lastExpense(){
        double expense = 0;
        int i = this.switches.size() - 1, j = i - 1;
        while(this.switches.get(j).y != State.RESET){
            expense += calculateExpense(this.switches.get(i), this.switches.get(j));
            i--; j--;
        }
        return expense;
    }

    private double calculateExpense(Tuple<Instant,State> fst, Tuple<Instant,State> snd){
        Duration dur = Duration.between(fst.x, snd.x);
        if(fst.y.rate == -1) return 0;
        return dur.toMillis() * fst.y.rate;
    }

    @Override
    public String toString() {
        return "Lamp{" +
                "switches=" + switches +
                '}';
    }

    public Lamp clone() {
        return new Lamp(this);
    }

    public ArrayList<Tuple<Instant, State>> getSwitches() {
        return this.switches;
    }

    public void setSwitches(ArrayList<Tuple<Instant, State>> switches) {
        this.switches = switches;
    }
}
