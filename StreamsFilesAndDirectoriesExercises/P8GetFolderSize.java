package SoftUni.Advanced.StreamsFilesAndDirectoriesExercises;

import java.io.File;

public class P8GetFolderSize {
    public static void main(String[] args) {


            String path = "C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
            File folder = new File(path);
            File[] allFiles = folder.listFiles();

            int folderSize = 0;
            for (File file : allFiles) {
                folderSize += file.length();
            }

            System.out.println("Folder size: " + folderSize);
    }
}
