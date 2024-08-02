package my.sandbox.maze;

import static my.sandbox.common.logger.CommonLogger.LOG;


public class Main {

    private static final int X = 10;
    private static final int Y = 5;

    public static void main(final String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator(X, Y);
        LOG.info(mazeGenerator.generateMaze().toString(DisplayInfo.BASE));
    }
}
