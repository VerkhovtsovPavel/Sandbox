package my.sandbox.compressor;

import static my.sandbox.common.constant.SymbolConstants.CLOSE_SQUARE_BRACKET;
import static my.sandbox.common.constant.SymbolConstants.OPEN_SQUARE_BRACKET;
import static my.sandbox.common.util.StringUtils.repeat;

public class StringCompressor {

    public String unzip(final String compressedString) {
        return internalUnzip(compressedString, 1);
    }

    @SuppressWarnings("PMD.AvoidReassigningLoopVariables")
    private String internalUnzip(final String string, final int duplications) {
        StringBuilder result = new StringBuilder();
        int duplicationValueLength = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != OPEN_SQUARE_BRACKET) {
                result.append(string.charAt(i));
                if (Character.isDigit(string.charAt(i))) {
                    duplicationValueLength++;
                } else {
                    duplicationValueLength = 0;
                }
            } else {
                // Remove group duplication value
                result = new StringBuilder(result.substring(0, result.length() - duplicationValueLength));

                int groupDuplication = Integer.parseInt(string.substring(i - duplicationValueLength, i));
                int groupEnd = calculateGroupEnd(string, i);
                result.append(internalUnzip(string.substring(i + 1, groupEnd), groupDuplication));
                i = groupEnd;
                duplicationValueLength = 0;
            }
        }
        return repeat(result.toString(), duplications);
    }

    private int calculateGroupEnd(final String string, final int i) {
        int level = 1;
        for (int j = i + 1; j < string.length(); j++) {
            char currentChar = string.charAt(j);
            if (currentChar == OPEN_SQUARE_BRACKET) {
                level++;
            } else if (currentChar == CLOSE_SQUARE_BRACKET) {
                level--;
            }
            if (level == 0) {
                return j;
            }
        }
        return string.length();
    }
}
