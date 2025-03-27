package com.schnarbiesnmeowers.nmsmonolith.entities.tuples;

import java.io.Serializable;

public class Tuple3<A,B,C> extends Tuple2<A,B> implements Serializable {

    private static final long serialVersionUID = 1L;
    private C c;

    public Tuple3(A a, B b,C c) {
        super(a, b);
        this.c = c;
    }

    public Tuple3() {

    }

    public C getC() {
        return c;
    }
}
