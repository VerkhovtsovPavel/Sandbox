package my.sandbox.compressor;

import static my.sandbox.common.util.StringUtils.repeat;

//TODO Add more then one digit duplication
public class StringCompressor {

    public String unzip(final String compressedString) {
        return internalUnzip(compressedString, 1);
    }

    private String internalUnzip(final String string, final int duplications) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '[') {
                result.append(string.charAt(i));
            } else {
                result = new StringBuilder(result.substring(0, result.length() - 1)); // Remove group duplication value
                int groupDuplication = Integer.parseInt("" + string.charAt(i - 1));
                int groupEnd = calculateGroupEnd(string, i);
                result.append(internalUnzip(string.substring(i + 1, groupEnd), groupDuplication));
                i = groupEnd;
            }
        }
        return repeat(result.toString(), duplications);
    }

    private int calculateGroupEnd(final String string, final int i) {
        int level = 1;
        for (int j = i + 1; j < string.length(); j++) {
            if (string.charAt(j) == '[') {
                level++;
            } else if (string.charAt(j) == ']') {
                level--;
            }
            if (level == 0) {
                return j;
            }
        }
        return string.length();
    }
}
