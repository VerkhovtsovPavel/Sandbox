package my.sandbox.maze;

import static my.sandbox.common.constant.SymbolConstants.NEXT_LINE;
import static my.sandbox.common.constant.SymbolConstants.SPACE;

public record Maze(int[][] matrix) {

    public String toString(DisplayInfo info) {
        StringBuilder buffer = new StringBuilder();

        // Build maze line by line
        for (int i = 0; i < matrix[0].length; i++) {
            // Add the flats and tops
            flatsAndTops(i, buffer, info);
            // Add the walls
            walls(i, buffer, info);
        }
        // Add the bottom line
        bottomLine(buffer, info);

        return buffer.toString();
    }

    private void flatsAndTops(int i, StringBuilder buffer, DisplayInfo info) {
        for (int[] line : matrix) {
            buffer
                .append(info.getCorner())
                .append(Direction.N.isBitNotSet(line[i]) ? info.getFlat() : info.getSpaces());
        }
        buffer.append(info.getCorner()).append(NEXT_LINE);
    }

    private void walls(int i, StringBuilder buffer, DisplayInfo info) {
        int marketPlace = info.getWall().length() / 2;
        int currentLevel = 0;
        for (char wallSign : info.getWall().toCharArray()) {
            for (int[] line : matrix) {
                if (Direction.W.isBitNotSet(line[i])) {
                    buffer.append(wallSign);
                } else {
                    buffer.append(SPACE);
                }

                line(line[i], currentLevel, marketPlace, buffer, info);
            }
            buffer.append(wallSign).append(NEXT_LINE);
            currentLevel++;
        }
    }

    private void line(int item, int currentLevel, int marketPlace, StringBuilder buffer, DisplayInfo info) {
        if (Type.START.isBitSet(item)) {
            if (info.isDuplicateSign() || currentLevel == marketPlace) {
                buffer.append(info.getStartSign());
            } else {
                buffer.append(info.getSpaces());
            }
        } else if (Type.FINISH.isBitSet(item)) {
            if (info.isDuplicateSign() || currentLevel == marketPlace) {
                buffer.append(info.getEndSign());
            } else {
                buffer.append(info.getSpaces());
            }
        } else {
            buffer.append(info.getSpaces());
        }
    }

    private void bottomLine(StringBuilder buffer, DisplayInfo info) {
        for (int j = 0; j < matrix.length; j++) {
            buffer.append(info.getCorner()).append(info.getFlat());
        }
        buffer.append(info.getCorner()).append(NEXT_LINE);
    }
}