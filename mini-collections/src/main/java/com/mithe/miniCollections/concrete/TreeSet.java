package com.mithe.miniCollections.concrete;

import com.mithe.miniCollections.interfaces.MSet;

public class TreeSet<E extends Comparable<E>>
    extends BinaryTree<E> implements MSet<E> {

    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }

        Node newNode = new Node(e);
        Node parrent = null, current = root;

        while (current != null) {
            parrent = current;
            if (e.compareTo(current.leftChild.data) < 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        newNode.parrent = parrent;

        if (parrent == null) {
            root = newNode;
        } else if (e.compareTo(parrent.data) < 0) {
            parrent.leftChild = newNode;
        } else {
            parrent.rightChild = newNode;
        }

        super.size++;
        return true;
    }
}
