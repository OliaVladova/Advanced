package SoftUni.Advanced.StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class P6SortLines {
    public static void main(String[] args) {

        String pathIn = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt";

        try{
            List<String> lines = Files.readAllLines(Path.of("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));
            Collections.sort(lines);
            PrintWriter writer = new PrintWriter(new FileOutputStream(pathOut));
            for (int i = 0; i < lines.size() ; i++) {
                writer.println(lines.get(i));
            }
            writer.close();
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
