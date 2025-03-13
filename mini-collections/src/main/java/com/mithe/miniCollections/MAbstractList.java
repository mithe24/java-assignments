package com.mithe.miniCollections;

import com.mithe.miniCollections.interfaces.MList;
import com.mithe.miniCollections.interfaces.MListIterator;

public abstract class MAbstractList<E>
    extends MAbstractCollection<E> implements MList<E>{

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

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

    @Override
    public boolean contains(Object o) {
        MListIterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                return true;
            }
        }

        return false;
    }
}
