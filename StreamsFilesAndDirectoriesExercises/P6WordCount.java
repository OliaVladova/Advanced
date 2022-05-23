package SoftUni.Advanced.StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P6WordCount {
    public static void main(String[] args) {


        try {
            File newFile = new File("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\results.txt");
            ;
            BufferedReader readerInput = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt"));
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\text.txt"));
            PrintWriter writer = new PrintWriter(newFile);

            String lineInput = readerInput.readLine();
            List<String> input = new ArrayList<>();
            while (lineInput != null) {
                input = Arrays.asList(lineInput.split("\\s+"));
                lineInput = readerInput.readLine();
            }
            HashMap<String, Integer> words = new HashMap<>();
            for (String inputWord : input) {
                words.put(inputWord, 0);
            }
            String line = reader.readLine();
            while (line != null) {
                String[] lineArr = line.split("\\s+");
                for (String element : lineArr) {
                    if (words.containsKey(element)) {
                        words.put(element, words.get(element) + 1);
                    }
                }
                line = reader.readLine();
            }
            words.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> {
                        writer.println(entry.getKey() + " - " + entry.getValue());

                    });
            writer.close();
            reader.close();
            readerInput.close();

        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
