package SoftUni.Advanced.StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class P8NestedFolders {
    public static void main(String[] args) {

        File newFile = new File("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Deque<File> folders = new ArrayDeque<>();
        folders.offer(newFile);
        int count = 0;
        while (!folders.isEmpty()) {
            File currFile = folders.poll();
            File[] files = currFile.listFiles();
            for (File file:files) {
                if (file.isDirectory()){
                    folders.offer(file);
                }
            }
            count++;
            System.out.println(currFile.getName());
        }
        System.out.println(count + " folders");
    }
}
