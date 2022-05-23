package SoftUni.Advanced.StreamsFilesAndDirectoriesLab;

import java.io.File;

public class P7ListFiles {
    public static void main(String[] args) {

        File newFile = new File("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (newFile.exists()){
            if (newFile.isDirectory()){
                File[] files = newFile.listFiles();
                for (File file:files) {
                    if (!file.isDirectory()){
                        System.out.printf("%s: [%s]\n",file.getName(),file.length());
                    }
                }
            }
        }
    }
}
