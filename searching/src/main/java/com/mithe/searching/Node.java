package com.mithe.searching;

public class Node<S,A> {

    private S state;
    private A action;
    private double cost;
    private Node<S,A> parent;

    public Node(S state) {
        this.state = state;
    }

    public Node(S state, Node<S,A> parent, A action, double cost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.cost = cost;
    }

    public S state() {
        return state;
    }
    
    public Node<S,A> parent() {
        return parent;
    }

    public A action() {
        return action;
    }

    public double cost() {
        return cost;
    }

    public int depth() {
        int depth = 0;
        Node<S,A> current = this;

        while(current.parent() != null) {
            current = current.parent();
            depth++;
        }

        return depth;
    }
}
