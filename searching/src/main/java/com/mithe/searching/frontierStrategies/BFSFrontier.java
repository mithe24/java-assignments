package com.mithe.searching.frontierStrategies;

import java.util.LinkedList;
import java.util.Queue;

import com.mithe.searching.Node;
import com.mithe.searching.interfaces.FrontierStrategy;

public class BFSFrontier<S,A>
    implements FrontierStrategy<S,A> {

    private Queue<Node<S,A>> queue = new LinkedList<>();

    @Override
    public void add(Node<S, A> node) {
        queue.add(node);
    }

    @Override
    public Node<S, A> remove() {
        return queue.poll();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
