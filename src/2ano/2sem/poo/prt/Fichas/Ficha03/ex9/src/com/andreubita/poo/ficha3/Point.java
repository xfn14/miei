package com.andreubita.poo.ficha3;

public class Point<X, Y> {
    public final X x;
    public final Y y;

    public Point(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point<X, Y> point){
        this.x = point.getX();
        this.y = point.getY();
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    @Override
    public Point<X,Y> clone(){
        return new Point<>(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point<?, ?> point = (Point<?, ?>) o;
        return getX().equals(point.getX()) &&
                getY().equals(point.getY());
    }
}
