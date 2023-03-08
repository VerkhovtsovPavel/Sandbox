package my.sandbox.chess;

import my.sandbox.chess.board.Board;
import my.sandbox.chess.board.Column;
import my.sandbox.chess.board.Row;
import my.sandbox.chess.figure.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Board gameBoard;
    private final List<String> history = new ArrayList<>();
    private Color currentTurn = Color.WHITE;

    public Game() {
        gameBoard = new Board();
    }

    public Color start() {
        while (true) {
            readCommand();
            print();
            switchTurn();
        }
    }

    private void switchTurn() {
        if (currentTurn == Color.BLACK) {
            currentTurn = Color.WHITE;
        } else {
            currentTurn = Color.BLACK;
        }
    }

    public void print() {
        System.out.println(gameBoard.toString());
    }

    public void move() {
        gameBoard.move(Row.ONE, Column.B, Row.THREE, Column.C, currentTurn);
    }

    public void readCommand() {
        var command = new Scanner(System.in).next();

        switch (command) {
            case "Draw" -> offerDraw();
            case "Lose" -> endGame();
            case "Move" -> move();
        }
    }

    private void offerDraw() {
    }

    private void endGame() {
    }
}
