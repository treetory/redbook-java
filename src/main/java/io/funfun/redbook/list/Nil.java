package io.funfun.redbook.list;

import java.util.NoSuchElementException;

public class Nil<T> extends ConsList<T> {

    private static Nil Nil;

    public static <T> Nil<T> getNil() {
        if (Nil == null) {
            Nil = new Nil<T>();
        }
        return Nil;
    }

    private Nil() {}

    public boolean isEmpty() {
        return true;
    }

    @Override
    public T head() {
        throw new NoSuchElementException("head of empty list");
    }

    public ConsList<T> tail() {
        throw new UnsupportedOperationException("tail of empty list");
    }

    @Override
    public T get(int index) {
        return (T) getNil();
    }

    @Override
    public int size() {
        return 0;
    }
}
