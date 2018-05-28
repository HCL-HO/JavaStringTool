package utils;

import java.util.ArrayList;
import java.util.List;

public class Stringer {

    public static String insertText(String source, String insertText, String textOnTheLeft, String textOnTheRight) {
        /*
         *       Insert Text in-between two strings
         * */
        ReadText.Actioner actioner = new ReadText.Actioner() {
            @Override
            public String actOnLine(String line) {
                return insertString(line, insertText, textOnTheLeft, textOnTheRight);
            }
        };
        return ReadText.readText(source, actioner);
    }

    private static String insertString(String line, String insertText, String textOnTheLeft, String textOnTheRight) {
        int index = line.indexOf(textOnTheLeft + textOnTheRight);
        while (index != -1) {
            StringBuilder sb = new StringBuilder(line);
            sb.insert(index + textOnTheLeft.length(), insertText);
            line = sb.toString();
            index = line.indexOf(textOnTheLeft + textOnTheRight, index + 1);
        }
        return line;
    }

    public static String appendLineStart(String source, String appendString) {
        /*
         *               Append String To the Start of Each Line
         *
         * */
        ReadText.Actioner actioner = new ReadText.Actioner() {
            @Override
            public String actOnLine(String line) {
                return appendString + line;
            }
        };
        return ReadText.readText(source, actioner);
    }

    public static String appendLineEnd(String source, String appendString) {
        /*
         *               Append String To the End of Each Line
         *
         * */
        ReadText.Actioner actioner = new ReadText.Actioner() {
            @Override
            public String actOnLine(String line) {
                return line + appendString;
            }
        };
        return ReadText.readText(source, actioner);
    }

}
