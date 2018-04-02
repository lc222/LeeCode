package util.tuple;

import java.util.Optional;

@SuppressWarnings("all")
public class Tuple4<A, B, C, D> extends Tuple {
    private A a;
    private B b;
    private C c;
    private D d;

    Tuple4(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    @Override
    public <E> Optional<E> _5() {
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "Tuple4{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}