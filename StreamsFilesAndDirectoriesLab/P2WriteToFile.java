package SoftUni.Advanced.StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P2WriteToFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String toWritePath = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        Set<Character> forbidden = new HashSet<>();
        Collections.addAll(forbidden, '.', ',', '!', '?');

        try {
            FileInputStream in = new FileInputStream(path);
            FileOutputStream out = new FileOutputStream(toWritePath);
            int toWrite = in.read();
            while (toWrite >= 0) {
                char symbol = (char) toWrite;
                if (!forbidden.contains(symbol)) {
                    out.write(symbol);
                }
                toWrite = in.read();
            }
            in.close();
            out.close();

        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
}
