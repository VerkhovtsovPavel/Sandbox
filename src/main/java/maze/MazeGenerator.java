package maze;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiPredicate;

public class MazeGenerator {
    private final int x;
    private final int y;
    private final BiPredicate<Integer, Integer> bounds;
    private final BiPredicate<Integer, Integer> visiting;
    private boolean endFlag = false;
    private int[][] maze;

    public MazeGenerator(int x, int y) {
        this.x = x;
        this.y = y;
        this.maze = new int[this.x][this.y];
        this.bounds = (nx, ny) -> (nx >= 0) && (nx < x) && (ny >= 0) && (ny < y);
        this.visiting = (nx, ny) -> (maze[nx][ny] == 0);
    }

    public Maze generateMaze(int cx, int cy) {
        maze = new int[this.x][this.y];
        endFlag = false;
        maze[cx][cy] |= Type.START.bit;
        generate(cx, cy);
        return getMaze();
    }

    private void generate(int cx, int cy) {
        Direction[] dirs = Direction.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (Direction dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (bounds.and(visiting).test(nx, ny)) {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generate(nx, ny);
            }
        }
        setEnd(maze, cx, cy);
    }

    private void setEnd(int[][] maze, int cx, int cy) {
        if(!endFlag) {
            endFlag = true;
            maze[cx][cy] |= Type.FINISH.bit;
        }
    }

    public Maze getMaze() {
        return new Maze(this.maze);
    }
}
