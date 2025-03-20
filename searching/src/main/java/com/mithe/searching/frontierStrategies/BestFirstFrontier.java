package com.mithe.searching.frontierStrategies;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.mithe.searching.Node;
import com.mithe.searching.interfaces.FrontierStrategy;

public class BestFirstFrontier<S,A>
    implements FrontierStrategy<S,A>{

    private PriorityQueue<Node<S,A>> queue;

    public BestFirstFrontier(Comparator<? super Node<S,A>> comparator) {
        queue = new PriorityQueue<>(comparator);
    }

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
