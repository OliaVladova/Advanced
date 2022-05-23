package SoftUni.Advanced.StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;

public class P2SumBytes {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            String line = reader.readLine();
            long number =0;
            while (line!=null){
                for (char symbol:line.toCharArray()) {
                    number+=symbol;
                }
                line = reader.readLine();
            }
            System.out.println(number);
            reader.close();
        }catch (Exception ex){
            System.out.println("Error");
        }
    }
}
