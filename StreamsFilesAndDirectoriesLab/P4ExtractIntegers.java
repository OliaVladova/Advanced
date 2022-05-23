package SoftUni.Advanced.StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class P4ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        FileOutputStream fileOutputStream = new FileOutputStream(pathOut);
        PrintWriter myFileOutput = new PrintWriter(fileOutputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int myNumber = scanner.nextInt();
//                System.out.println(myNumber);
                myFileOutput.println(myNumber);
            }
            scanner.next();
        }
        myFileOutput.close();
    }


}
