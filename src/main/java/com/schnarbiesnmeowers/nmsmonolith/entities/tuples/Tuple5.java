package com.schnarbiesnmeowers.nmsmonolith.entities.tuples;

import java.io.Serializable;

public class Tuple5<A,B,C,D,E> extends Tuple4<A,B,C,D> implements Serializable {

    private static final long serialVersionUID = 1L;

    private E e;

    public Tuple5(A a, B b, C c, D d, E e) {
        super(a,b,c,d);
        this.e = e;
    }

    public Tuple5() {

    }
    public E getE() {
        return e;
    }
}
