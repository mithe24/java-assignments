package com.mithe.searching.comparators;

import java.util.Comparator;

import com.mithe.searching.Node;

public class NodeCostComparator
    implements Comparator<Node<?,?>> {

    @Override
    public int compare(Node<?, ?> arg0, Node<?, ?> arg1) {
        return Double.compare(arg0.cost(), arg1.cost());
    }
}
