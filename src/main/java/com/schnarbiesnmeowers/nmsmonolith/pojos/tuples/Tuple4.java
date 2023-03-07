package com.schnarbiesnmeowers.nmsmonolith.pojos.tuples;

import java.io.Serializable;

public class Tuple4<A,B,C,D> extends Tuple3<A,B,C> implements Serializable {

    private static final long serialVersionUID = 1L;

    private D d;

    public Tuple4(A a, B b, C c, D d) {
        super(a, b, c);
        this.d = d;
    }

    public Tuple4() {

    }
    public D getD() {
        return d;
    }
}
