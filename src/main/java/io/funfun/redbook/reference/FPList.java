package io.funfun.redbook.reference;

import java.util.NoSuchElementException;

// 요것은... 스터디 시작했을 때, 찬호님께 가이드 받았던... 이렇게 구현하면 될 것 같다고 했던 샘플 코드임...
public abstract class FPList<T> {

    static final FPList NONE = new None();

    public static class None extends FPList<Object> {

        @Override
        Object getHead() {
            throw new NoSuchElementException();
        }

        @Override
        FPList getTail() {
            return NONE;
        }
    }

    public static class Cons<T> extends FPList<T> {

        private T head;
        private FPList<T> tail;

        public Cons(T head, FPList<T> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        T getHead() {
            return head;
        }

        @Override
        FPList<T> getTail() {
            return tail;
        }
    }

    abstract T getHead();

    abstract FPList<T> getTail();

    public static <T> FPList<T> cons(T head, FPList<T> tail) {
        return new Cons<T>(head, tail);
    }

    public static <T> FPList<T> none() {
        return NONE;
    }

    public static <T> FPList<T> cons(T... args) {
        FPList result = none();
        for (int i = args.length -1; i >= 0; i--) {
            result = cons(args[i], result);
        }
        return result;
    }

}
