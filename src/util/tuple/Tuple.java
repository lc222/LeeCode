package util.tuple;

import java.util.Optional;

/**
 * Tuple元组类
 *
 * @since: 12/4/15.
 * @author: http://yjmyzz.cnblogs.com/
 */
@SuppressWarnings("all")
public abstract class Tuple {

    public abstract <A> Optional<A> _1();

    public abstract <B> Optional<B> _2();

    public abstract <C> Optional<C> _3();

    public abstract <D> Optional<D> _4();

    public abstract <E> Optional<E> _5();

    public static <A, B> Tuple2<A, B> of(A a, B b) {
        return new Tuple2(a, b);
    }

    public static <A, B, C> Tuple3<A, B, C> of(A a, B b, C c) {
        return new Tuple3(a, b, c);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D> of(A a, B b, C c, D d) {
        return new Tuple4(a, b, c, d);
    }

    public static <A, B, C, D, E> Tuple5<A, B, C, D, E> of(A a, B b, C c, D d, E e) {
        return new Tuple5(a, b, c, d, e);
    }


    public static void main(String[] args) {
        Tuple t2 = Tuple.of(1, "one");
        System.out.println(t2);
        System.out.println(t2._1().get() + "," + t2._2().get());

        System.out.println("----------");
        Tuple2<String, Integer> _t2 = new Tuple2<>("a", 123);
        System.out.println(_t2._1().get());
        System.out.println(_t2._2().get());

        Tuple t3 = Tuple.of(1, "one", "一");
        System.out.println(t3);
        System.out.println(t3._1().get() + "," + t3._2().get() + "," + t3._3().get());


        Tuple t4 = Tuple.of(1, "one", "一", "壹");
        System.out.println(t4);
        System.out.println(t4._1().get() + "," + t4._2().get() + "," + t4._3().get() + "," + t4._4().get());

        Tuple t5 = Tuple.of(1, "one", "一", "壹", "yi");
        System.out.println(t5);
        System.out.println(t5._1().get() + "," + t5._2().get() + "," + t5._3().get() + "," + t5._4().get() + "," + t5._5().get());
    }

}
