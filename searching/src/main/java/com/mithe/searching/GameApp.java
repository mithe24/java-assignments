package com.mithe.searching;

import java.util.Scanner;

import com.mithe.searching.TicTacToe.Player;
import com.mithe.searching.evaluators.TicTacToeEvaluator;
import com.mithe.searching.interfaces.Evaluator;
import com.mithe.searching.interfaces.Problem;
import com.mithe.searching.problems.CpuVictoryProblem;
import com.mithe.searching.searchStrategies.MinMaxSearch;

public class GameApp {
    static TicTacToe game = new TicTacToe();
    static Scanner scanner = new Scanner(System.in);

    static Problem<TicTacToe, Integer> problem = new CpuVictoryProblem(Player.PLAYER_O);
    static Evaluator<TicTacToe> evaluator = new TicTacToeEvaluator(Player.PLAYER_O);
    static MinMaxSearch<TicTacToe, Integer> searchStrategy = new MinMaxSearch<>(evaluator);

    public static void main(String[] args) {
        while (!game.gameOver()) {
            game.printBoard();
            playerMove();
            aiMove();
            clear();
        }

        System.out.println("winner was " + game.won());
    } 

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void playerMove() {
        game.move(scanner.nextInt());
    }

    private static void aiMove() {
        Node<TicTacToe, Integer> node = searchStrategy.search(problem, game);

        while (node.parent() != null && node.parent().action() != null) {
            node = node.parent();
        }
        game.move(node.action());
    }
}
