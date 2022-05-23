package SoftUni.Advanced.StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class P3ALLCAPITALS {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

            String line = reader.readLine();
            while (line!=null){

                writer.write(line.toUpperCase());
                writer.newLine();
                line = reader.readLine();
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
