package com.schnarbiesnmeowers.nmsmonolith.pojos.tuples;

import java.io.Serializable;

public class Tuple6<A,B,C,D,E,F> extends Tuple5<A,B,C,D,E> implements Serializable {

    private static final long serialVersionUID = 1L;

    private F f;

    public Tuple6(A a, B b, C c, D d, E e,F f) {
        super(a,b,c,d,e);
        this.f = f;
    }

    public Tuple6() {

    }
    public F getF() {
        return f;
    }
}
