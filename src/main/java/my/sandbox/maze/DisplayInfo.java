package my.sandbox.maze;

public class DisplayInfo {
    public static final DisplayInfo BASE = new DisplayInfo('+', "│", "---", '0', 'X', false);
    public static final DisplayInfo BIG = new DisplayInfo('+', "│││", "---___---", '0', 'X', false);
    public static final DisplayInfo HEAVY = new DisplayInfo('#', "#", "###", '0', 'X', false);

    private final char corner;
    private final String wall;
    private final String flat;
    private final String startSigns;
    private final String endSigns;
    private final boolean duplicateSign;
    private final String spaces;

    public DisplayInfo(
            final char cornerSign,
            final String wallSigns,
            final String flatSigns,
            final char startSign,
            final char endSign,
            final boolean isDuplicateSign) {
        this.corner = cornerSign;
        this.wall = wallSigns;
        this.flat = flatSigns;
        this.duplicateSign = isDuplicateSign;
        this.spaces = new String(new char[flat.length()]).replace('\0', ' ');
        int signOffset = (spaces.length() - 1) / 2;
        this.startSigns = spaces.substring(0, signOffset) + startSign + spaces.substring(signOffset + 1);
        this.endSigns = spaces.substring(0, signOffset) + endSign + spaces.substring(signOffset + 1);
    }

    public char getCorner() {
        return corner;
    }

    public String getWall() {
        return wall;
    }

    public String getFlat() {
        return flat;
    }

    public String getStartSign() {
        return startSigns;
    }

    public String getEndSign() {
        return endSigns;
    }

    public boolean isDuplicateSign() {
        return duplicateSign;
    }

    public String getSpaces() {
        return spaces;
    }
}
