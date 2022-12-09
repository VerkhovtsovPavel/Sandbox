package maze;

public class DisplayInfo {
    public static final DisplayInfo base = new DisplayInfo('+', "│", "---", '0', 'X', false);
    public static final DisplayInfo big = new DisplayInfo('+', "│││", "---___---", '0', 'X', false);
    public static final DisplayInfo heavy = new DisplayInfo('#', "#", "###", '0', 'X', false);

    private final char corner;
    private final String wall;
    private final String flat;
    private final String startSign;
    private final String endSign;
    private final boolean duplicateSign;
    private final String spaces;

    public DisplayInfo(char corner, String wall, String flat, char startSign, char endSign, boolean duplicateSign) {
        this.corner = corner;
        this.wall = wall;
        this.flat = flat;
        this.duplicateSign = duplicateSign;
        this.spaces = new String(new char[flat.length()]).replace('\0', ' ');
        int signOffset = (spaces.length() - 1) / 2;
        this.startSign = spaces.substring(0, signOffset) + startSign + spaces.substring(signOffset + 1);
        this.endSign = spaces.substring(0, signOffset) + endSign + spaces.substring(signOffset + 1);
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
        return startSign;
    }

    public String getEndSign() {
        return endSign;
    }

    public boolean isDuplicateSign() {
        return duplicateSign;
    }

    public String getSpaces() {
        return spaces;
    }
}
