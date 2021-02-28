package models;

public class ABNumberPair implements Comparable<ABNumberPair> {
    public int a,b;

    public ABNumberPair(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(ABNumberPair o) {
        return Integer.compare(this.a, o.a);
    }
}
