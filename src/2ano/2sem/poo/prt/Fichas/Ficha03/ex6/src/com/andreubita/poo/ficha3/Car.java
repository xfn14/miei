package com.andreubita.poo.ficha3;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int yearManufacture;
    private double consumptionRate;
    private double kmsDone;
    private double meanConsumption;
    private double kmsLastRide;
    private double meanConsumptionLastRide;
    private double regenCap;
    private boolean on;

    public Car(){
        this.brand = "Tesla";
        this.model = "S";
        this.yearManufacture = 2012;
        this.consumptionRate = 2.512;
        this.kmsDone = 0;
        this.meanConsumption = 0;
        this.kmsLastRide = 0;
        this.meanConsumptionLastRide = 0;
        this.regenCap = 0.5;
        this.on = false;
    }

    public Car(String brand, String model, int yearManufacture, double consumptionRate,
               double kmsDone, double meanConsumption, double kmsLastRide,
               double meanConsumptionLastRide, double regenCap, boolean on) {
        this.brand = brand;
        this.model = model;
        this.yearManufacture = yearManufacture;
        this.consumptionRate = consumptionRate;
        this.kmsDone = kmsDone;
        this.meanConsumption = meanConsumption;
        this.kmsLastRide = kmsLastRide;
        this.meanConsumptionLastRide = meanConsumptionLastRide;
        this.regenCap = regenCap;
        this.on = on;
    }

    public Car(Car car){
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.yearManufacture = car.getYearManufacture();
        this.consumptionRate = car.getConsumptionRate();
        this.kmsDone = car.getKmsDone();
        this.meanConsumption = car.getMeanConsumption();
        this.kmsLastRide = car.getKmsLastRide();
        this.meanConsumptionLastRide = car.getMeanConsumptionLastRide();
        this.regenCap = car.getRegenCap();
        this.on = car.isOn();
    }

    public void turnOn(){
        resetUltimaViagem();
        setOn(true);
    }

    public void turnOff(){
        setOn(false);
    }

    public void resetUltimaViagem(){
        this.kmsLastRide = 0;
        this.meanConsumptionLastRide = 0;
    }

    public void move(double dis, double vel){
        if(!isOn()) return;
        this.kmsDone += dis;
        this.meanConsumption += calcConsumptionVel(dis, vel);
        this.kmsLastRide += dis;
        this.meanConsumptionLastRide += calcConsumptionVel(dis, vel);
    }

    public void brake(double dis){
        if(!isOn()) return;
        this.meanConsumption -= this.regenCap * dis;
        this.meanConsumptionLastRide -= this.regenCap * dis;
    }

    public double calcConsumptionVel(double dis, double vel){
        return ((this.consumptionRate * vel) / 100 ) * dis;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearManufacture() {
        return this.yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public double getConsumptionRate() {
        return this.consumptionRate;
    }

    public void setConsumptionRate(double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public double getKmsDone() {
        return this.kmsDone;
    }

    public void setKmsDone(double kmsDone) {
        this.kmsDone = kmsDone;
    }

    public double getMeanConsumption() {
        return this.meanConsumption;
    }

    public void setMeanConsumption(double meanConsumption) {
        this.meanConsumption = meanConsumption;
    }

    public double getKmsLastRide() {
        return this.kmsLastRide;
    }

    public void setKmsLastRide(double kmsLastRide) {
        this.kmsLastRide = kmsLastRide;
    }

    public double getMeanConsumptionLastRide() {
        return this.meanConsumptionLastRide;
    }

    public void setMeanConsumptionLastRide(double meanConsumptionLastRide) {
        this.meanConsumptionLastRide = meanConsumptionLastRide;
    }

    public double getRegenCap() {
        return this.regenCap;
    }

    public void setRegenCap(double regenCap) {
        this.regenCap = regenCap;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearManufacture=" + yearManufacture +
                ", consumptionRate=" + consumptionRate +
                ", kmsDone=" + kmsDone +
                ", meanConsumption=" + meanConsumption +
                ", kmsLastRide=" + kmsLastRide +
                ", meanConsumptionLastRide=" + meanConsumptionLastRide +
                ", regenCap=" + regenCap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearManufacture == car.yearManufacture &&
                Double.compare(car.consumptionRate, consumptionRate) == 0 &&
                Double.compare(car.kmsDone, kmsDone) == 0 &&
                Double.compare(car.meanConsumption, meanConsumption) == 0 &&
                Double.compare(car.kmsLastRide, kmsLastRide) == 0 &&
                Double.compare(car.meanConsumptionLastRide, meanConsumptionLastRide) == 0 &&
                Double.compare(car.regenCap, regenCap) == 0 &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public Car clone(){
        return new Car(this);
    }
}
