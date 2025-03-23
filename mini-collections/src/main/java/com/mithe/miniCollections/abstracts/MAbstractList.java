package com.mithe.miniCollections.abstracts;

import com.mithe.miniCollections.interfaces.MList;
import com.mithe.miniCollections.interfaces.MListIterator;

public abstract class MAbstractList<E>
    extends MAbstractCollection<E> implements MList<E>{

    @Override
    public E get(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds of " + index);
        }

        int i = 0;
        MListIterator<E> iterator = iterator();
        while (iterator.hasNext() && i < index) {
            iterator.next();
        }
        
        return iterator.next();
    }
}
