package com.mithe.searching.interfaces;

import com.mithe.searching.Node;

public interface SearchStrategy<S,A> {

    Node<S, A> search(Problem<S,A> problem);
}
