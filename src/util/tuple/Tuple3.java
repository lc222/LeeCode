package util.tuple;

import java.util.Optional;

@SuppressWarnings("all")
public class Tuple3<A, B, C> extends Tuple {
    private A a;
    private B b;
    private C c;

    Tuple3(A e, B t, C k) {
        this.a = e;
        this.b = t;
        this.c = k;
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

    @Override
    public <D> Optional<D> _4() {
        return Optional.empty();
    }

    @Override
    public <E> Optional<E> _5() {
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "Tuple3{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}