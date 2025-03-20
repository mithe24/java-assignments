package com.mithe.searching.frontierStrategies;

import java.util.Stack;

import com.mithe.searching.Node;
import com.mithe.searching.interfaces.FrontierStrategy;

public class DFSFrontier<S,A>
    implements FrontierStrategy<S,A> {

    private Stack<Node<S,A>> stack = new Stack<>();
    
    @Override
    public void add(Node<S, A> node) {
        stack.push(node);
    }

    @Override
    public Node<S, A> remove() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
