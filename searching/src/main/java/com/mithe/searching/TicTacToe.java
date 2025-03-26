package com.mithe.searching;

import java.util.Arrays;

public class TicTacToe {
    public enum Player {
        PLAYER_X(-1),
        PLAYER_O(-2),
        NONE(0);

        private final int value;

        Player(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private static final int[][] WINGINGCOMBINATION = {
        {0,1,2}, {3,4,5}, {6,7,8},  // Horizontal
        {0,3,6}, {1,4,7}, {2,5,8},  // Vertical
        {0,4,8}, {6,4,2}            // Diaognal
    };

    private Player[] board = new Player[9];
    private boolean isPlayerX = true;

    public TicTacToe() {
        Arrays.fill(board, Player.NONE);
    }

    // Copy constructor
    public TicTacToe(TicTacToe other) {
        this.board = Arrays.copyOf(other.board, other.board.length);
        this.isPlayerX = other.isPlayerX;
    }

    public boolean move(int tile) {
        if (tile >= 9 || tile < 0) {
            throw new IllegalArgumentException("tile should be atleast 0, and less than 9");
        }

        board[tile] = isPlayerX ? Player.PLAYER_X : Player.PLAYER_O;

        isPlayerX = !isPlayerX;
        return true;
    }

    public boolean isFree(int tile) {
        if (tile >= 9 || tile < 0) {
            throw new IllegalArgumentException("tile should be atleast 0, and less than 9");
        }

        return board[tile] == Player.NONE;
    }

    public boolean gameOver() {
        return won() != Player.NONE || isBoardFull();
    }

    public Player won() {
        for (int[] combo : WINGINGCOMBINATION) {
            if (board[combo[0]] == board[combo[1]] 
                && board[combo[1]] == board[combo[2]]) {

                return board[combo[0]];
            }
        }

        return Player.NONE;
    }

    public Player[] getBoard() {
        return board; // Return the current board state
    }

    public boolean isPlayerX() {
        return isPlayerX; // Return the current player
    }

    private boolean isBoardFull() {
        int i = 0;
        while (i < 9 && board[i] != Player.NONE) {
            i++;
        }

        return i == 9;
    }

    public void printBoard() {
        String[] strBoard = new String[9];
        for (int i = 0; i < 9; i++) {
            if (board[i] == Player.NONE) {
                strBoard[i] = Integer.toString(i);
            } else if (board[i] == Player.PLAYER_X) {
                strBoard[i] = "X";
            } else {
                strBoard[i] = "O";
            }
        }
        System.out.println("+-+-+-+\n" + 
            "|" + strBoard[6] + "|" + strBoard[7] + "|" + strBoard[8] + "|\n" + 
            "+-+-+-+\n" +
            "|" + strBoard[3] + "|" + strBoard[4] + "|" + strBoard[5] + "|\n" + 
            "+-+-+-+\n" +
            "|" + strBoard[0] + "|" + strBoard[1] + "|" + strBoard[2] + "|\n" +
            "+-+-+-+");
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < 9; i++) {
            result = 31 * result + board[i].getValue();
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || getClass() != obj.getClass()) { return false; }

        TicTacToe other = (TicTacToe) obj;
        return Arrays.equals(this.board, other.board);
    }

    @Override
    public TicTacToe clone() {
        return new TicTacToe(this);
    }
}
