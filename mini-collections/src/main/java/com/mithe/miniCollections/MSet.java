package com.mithe.miniCollections;

import java.util.HashSet;
import java.util.Iterator;

import com.mithe.miniCollections.interfaces.MCollections;

public class MSet<E>
    implements MCollections<E> {

    private int size = 0;
    private HashSet<E> hashSet = new HashSet<>();

    @Override
    public int size() {
        return size;
    } 

    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        } else {
            hashSet.add(e);
            size++;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }
}
