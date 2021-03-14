package com.andreubita.poo.ficha3;

import java.util.Objects;

public class Game {
    private State state;
    private String team1;
    private String team2;
    private int goals1;
    private int goals2;

    public Game(){
        this.state = State.IDLE;
        this.team1 = "FC Porto";
        this.team2 = "SC Braga";
        this.goals1 = 0;
        this.goals2 = 0;
    }

    public Game(State state, String team1, String team2, int goals1, int goals2) {
        this.state = state;
        this.team1 = team1;
        this.team2 = team2;
        this.goals1 = goals1;
        this.goals2 = goals2;
    }

    public Game(Game game){
        this.state = game.getState();
        this.team1 = game.getTeam1();
        this.team2 = game.getTeam2();
        this.goals1 = game.getGoals1();
        this.goals2 = game.getGoals2();
    }

    public void startGame(){
        this.state = State.RUNNING;
    }

    public void endGame(){
        this.state = State.DONE;
    }

    public void goalTeam1(){
        this.goals1++;
    }

    public void goalTeam2(){
        this.goals2++;
    }

    public String currentScore(){
        return "(" + getGoals1() + ":" + getGoals2() + ")";
    }

    public enum State{
        IDLE,
        RUNNING,
        DONE
    }

    public State getState() {
        if(state.equals(State.DONE)) return null;
        return this.state;
    }

    public void setState(State state) {
        if(state.equals(State.DONE)) return;
        this.state = state;
    }

    public String getTeam1() {
        if(state.equals(State.DONE)) return null;
        return team1;
    }

    public void setTeam1(String team1) {
        if(state.equals(State.DONE)) return;
        this.team1 = team1;
    }

    public String getTeam2() {
        if(state.equals(State.DONE)) return null;
        return team2;
    }

    public void setTeam2(String team2) {
        if(state.equals(State.DONE)) return;
        this.team2 = team2;
    }

    public int getGoals1() {
        return goals1;
    }

    public void setGoals1(int goals1) {
        if(state.equals(State.DONE)) return;
        this.goals1 = goals1;
    }

    public int getGoals2() {
        return goals2;
    }

    public void setGoals2(int goals2) {
        if(state.equals(State.DONE)) return;
        this.goals2 = goals2;
    }

    @Override
    public String toString() {
        return "Game{" +
                "state=" + state +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", goals1=" + goals1 +
                ", goals2=" + goals2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return goals1 == game.goals1 &&
                goals2 == game.goals2 &&
                state == game.state &&
                Objects.equals(team1, game.team1) &&
                Objects.equals(team2, game.team2);
    }

    @Override
    public Game clone(){
        return new Game(this);
    }
}
