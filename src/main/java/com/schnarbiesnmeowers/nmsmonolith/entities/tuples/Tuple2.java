package com.schnarbiesnmeowers.nmsmonolith.entities.tuples;

import java.io.Serializable;

public class Tuple2<A,B> implements Serializable {

    private static final long serialVersionUID = 1L;

    private A a;
    private B b;

    public Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public Tuple2() {
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

}
