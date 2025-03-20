package com.mithe.searching.problems;

import com.mithe.searching.TicTacToe;
import com.mithe.searching.TicTacToe.Player;

public class PlayerVictoryProblem
    extends TicTacToeProblem {
    
    private final Player player;

    public PlayerVictoryProblem(Player player) {
        this.player = player;
    }

    @Override
    public boolean isGoal(TicTacToe state) {
        return state.gameOver() && state.won() == player;
    }
    
}
