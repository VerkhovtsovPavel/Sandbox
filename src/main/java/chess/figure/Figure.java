package chess.figure;

public class Figure {

    private final Type type;
    private final Color color;

    public Figure(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return switch (type) {
            case KING -> color == Color.WHITE ? "♔" : "♚";
            case QUEEN -> color == Color.WHITE ? "♕" : "♛";
            case BISHOP -> color == Color.WHITE ? "♗" : "♝";
            case KNIGHT -> color == Color.WHITE ? "♘" : "♞";
            case ROOK -> color == Color.WHITE ? "♖" : "♜";
            case PAWN -> color == Color.WHITE ? "♙" : "♟";
        };
    }
}