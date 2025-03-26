package com.mithe.searching.problems;

import com.mithe.searching.TicTacToe;
import com.mithe.searching.TicTacToe.Player;

public class CpuVictoryProblem
    extends TicTacToeProblem {

    private Player cpu;

    public CpuVictoryProblem(Player cpu) {
        this.cpu = cpu;
    }
    
    @Override
    public boolean isGoal(TicTacToe state) {
        return state.gameOver() && state.won() == cpu;
    }
}
