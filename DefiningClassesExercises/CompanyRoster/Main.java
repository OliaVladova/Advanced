package SoftUni.Advanced.DefiningClassesExercises.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> departmentsMap = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            if (input.length == 4) {
                if (departmentsMap.containsKey(department)) {
                    Employee employee = new Employee(name,salary,position,department);
                    List<Employee> employeeListNew = departmentsMap.get(department);
                    employeeListNew.add(employee);
                    departmentsMap.put(department,employeeListNew);
                }else {
                    Employee employee = new Employee(name,salary,position,department);
                    List<Employee> employeeList = new ArrayList<>();
                    employeeList.add(employee);
                    departmentsMap.put(department,employeeList);
                }
            }else if (input.length ==6){
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                if (departmentsMap.containsKey(department)) {
                    Employee employee = new Employee(name,salary,position,department,email,age);
                    List<Employee> employeeListNew = departmentsMap.get(department);
                    employeeListNew.add(employee);
                    departmentsMap.put(department,employeeListNew);
                }else {
                    Employee employee = new Employee(name,salary,position,department,email,age);
                    List<Employee> employeeList = new ArrayList<>();
                    employeeList.add(employee);
                    departmentsMap.put(department,employeeList);
                }
            }else if (input.length ==5){
                String unknown = input[4];
                if (unknown.contains("@")){
                    String email = unknown;
                    if (departmentsMap.containsKey(department)) {
                        Employee employee = new Employee(name,salary,position,department,email);
                        List<Employee> employeeListNew = departmentsMap.get(department);
                        employeeListNew.add(employee);
                        departmentsMap.put(department,employeeListNew);
                    }else {
                        Employee employee = new Employee(name,salary,position,department,email);
                        List<Employee> employeeList = new ArrayList<>();
                        employeeList.add(employee);
                        departmentsMap.put(department,employeeList);
                    }
                }else {
                    int age = Integer.parseInt(input[4]);
                    if (departmentsMap.containsKey(department)) {
                        Employee employee = new Employee(name,salary,position,department,age);
                        List<Employee> employeeListNew = departmentsMap.get(department);
                        employeeListNew.add(employee);
                        departmentsMap.put(department,employeeListNew);
                    }else {
                        Employee employee = new Employee(name,salary,position,department,age);
                        List<Employee> employeeList = new ArrayList<>();
                        employeeList.add(employee);
                        departmentsMap.put(department,employeeList);
                    }
                }

            }
        }
        String maxAverageSalaryDepartment = departmentsMap.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get()
                .getKey();
        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);

        List<Employee> employeeList = departmentsMap.get(maxAverageSalaryDepartment);
        employeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary()));
        Collections.reverse(employeeList);

        for (Employee employee : employeeList) {
            System.out.printf("%s %.2f %s %d\n",employee.getName(),employee.getSalary(),employee.getEmail(),employee.getAge());
        }
    }
    public static double getAverageSalary(List<Employee> employees) {

        double sum = 0;
        for (Employee employee : employees ) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
