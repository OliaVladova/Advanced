package SoftUni.Advanced.StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class P4CountCharacterTypes {
    public static void main(String[] args) {

        Set<Character> vowels = new HashSet<>();
        //•	a, e, i, o, u
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        Set<Character> punctuation = new HashSet<>();
        punctuation.add('!');
        punctuation.add(',');
        punctuation.add('.');
        punctuation.add('?');

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ACER\\Desktop\\Advanced\\Streams, Files And Directories\\exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));

            String line = reader.readLine();
            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;
            while (line != null) {
                for (Character symbol : line.toCharArray()) {
                    if (vowels.contains(symbol)) {
                        vowelsCount++;
                    }else if (punctuation.contains(symbol)){
                        punctuationCount++;
                    }else if (symbol!= 32){
                        consonantsCount++;
                    }
                }
                line = reader.readLine();
            }
            String textFisrt = "Vowels: " + vowelsCount;
            String textSecond = "Consonants: " + consonantsCount;
            String textThird = "Punctuation: " + punctuationCount;
            writer.write(textFisrt);
            writer.newLine();
            writer.write(textSecond);
            writer.newLine();
            writer.write(textThird);
            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
