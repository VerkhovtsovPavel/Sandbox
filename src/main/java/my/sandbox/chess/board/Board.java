package my.sandbox.chess.board;

import my.sandbox.chess.figure.Color;
import my.sandbox.chess.figure.Figure;
import my.sandbox.chess.figure.Type;

public class Board {
    private Figure[][] cells = new Figure[8][8];

    public Board() {
        cells[0][0] = new Figure(Type.ROOK, Color.WHITE);
        cells[0][1] = new Figure(Type.KNIGHT, Color.WHITE);
        cells[0][2] = new Figure(Type.BISHOP, Color.WHITE);
        cells[0][3] = new Figure(Type.QUEEN, Color.WHITE);
        cells[0][4] = new Figure(Type.KING, Color.WHITE);
        cells[0][5] = new Figure(Type.BISHOP, Color.WHITE);
        cells[0][6] = new Figure(Type.KNIGHT, Color.WHITE);
        cells[0][7] = new Figure(Type.ROOK, Color.WHITE);
        cells[1][0] = new Figure(Type.PAWN, Color.WHITE);
        cells[1][1] = new Figure(Type.PAWN, Color.WHITE);
        cells[1][2] = new Figure(Type.PAWN, Color.WHITE);
        cells[1][3] = new Figure(Type.PAWN, Color.WHITE);
        cells[1][4] = new Figure(Type.PAWN, Color.WHITE);
        cells[1][5] = new Figure(Type.PAWN, Color.WHITE);
        cells[1][6] = new Figure(Type.PAWN, Color.WHITE);
        cells[1][7] = new Figure(Type.PAWN, Color.WHITE);

        cells[7][0] = new Figure(Type.ROOK, Color.BLACK);
        cells[7][1] = new Figure(Type.KNIGHT, Color.BLACK);
        cells[7][2] = new Figure(Type.BISHOP, Color.BLACK);
        cells[7][3] = new Figure(Type.KING, Color.BLACK);
        cells[7][4] = new Figure(Type.QUEEN, Color.BLACK);
        cells[7][5] = new Figure(Type.BISHOP, Color.BLACK);
        cells[7][6] = new Figure(Type.KNIGHT, Color.BLACK);
        cells[7][7] = new Figure(Type.ROOK, Color.BLACK);
        cells[6][0] = new Figure(Type.PAWN, Color.BLACK);
        cells[6][1] = new Figure(Type.PAWN, Color.BLACK);
        cells[6][2] = new Figure(Type.PAWN, Color.BLACK);
        cells[6][3] = new Figure(Type.PAWN, Color.BLACK);
        cells[6][4] = new Figure(Type.PAWN, Color.BLACK);
        cells[6][5] = new Figure(Type.PAWN, Color.BLACK);
        cells[6][6] = new Figure(Type.PAWN, Color.BLACK);
        cells[6][7] = new Figure(Type.PAWN, Color.BLACK);
    }

    public Board(final Figure[][] cells) {
        this.cells = cells;
    }

    public void clean() {
        cells = new Figure[8][8];
    }

    public boolean move(final Row fromX, final Column fromY, final Row toX, final Column toY, final Color turn) {
        Figure moved = cells[fromX.getValue()][fromY.getValue()];
        Figure target = cells[toX.getValue()][toY.getValue()];

        if (!validateTurn(moved, target, turn)) {
            return false;
        }

        if (!validateGeometry(moved.getType())) {
            return false;
        }

        cells[fromX.getValue()][fromY.getValue()] = null;
        cells[toX.getValue()][toY.getValue()] = moved;
        return true;
    }

    private boolean validateGeometry(final Type type) {
        return true;
    }

    private boolean validateTurn(final Figure moved, final Figure target, Color turn) {
        return moved != null && target == null && turn == moved.getColor();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" |A|B|C|D|I|F|G|H|\n");
        for (int i = 0; i < cells.length; i++) {
            builder.append(String.format("%d|", i + 1));
            for (int j = 0; j < cells[0].length; j++) {
                Figure figure = cells[i][j];
                if (figure == null) {
                    builder.append(" ");
                } else {
                    builder.append(figure);
                }
                builder.append("|");
            }
            builder.append(String.format("%d\n", i + 1));
        }
        builder.append(" |A|B|C|D|I|F|G|H|\n");
        return builder.toString();
    }
}
