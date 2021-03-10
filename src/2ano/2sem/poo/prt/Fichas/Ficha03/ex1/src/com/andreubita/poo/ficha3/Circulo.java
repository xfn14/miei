package com.andreubita.poo.ficha3;

public class Circulo {
    private double x;
    private double y;
    private double raio;

    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 1;
    }

    public Circulo(double cx, double cy, double craio){
        this.x = cx;
        this.y = cy;
        this.raio = craio;
    }

    public Circulo(Circulo c){
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }

    public void alteraCentro(double cx, double cy){
        this.setX(cx);
        this.setY(cy);
    }

    public double calculaArea(){
        return Math.PI * this.getRaio() * this.getRaio();
    }

    public double calculaPerimetro(){
        return 2 * Math.PI * this.getRaio();
    }

    public double getX() {
        return this.x;
    }

    public void setX(double cx) {
        this.x = cx;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double cy) {
        this.y = cy;
    }

    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double craio) {
        this.raio = craio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circulo circulo = (Circulo) o;
        return circulo.getX() == this.getX()
                && circulo.getY() == this.getY()
                && circulo.getRaio() == this.getRaio();
    }

    @Override
    public Circulo clone() {
        return new Circulo(this);
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "x=" + x +
                ", y=" + y +
                ", raio=" + raio +
                '}';
    }
}
