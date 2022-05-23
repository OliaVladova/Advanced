package SoftUni.Advanced.StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class P5WriteEveryThirdLine {
    public static void main(String[] args) {

        String pathIn = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        try {
            Scanner scan = new Scanner(new FileReader(pathIn));
            PrintWriter outPrint = new PrintWriter(new FileOutputStream(pathOut));
            String nextLine = scan.nextLine();
            int counter = 0;
            while (scan.hasNextLine()){
                counter++;
                if (counter%3==0){
                    outPrint.println(nextLine);
                }
                nextLine = scan.nextLine();
                outPrint.flush();
            }
            scan.close();
            outPrint.close();
        }catch (Exception e){
            System.out.println("Error");
        }

    }
}
