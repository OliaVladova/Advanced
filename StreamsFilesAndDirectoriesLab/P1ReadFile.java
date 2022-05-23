package SoftUni.Advanced.StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class P1ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream input = new FileInputStream(path);
            int byteRead = input.read();
            while (byteRead>=0){
                System.out.printf("%s ", Integer.toBinaryString(byteRead));
                byteRead = input.read();
            }
            input.close();
        }catch (IOException ex){
            System.out.println("Error");
        }


    }
}
