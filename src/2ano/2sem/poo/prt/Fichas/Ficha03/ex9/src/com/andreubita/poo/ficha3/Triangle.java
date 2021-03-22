package com.andreubita.poo.ficha3;

public class Triangle {
    private Point<Double,Double> p1;
    private Point<Double,Double> p2;
    private Point<Double,Double> p3;

    public Triangle(){
        this.p1 = new Point<>(0.0,0.0);
        this.p2 = new Point<>(0.0,0.0);
        this.p3 = new Point<>(0.0,0.0);
    }

    public Triangle(
            Point<Double, Double> p1,
            Point<Double, Double> p2,
            Point<Double, Double> p3
    ) {
        this.p1 = p1.clone();
        this.p2 = p2.clone();
        this.p3 = p3.clone();
    }

    public Triangle(Triangle triangle){
        this.p1 = triangle.getP1();
        this.p2 = triangle.getP2();
        this.p3 = triangle.getP3();
    }

    /**
     * Calculate the perimeter
     *
     * @return perimeter of the triangle
     */
    public double calcPerimeter(){
        return getDistance(p1, p2) + getDistance(p2, p3) + getDistance(p3, p1);
    }

    /**
     * Calculate the distance between two points
     *
     * @param p1 first point
     * @param p2 second point
     * @return distance between the two
     */
    public double getDistance(Point<Double,Double> p1, Point<Double,Double> p2){
        return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
    }

    /**
     * Calculate area using Heron's Formula
     *
     * @return area of the triangle
     */
    public double calcArea(){
        double a = getDistance(getP1(), getP2()),
                b = getDistance(getP2(), getP3()),
                c = getDistance(getP3(), getP1()),
                s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    /**
     * Calculate the base of the triangle
     *
     * @return base of the triangle
     */
    public double getBase(){
        double a = getDistance(getP1(), getP2()),
                b = getDistance(getP2(), getP3()),
                c = getDistance(getP3(), getP1());
        return Math.max(Math.max(a, b), c);
    }

    /**
     * Calculate the height of a triangle
     *
     * @return height of the triangle
     */
    public double getHeight(){
        return Math.abs(getMaxY().getY()) + Math.abs(getMinY().getY());
    }

    /**
     * Get biggest X coordinate
     *
     * @return biggest x
     */
    public Point<Double, Double> getMaxX(){
        if(p1.getX() > p2.getX() && p1.getX() > p3.getX()) return p1.clone();
        else if(p2.getX() > p1.getX() && p2.getX() > p3.getX()) return p2.clone();
        else return p3.clone();
    }

    /**
     * Get smallest X coordinate
     *
     * @return smallest x
     */
    public Point<Double, Double> getMinX(){
        if(p1.getX() < p2.getX() && p1.getX() < p3.getX()) return p1.clone();
        else if(p2.getX() < p1.getX() && p2.getX() < p3.getX()) return p2.clone();
        else return p3.clone();
    }

    /**
     * Get biggest Y coordinate
     *
     * @return biggest Y
     */
    public Point<Double, Double> getMaxY(){
        if(p1.getY() > p2.getY() && p1.getY() > p3.getY()) return p1.clone();
        else if(p2.getY() > p1.getY() && p2.getY() > p3.getY()) return p2.clone();
        else return p3.clone();
    }

    /**
     * Get smallest Y coordinate
     *
     * @return smallest y
     */
    public Point<Double, Double> getMinY(){
        if(p1.getY() < p2.getY() && p1.getY() < p3.getY()) return p1.clone();
        else if(p2.getY() < p1.getY() && p2.getY() < p3.getY()) return p2.clone();
        else return p3.clone();
    }

    public Point<Double, Double> getP1() {
        return this.p1.clone();
    }

    public void setP1(Point<Double, Double> p1) {
        this.p1 = p1.clone();
    }

    public Point<Double, Double> getP2() {
        return this.p2.clone();
    }

    public void setP2(Point<Double, Double> p2) {
        this.p2 = p2.clone();
    }

    public Point<Double, Double> getP3() {
        return this.p3.clone();
    }

    public void setP3(Point<Double, Double> p3) {
        this.p3 = p3.clone();
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return getP1().equals(triangle.getP1()) &&
                getP2().equals(triangle.getP2()) &&
                getP2().equals(triangle.getP2());
    }

    @Override
    public Triangle clone(){
        return new Triangle(this);
    }
}
