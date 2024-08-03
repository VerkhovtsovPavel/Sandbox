package my.sandbox.maze;

import static my.sandbox.common.constant.StringConstant.SPACE;
import static my.sandbox.common.constant.SymbolConstants.HASH;
import static my.sandbox.common.constant.SymbolConstants.PLUS;
import static my.sandbox.common.constant.SymbolConstants.X;
import static my.sandbox.common.constant.SymbolConstants.ZERO;


public class DisplayInfo {
    public static final DisplayInfo BASE = new DisplayInfo(PLUS, "│", "---", ZERO, X, false);
    public static final DisplayInfo BIG = new DisplayInfo(PLUS, "│││", "---___---", ZERO, X, false);
    public static final DisplayInfo HEAVY = new DisplayInfo(HASH, "#", "###", ZERO, X, false);

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
        this.spaces = SPACE.repeat(flat.length());

        String signOffset = SPACE.repeat((flat.length() - 1) / 2);
        this.startSigns = signOffset + startSign + signOffset;
        this.endSigns = signOffset + endSign + signOffset;
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
