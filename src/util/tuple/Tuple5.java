package util.tuple;

import java.util.Optional;

@SuppressWarnings("all")
public class Tuple5<A, B, C, D, E> extends Tuple {
    private A a;
    private B b;
    private C c;
    private D d;
    private E e;

    Tuple5(A a, B b, C c, D d, E e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    public Optional<A> _1() {
        if (a == null) {
            return Optional.empty();
        }
        return Optional.of(a);
    }

    public Optional<B> _2() {
        if (b == null) {
            return Optional.empty();
        }
        return Optional.of(b);
    }

    public Optional<C> _3() {
        if (c == null) {
            return Optional.empty();
        }
        return Optional.of(c);
    }

    public Optional<D> _4() {
        if (d == null) {
            return Optional.empty();
        }
        return Optional.of(d);
    }

    public Optional<E> _5() {
        if (e == null) {
            return Optional.empty();
        }
        return Optional.of(e);
    }

    @Override
    public String toString() {
        return "Tuple5{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                '}';
    }
}