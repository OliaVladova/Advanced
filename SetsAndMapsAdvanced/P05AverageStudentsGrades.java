package SoftUni.Advanced.SetsAndMapsAdvanced;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> students = new TreeMap<>();


        for (int i = 0; i < numStudents; i++) {
            String[] studentInfo = scanner.nextLine().split(" ");
            String name = studentInfo[0];

            double grade = Double.parseDouble(studentInfo[1]);
            if (students.containsKey(name)) {
                List<Double> grades = new ArrayList<>();
                grades = students.get(name);
                grades.add(grade);
                students.put(name, grades);
            } else {
                List<Double> grades = new ArrayList<>();
                grades.add(grade);
                students.put(name, grades);
            }
        }
        students.forEach((student, grades) -> {
            System.out.printf("%s -> ", student);
            grades.forEach(grade -> System.out.printf("%.2f ", grade));
            double averageGrade = 0;
            for (double num : grades) {
                averageGrade += num;
            }
            averageGrade /= (grades.size());
            System.out.printf("(avg: %.2f)\n", averageGrade);
        });
    }
}

