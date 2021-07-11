
import java.util.Map;

public abstract class Template {
    private static final String START_FLAG = "${";
    private static final String END_FLAG = "}";
    /**
     * Convert the characters of a particular pattern in the string to the corresponding values ​​in the map
     *
     * @param s
     * string to be converted
     * @param map
     * The set of key-value pairs required for the conversion
     * @return converted string
     */
    public static String convert(String s, Map<String, String> map) {
        StringBuilder ret = new StringBuilder(s.length());
        int cursor = 0;
        for (int start, end; (start = s.indexOf(START_FLAG, cursor)) != -1
                && (end = s.indexOf(END_FLAG, start)) != -1;) {
            ret.append(s.substring(cursor, start)).append(
                    map.get(s.substring(start + START_FLAG.length(), end)));
            cursor = end + END_FLAG.length();
        }
        ret.append(s.substring(cursor, s.length()));
        return ret.toString();
    }
}