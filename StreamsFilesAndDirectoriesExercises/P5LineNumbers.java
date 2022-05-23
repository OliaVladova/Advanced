package SoftUni.Advanced.StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class P5LineNumbers {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

            int counter = 1;
            String line = reader.readLine();
            while (line!=null){
                String newLine = counter + ". ";
                writer.write(newLine);
                writer.write(line);
                writer.newLine();
                counter++;
                line = reader.readLine();
            }
            reader.close();
            writer.close();
        }catch (Exception ex){
            System.out.println("Error");
        }
    }
}
