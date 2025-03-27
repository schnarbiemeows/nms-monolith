package com.schnarbiesnmeowers.nmsmonolith.entities.tuples;

import java.io.Serializable;

public class Tuple7<A,B,C,D,E,F,G> extends Tuple6<A,B,C,D,E,F> implements Serializable {

    private static final long serialVersionUID = 1L;

    private G g;

    public Tuple7(A a, B b, C c, D d, E e,F f,G g) {
        super(a,b,c,d,e,f);
        this.g = g;
    }

    public Tuple7() {

    }
    public G getG() {
        return g;
    }
}
