package com.mithe.searching;

import java.util.HashSet;
import java.util.Set;

import com.mithe.searching.frontierStrategies.DFSFrontier;
import com.mithe.searching.interfaces.FrontierStrategy;
import com.mithe.searching.interfaces.Problem;
import com.mithe.searching.interfaces.SearchStrategy;

public class IterativeDeepeningSearch<S,A>
    implements SearchStrategy<S,A> {

    @Override
    public Node<S, A> search(Problem<S, A> problem) {
        return search(problem, problem.initial());
    }

    public Node<S, A> search(Problem<S, A> problem, S startState) {
        int depth = 0;
        Node<S,A> result;

        while (true) {
            result = depthLimitedSearch(problem, depth, startState);
            if (result != null) {
                return result;
            }
            depth++;
        }
    }

    private Node<S,A> depthLimitedSearch(Problem<S,A> problem, int maxDepth, S startState) {
        FrontierStrategy<S,A> frontier = new DFSFrontier<>();
        Set<S> explored = new HashSet<>();

        Node<S,A> currentNode;
        Node<S,A> childNode;
        double cost = 0;
        S newState;

        Node<S,A> initialNode = new Node<>(startState, null, null, 0.0);
        frontier.add(initialNode);
        while (!frontier.isEmpty()) {
            currentNode = frontier.remove();

            if (problem.isGoal(currentNode.state())) { return currentNode; }
            if (currentNode.depth() > maxDepth) { continue; }

            explored.add(currentNode.state());

            for (A action : problem.actions(currentNode.state())) {
                newState = problem.result(currentNode.state(), action);
                if (!explored.contains(newState)) {
                    cost = currentNode.cost() + problem.cost(currentNode.state(), action);
                    childNode = new Node<>(newState, currentNode, action, cost);
                    frontier.add(childNode);
                }
            }
        }

        return null;
    }
}
