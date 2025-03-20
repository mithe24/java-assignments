package com.mithe.searching;

import java.util.Scanner;

import com.mithe.searching.comparators.NodeCostComparator;
import com.mithe.searching.interfaces.Problem;
import com.mithe.searching.problems.TieProblem;
import com.mithe.searching.problems.VictoryProblem;

public class GameApp {
    static TicTacToe game = new TicTacToe();
    static Scanner scanner = new Scanner(System.in);
    static Problem<TicTacToe, Integer> problem = new VictoryProblem();
    static NodeCostComparator comparator = new NodeCostComparator();
    static BestFirstSearch<TicTacToe, Integer> searchStrategy = new BestFirstSearch<>(comparator);

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

        if (node == null) {
            problem = new TieProblem();
            aiMove();
        } else {
            while (node.parent() != null && node.parent().action() != null) {
                node = node.parent();
            }
            if (node.action() != null) {
                game.move(node.action());
            }
        }
    }
}
