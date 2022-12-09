package maze;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MazeGenerator {
    private final int x;
    private final int y;
    private boolean endFlag = false;

    public MazeGenerator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Maze generateMaze() {
        Random rnd = new Random();
        int cx = rnd.nextInt(x);
        int cy = rnd.nextInt(y);
        return generateMaze(cx, cy);
    }

    public Maze generateMaze(int cx, int cy) {
        int[][] maze = new int[x][y];
        endFlag = false;
        maze[cx][cy] |= Type.START.bit;
        generate(maze, cx, cy);
        return new Maze(maze);
    }

    private void generate(int[][] maze, int cx, int cy) {
        Direction[] dirs = Direction.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (Direction dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (isVisit(maze, nx, ny)) {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generate(maze, nx, ny);
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

    private boolean isVisit(int[][] maze, int nx, int ny) {
        return (nx >= 0) && (nx < x) && (ny >= 0) && (ny < y) && (maze[nx][ny] == 0);
    }
}
