package maze;

public class Main {

    private static final int defaultX = 10;
    private static final int defaultY = 5;

    public static void main(String[] args) {
        int x = parseParameter(args, 0, defaultX);
        int y = parseParameter(args, 1, defaultY);
        MazeGenerator mazeGenerator = new MazeGenerator(x, y);
        System.out.println(mazeGenerator.generateMaze(1,1).toString(DisplayInfo.base));
    }

    private static int parseParameter(String[] args, int index, int defaultValue) {
        try {
            return Integer.parseInt(args[index]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return defaultValue;
        }
    }
}
