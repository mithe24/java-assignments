package com.mithe.searching.searchStrategies;

import com.mithe.searching.Node;
import com.mithe.searching.interfaces.Evaluator;
import com.mithe.searching.interfaces.Problem;
import com.mithe.searching.interfaces.SearchStrategy;
import com.mithe.searching.Pair;

public class MinMaxSearch<S, A> 
    implements SearchStrategy<S, A> {

    private Evaluator<S> evaluator;

    public MinMaxSearch(Evaluator<S> evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public Node<S, A> search(Problem<S, A> problem) {
        return search(problem, problem.initial());
    }

    public Node<S, A> search(Problem<S, A> problem, S startState) {
        Node<S, A> rootNode = new Node<>(startState, null, null, 0.0);
        Pair<Integer, Node<S, A>> result = maxValue(problem, rootNode);
        return result == null ? null : result.value();
    }

    private Pair<Integer, Node<S, A>> maxValue(Problem<S, A> problem, Node<S, A> node) {
        if (problem.isTerminal(node.state()) || problem.isGoal(node.state())) {
            return new Pair<>(evaluator.evaluateState(node.state()), node);
        } else {
            int bestValue = Integer.MIN_VALUE;
            S nextState;
            Node<S, A> bestNode = null, childNode;
            Pair<Integer, Node<S, A>> valuePair;

            for (A action : problem.actions(node.state())) {
                nextState = problem.result(node.state(), action);
                childNode = new Node<>(nextState, node, action, 1.0);
                valuePair = minValue(problem, childNode);
                if (valuePair != null && valuePair.key() > bestValue) {
                    bestValue = valuePair.key();
                    bestNode = childNode;
                }
            }

            return new Pair<>(bestValue, bestNode);
        }
    }

    private Pair<Integer, Node<S, A>> minValue(Problem<S, A> problem, Node<S, A> node) {
        if (problem.isTerminal(node.state()) || problem.isGoal(node.state())) {
            return new Pair<>(evaluator.evaluateState(node.state()), node);
        } else {
            int bestValue = Integer.MAX_VALUE;
            S nextState;
            Node<S, A> bestNode = null, childNode;
            Pair<Integer, Node<S, A>> valuePair;

            for (A action : problem.actions(node.state())) {
                nextState = problem.result(node.state(), action);
                childNode = new Node<>(nextState, node, action, 1.0);
                valuePair = maxValue(problem, childNode);
                if (valuePair != null && valuePair.key() < bestValue) {
                    bestValue = valuePair.key();
                    bestNode = childNode;
                }
            }

            return new Pair<>(bestValue, bestNode);
        }
    }
}
