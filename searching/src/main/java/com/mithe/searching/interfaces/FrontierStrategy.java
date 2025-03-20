package com.mithe.searching.interfaces;

import com.mithe.searching.Node;

public interface FrontierStrategy<S,A> {

    void add(Node<S,A> node);
    Node<S,A> remove();
    boolean isEmpty();
}
