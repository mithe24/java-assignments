package com.mithe.searching.problems;

import java.util.LinkedList;
import java.util.List;

import com.mithe.searching.TicTacToe;
import com.mithe.searching.interfaces.Problem;

abstract class TicTacToeProblem 
    implements Problem<TicTacToe, Integer> {

    @Override
    public TicTacToe initial() {
        return new TicTacToe();
    }

    @Override
    public boolean isState(TicTacToe state) {
        return state != null;
    }

    @Override
    public Iterable<Integer> actions(TicTacToe state) {
        List<Integer> validMoves = new LinkedList<>();

        for (int i = 0; i < 9; i++) {
            if (state.isFree(i)) {
                validMoves.add(i);
            }
        }

        return validMoves;
    }

    @Override
    public TicTacToe result(TicTacToe state, Integer action) {
        TicTacToe newState = state.clone();
        newState.move(action);
        return newState;
    }

    @Override
    public double cost(TicTacToe state, Integer action) {
        return 1.0;
    }

    @Override
    public boolean isTerminal(TicTacToe state) {
        return state.gameOver();
    }
}
