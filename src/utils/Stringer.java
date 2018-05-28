package utils;

import java.io.File;

public class Stringer {

    /*
     *       Insert Text in-between two strings
     * */
    public static String insertText(String source, String insertText, String textOnTheLeft, String textOnTheRight) {
        ReadText.Actioner actioner = new ReadText.Actioner() {
            @Override
            public String actOnLine(String line) {
                return insertString(line, insertText, textOnTheLeft, textOnTheRight);
            }
        };
        return ReadText.readText(source, actioner);
    }

    /*
     *       Insert Text in-between two strings
     * */
    public static String insertText(File file, String insertText, String textOnTheLeft, String textOnTheRight) {
        ReadText.Actioner actioner = new ReadText.Actioner() {
            @Override
            public String actOnLine(String line) {
                return insertString(line, insertText, textOnTheLeft, textOnTheRight);
            }
        };
        return ReadText.readFile(file, actioner);
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

    /*
     *               Append String To the Start of Each Line
     *
     * */
    public static String appendLineStart(String source, String appendString) {
        ReadText.Actioner actioner = new ReadText.Actioner() {
            @Override
            public String actOnLine(String line) {
                return appendString + line;
            }
        };
        return ReadText.readText(source, actioner);
    }

    /*
     *               Append String To the Start of Each Line
     *
     * */
    public static String appendLineStart(File source, String appendString) {
        ReadText.Actioner actioner = new ReadText.Actioner() {
            @Override
            public String actOnLine(String line) {
                return appendString + line;
            }
        };
        return ReadText.readFile(source, actioner);
    }

    /*
     *               Append String To the End of Each Line
     *
     * */
    public static String appendLineEnd(String source, String appendString) {
        ReadText.Actioner actioner = new ReadText.Actioner() {
            @Override
            public String actOnLine(String line) {
                return line + appendString;
            }
        };
        return ReadText.readText(source, actioner);
    }

    /*
     *               Append String To the End of Each Line
     *
     * */
    public static String appendLineEnd(File source, String appendString) {
        ReadText.Actioner actioner = new ReadText.Actioner() {
            @Override
            public String actOnLine(String line) {
                return line + appendString;
            }
        };
        return ReadText.readFile(source, actioner);
    }
}
