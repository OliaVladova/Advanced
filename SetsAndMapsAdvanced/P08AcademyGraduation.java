package SoftUni.Advanced.SetsAndMapsAdvanced;

import java.text.DecimalFormat;
import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Double> students = new TreeMap<>();

        for (int i = 0; i < numStudents; i++) {
            String name = scanner.nextLine();
            String[] gradesInput = scanner.nextLine().split("\\s+");
            List<Double> grades = new ArrayList<>();
            for (int j = 0; j < gradesInput.length; j++) {
                double grade = Double.parseDouble(gradesInput[j]);
                grades.add(grade);
            }
            double average = 0;
            for (int j = 0; j < grades.size() ; j++) {
                average+=grades.get(j);
            }
            average/= grades.size();
            students.put(name,average);
        }

        for (Map.Entry<String, Double> student:students.entrySet()) {
            System.out.println(student.getKey() + " is graduated with "+student.getValue());
        }
    }
}
