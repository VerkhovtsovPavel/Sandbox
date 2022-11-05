package maze;

import java.util.function.BiPredicate;

public record Maze(int[][] matrix){

    public String toString(DisplayInfo info) {
        BiPredicate<Integer, Bitable> bitNotSet = (cell, bitable) -> ((cell & bitable.getBit()) == 0);
        String spaces = new String(new char[info.flat().length()]).replace('\0', ' ');
        StringBuilder buffer = new StringBuilder();

        int y = matrix[0].length;
        int x = matrix.length;

        for (int i = 0; i < y; i++) {
            // Add the flats and tops
            for (int j = 0; j < x; j++) {
                buffer.append(info.corner());
                if (bitNotSet.test(matrix[j][i], Direction.N)) {
                    buffer.append(info.flat());
                } else {
                    buffer.append(spaces);
                }
            }
            buffer.append(info.corner()).append("\n");

            // Add the walls
            for (char wallSign : info.wall().toCharArray()) {
                for (int j = 0; j < x; j++) {
                    if (bitNotSet.test(matrix[j][i], Direction.W)) {
                        buffer.append(wallSign);
                    } else {
                        buffer.append(" ");
                    }

                    int signOffset = (spaces.length() - 1) / 2;
                    if(bitNotSet.negate().test(matrix[j][i], Type.START)) {
                        buffer.append(spaces, 0, signOffset)
                                .append(info.startSign())
                                .append(spaces.substring(signOffset+1));
                    } else if(bitNotSet.negate().test(matrix[j][i], Type.FINISH)) {
                        buffer.append(spaces, 0, signOffset)
                                .append(info.endSign())
                                .append(spaces.substring(signOffset+1));
                    } else {
                        buffer.append(spaces);
                    }
                }
                buffer.append(wallSign).append("\n");
            }

        }
        // Add the bottom line
        for (int j = 0; j < x; j++) {
            buffer.append(info.corner()).append(info.flat());
        }
        buffer.append(info.corner()).append("\n");

        return buffer.toString();
    }
}