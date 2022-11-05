package maze;

public record DisplayInfo(char corner, String wall, String flat, char startSign, char endSign) {
    static DisplayInfo base = new DisplayInfo('+', "│", "---", '*', 'X');
}
