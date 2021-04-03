package com.andreubita.poo.ficha3;

public class Tuple<X, Y> {
    public final X x;
    public final Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public Tuple(Tuple<X, Y> tuple){
        this.x = tuple.getX();
        this.y = tuple.getY();
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    @Override
    public Tuple<X,Y> clone(){
        return new Tuple<>(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return getX().equals(tuple.getX()) &&
                getY().equals(tuple.getY());
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
