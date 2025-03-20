package com.mithe.searching.problems;

import com.mithe.searching.TicTacToe;
import com.mithe.searching.TicTacToe.Player;

public class VictoryProblem
    extends TicTacToeProblem {

    @Override
    public boolean isGoal(TicTacToe state) {
        return state.gameOver() && state.won() != Player.NONE;
    }
    
}
