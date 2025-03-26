package com.mithe.searching.evaluators;

import com.mithe.searching.TicTacToe;
import com.mithe.searching.TicTacToe.Player;
import com.mithe.searching.interfaces.Evaluator;

public class TicTacToeEvaluator
    implements Evaluator<TicTacToe> {
    
    private final Player prioritizedPlayer;

    public TicTacToeEvaluator(Player prioritizedPlayer) {
        this.prioritizedPlayer = prioritizedPlayer;
    }

    public int evaluateState(TicTacToe state) {
        Player winner = state.won();

        if (winner == prioritizedPlayer) {
            return 1;
        } else if (winner == getOppositePlayer(prioritizedPlayer)) {
            return -1;
        } else {
            return 0;
        }
    }

    private Player getOppositePlayer(Player player) {
        return (player == Player.PLAYER_X) ? Player.PLAYER_O : Player.PLAYER_X;
    }
}
