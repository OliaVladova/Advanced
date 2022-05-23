package SoftUni.Advanced.StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P3CopyBytes {
    public static void main(String[] args) {

        String pathIn = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        try{
            FileInputStream in = new FileInputStream(pathIn);
            FileOutputStream out = new FileOutputStream(pathOut);
            int byteRead = in.read();

            while (byteRead>=0){
                if (byteRead==32 ||byteRead==10){
                    out.write(byteRead);
                }else {
                    String num = String.valueOf(byteRead);
                    for (int i = 0; i < num.length(); i++) {
                        out.write(num.charAt(i));
                    }

                }
                byteRead = in.read();
            }
            in.close();
            out.close();
        }catch (IOException ex){
            System.out.println("Error");
        }
    }
}
