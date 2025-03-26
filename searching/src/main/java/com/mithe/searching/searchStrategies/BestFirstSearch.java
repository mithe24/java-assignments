package com.mithe.searching.searchStrategies;

import com.mithe.searching.interfaces.SearchStrategy;
import com.mithe.searching.interfaces.FrontierStrategy;
import com.mithe.searching.interfaces.Problem;
import com.mithe.searching.Node;
import com.mithe.searching.frontierStrategies.BestFirstFrontier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestFirstSearch<S,A>
    implements SearchStrategy<S,A> {

    private FrontierStrategy<S,A> frontier;

    /*
     * Constructors
     */
    public BestFirstSearch(Comparator<? super Node<S,A>> comparator) {
        frontier = new BestFirstFrontier<>(comparator);
    }

    public BestFirstSearch(FrontierStrategy<S,A> frontier) {
        this.frontier = frontier;
    }

    /*
     * Methods
     */
    @Override
    public Node<S, A> search(Problem<S, A> problem) {
        return search(problem, problem.initial());
    }
    
    public Node<S, A> search(Problem<S, A> problem, S currentState) {
        Map<S, Double> reached = new HashMap<>();
        Node<S,A> currentNode;
        List<Node<S,A>> successors;

        Node<S,A> startNode = new Node<>(currentState, null, null, 0.0);
        frontier.add(startNode);

        while (!frontier.isEmpty()) {
            currentNode = frontier.remove();
            currentState = currentNode.state();

            if (problem.isGoal(currentState)) { return currentNode; }
            if (reached.containsKey(currentState)) { continue; }

            reached.put(currentState, currentNode.cost());
            successors = expand(problem, currentNode);

            for (Node<S,A> successor : successors) {
                frontier.add(successor);
            }
        }

        // If no winner is found
        return null;
    } 

    private List<Node<S,A>> expand(Problem<S,A> problem, Node<S,A> currentNode) {
        List<Node<S,A>> successors = new ArrayList<>();
        S currentState = currentNode.state();

        S nextState;
        double newCost;

        for (A action : problem.actions(currentState)) {
            nextState = problem.result(currentState, action);
            newCost = currentNode.cost() + problem.cost(currentState, action);
            Node<S, A> nextNode = new Node<>(nextState, currentNode, action, newCost);
            successors.add(nextNode);
        }

        return successors;
    }
}
