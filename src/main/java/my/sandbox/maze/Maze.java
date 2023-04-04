package my.sandbox.maze;

import static my.sandbox.maze.SymbolConstants.NEXT_LINE;
import static my.sandbox.maze.SymbolConstants.SPACE;

public record Maze(int[][] matrix) {

    public String toString(DisplayInfo info) {
        StringBuilder buffer = new StringBuilder();

        // Build maze line by line
        for (int i = 0; i < matrix[0].length; i++) {
            // Add the flats and tops
            for (int[] line : matrix) {
                buffer
                        .append(info.getCorner())
                        .append(isBitNotSet(line[i], Direction.N) ? info.getFlat() : info.getSpaces());
            }
            buffer.append(info.getCorner()).append(NEXT_LINE);

            // Add the walls
            int marketPlace = info.getWall().length() / 2;
            int currentLevel = 0;
            for (char wallSign : info.getWall().toCharArray()) {
                for (int[] line : matrix) {
                    if (isBitNotSet(line[i], Direction.W)) {
                        buffer.append(wallSign);
                    } else {
                        buffer.append(SPACE);
                    }

                    if (!isBitNotSet(line[i], Type.START)) {
                        if (info.isDuplicateSign() || currentLevel == marketPlace) {
                            buffer.append(info.getStartSign());
                        } else {
                            buffer.append(info.getSpaces());
                        }
                    } else if (!isBitNotSet(line[i], Type.FINISH)) {
                        if (info.isDuplicateSign() || currentLevel == marketPlace) {
                            buffer.append(info.getEndSign());
                        } else {
                            buffer.append(info.getSpaces());
                        }
                    } else {
                        buffer.append(info.getSpaces());
                    }
                }
                buffer.append(wallSign).append(NEXT_LINE);
                currentLevel++;
            }

        }
        // Add the bottom line
        for (int j = 0; j < matrix.length; j++) {
            buffer.append(info.getCorner()).append(info.getFlat());
        }
        buffer.append(info.getCorner()).append(NEXT_LINE);

        return buffer.toString();
    }

    private boolean isBitNotSet(int cell, Bitable bitable) {
        return (cell & bitable.getBit()) == 0;
    }
}