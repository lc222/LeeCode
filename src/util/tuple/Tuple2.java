package util.tuple;

import java.util.Optional;

@SuppressWarnings("all")
public class Tuple2<A, B> extends Tuple {
    private A a;
    private B b;

    Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @SuppressWarnings("unchecked")
    public Optional<A> _1() {
        if (a == null) {
            return Optional.empty();
        }
        return Optional.of(a);
    }

    @SuppressWarnings("unchecked")
    public Optional<B> _2() {
        if (b == null) {
            return Optional.empty();
        }
        return Optional.of(b);
    }

    @SuppressWarnings("unchecked")
    public <C> Optional<C> _3() {
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    public <D> Optional<D> _4() {
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    public <E> Optional<E> _5() {
        return Optional.empty();
    }


    public String toString() {
        return "Tuple2{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}