package SoftUni.Advanced.StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class P7MergeTwoFiles {
    public static void main(String[] args) {

        try {
            File mergedFile = new File("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\mergedFile.txt");
            BufferedReader readerOne = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt"));
            BufferedReader readerTwo = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFile));

            String first = readerOne.readLine();
            while (first!=null){
                writer.write(first);
                writer.newLine();
                first = readerOne.readLine();
            }
            String second = readerTwo.readLine();
            while (second!=null){
                writer.write(second);
                writer.newLine();
                second = readerTwo.readLine();
            }
            writer.close();
            readerOne.close();
            readerTwo.close();
        }catch (Exception ex){
            System.out.println("Error");
        }
    }
}
