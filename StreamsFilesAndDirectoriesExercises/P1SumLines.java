package SoftUni.Advanced.StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class P1SumLines {
    public static void main(String[] args) {

        String  pathIn = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

            String line = reader.readLine();
            while (line!=null){
                long num = 0;
                for (char symbol : line.toCharArray()) {
                    num+=symbol;
                }
                System.out.println(num);
                line = reader.readLine();
            }
            reader.close();
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
