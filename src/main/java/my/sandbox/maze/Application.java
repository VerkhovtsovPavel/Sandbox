package my.sandbox.maze;

import static my.sandbox.common.logger.CommonLogger.LOG;

public final class Application {
    private static final int X = 10;
    private static final int Y = 5;

    private Application() {
    }

    public static void main(final String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator(X, Y);
        LOG.info(mazeGenerator.generateMaze().toString(DisplayInfo.BASE));
    }
}
