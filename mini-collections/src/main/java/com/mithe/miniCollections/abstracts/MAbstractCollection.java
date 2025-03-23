package com.mithe.miniCollections.abstracts;

import java.util.Iterator;

import com.mithe.miniCollections.interfaces.MCollections;

public abstract class MAbstractCollection<E>
    implements MCollections<E> {

    protected int size = 0;

    @Override
    public boolean contains(Object o) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
