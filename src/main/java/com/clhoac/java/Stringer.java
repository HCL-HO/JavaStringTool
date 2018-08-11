package com.clhoac.java;

import java.io.File;

public class Stringer {

    /*
     *       Insert Text in-between two strings
     * */
    public static String insertText(String source, String insertText, String textOnTheLeft, String textOnTheRight) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return insertString(line, insertText, textOnTheLeft, textOnTheRight);
            }
        };
        return Processor.proccess(source, actioner);
    }

    /*
     *       Insert Text in-between two strings
     * */
    public static String insertText(File file, String insertText, String textOnTheLeft, String textOnTheRight) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return insertString(line, insertText, textOnTheLeft, textOnTheRight);
            }
        };
        return Processor.proccess(file, actioner);
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
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return appendString + line;
            }
        };
        return Processor.proccess(source, actioner);
    }

    /*
     *               Append String To the Start of Each Line
     *
     * */
    public static String appendLineStart(File source, String appendString) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return appendString + line;
            }
        };
        return Processor.proccess(source, actioner);
    }

    /*
     *               Append String To the End of Each Line
     *
     * */
    public static String appendLineEnd(String source, String appendString) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return line + appendString;
            }
        };
        return Processor.proccess(source, actioner);
    }

    /*
     *               Append String To the End of Each Line
     *
     * */
    public static String appendLineEnd(File source, String appendString) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return line + appendString;
            }
        };
        return Processor.proccess(source, actioner);
    }

    /*
     *               Remove String In Between Two Strings
     *
     * */
    public static String removeBetween(String source, String removeText, String textOnTheLeft, String textOnTheRight) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return doRemoveBetween(line, removeText, textOnTheLeft, textOnTheRight);
            }
        };
        return Processor.proccess(source, actioner);
    }

    private static String doRemoveBetween(String line, String remove, String textOnTheLeft, String textOnTheRight) {
        int leftIndex = line.indexOf(textOnTheLeft);
        while (leftIndex != -1) {
            int rightIndex = line.indexOf(textOnTheRight, leftIndex);
            String betweenText = line.subSequence(leftIndex + textOnTheLeft.length(), rightIndex).toString();
            betweenText = betweenText.replace(remove, "");
            line = line.substring(0, leftIndex + 1) + betweenText + line.substring(rightIndex - 1 + textOnTheRight.length());
            leftIndex = line.indexOf(textOnTheLeft, leftIndex + 1);
        }
        return line;
    }

    public static String removeBetween(File file, String removeText, String textOnTheLeft, String textOnTheRight) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return doRemoveBetween(line, removeText, textOnTheLeft, textOnTheRight);
            }
        };
        return Processor.proccess(file, actioner);
    }

    /*
     *               Remove String In At The Start if Each Line
     *
     * */

    public static String removeLineStart(String source, String removeText) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return line.startsWith(removeText) ? line.substring(removeText.length()) : line;
            }
        };
        return Processor.proccess(source, actioner);
    }

    public static String removeLineStart(File file, String removeText) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return line.startsWith(removeText) ? line.substring(removeText.length()) : line;
            }
        };
        return Processor.proccess(file, actioner);
    }

    /*
     *               Remove String In At The End if Each Line
     *
     * */

    public static String removeLineEnd(String source, String removeText) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return line.endsWith(removeText) ? line.substring(0, line.length() - removeText.length()) : line;
            }
        };
        return Processor.proccess(source, actioner);
    }

    public static String removeLineEnd(File file, String removeText) {
        TextActioner actioner = new TextActioner() {
            @Override
            public String actOnLine(String line) {
                return line.endsWith(removeText) ? line.substring(0, line.length() - removeText.length()) : line;
            }
        };
        return Processor.proccess(file, actioner);
    }

    /*
     *  Custom Action on each line
     * */

    public static String editLines(String source, TextActioner customeActioner) {
        return Processor.proccess(source, customeActioner);
    }

    public static String editLines(File file, TextActioner customActioner) {
        return Processor.proccess(file, customActioner);
    }


}
