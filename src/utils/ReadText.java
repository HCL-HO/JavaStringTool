package utils;

import java.io.*;

public class ReadText {

    interface Actioner {
        String actOnLine(String line);
    }

    public static String readFile(File file, Actioner actioner) {
        try {
            Reader reader = new FileReader(file);
            return read(reader, actioner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String readFile(File file) {
        return readFile(file, null);
    }

    public static String readText(String text, Actioner actioner) {
        Reader reader = new StringReader(text);
        return read(reader, actioner);
    }

    private static String read(Reader reader, Actioner actioner) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(
                    reader);
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                if (actioner != null) {
                    sb.append(actioner.actOnLine(line));
                } else {
                    sb.append(line);
                }
                line = br.readLine();
            }
            result = sb.toString();
            br.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return result;
    }

}
