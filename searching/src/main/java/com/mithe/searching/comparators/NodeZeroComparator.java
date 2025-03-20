package com.mithe.searching.comparators;

import java.util.Comparator;

import com.mithe.searching.Node;

public class NodeZeroComparator
    implements Comparator<Node<?,?>> {

    @Override
    public int compare(Node<?, ?> arg0, Node<?, ?> arg1) {
        return 0;
    }
}
