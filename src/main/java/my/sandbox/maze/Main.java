package my.sandbox.maze;

public class Main {

    private static final int DEFAULT_X = 10;
    private static final int DEFAULT_Y = 5;

    public static void main(final String[] args) {
        int x = parseParameter(args, 0, DEFAULT_X);
        int y = parseParameter(args, 1, DEFAULT_Y);
        MazeGenerator mazeGenerator = new MazeGenerator(x, y);
        System.out.println(mazeGenerator.generateMaze(1, 1).toString(DisplayInfo.BASE));
    }

    private static int parseParameter(final String[] args, final int index, final int defaultValue) {
        try {
            return Integer.parseInt(args[index]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return defaultValue;
        }
    }
}
