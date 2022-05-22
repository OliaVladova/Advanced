package SoftUni.Advanced.DefiningClassesExercises.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int engineLines = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < engineLines; i++) {
            String[] engineInput = scanner.nextLine().split("\\s+");
            String model = engineInput[0];
            int power = Integer.parseInt(engineInput[1]);
            Engine engine = null;
            if (engineInput.length == 4) {
                //{Model} {Power} {Displacement} {Efficiency}".
                int displacement = Integer.parseInt(engineInput[2]);
                String efficiency = engineInput[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (engineInput.length == 3) {
                try {
                    int displacement = Integer.parseInt(engineInput[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException ex) {
                    String efficiency = engineInput[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else {
                engine = new Engine(model, power);
            }
            engineList.add(engine);
        }
        int carsNum = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < carsNum; i++) {
            //"{Model} {Engine} {Weight} {Color}
            String[] carInput = scanner.nextLine().split("\\s+");
            String model = carInput[0];
            String engine = carInput[1];
            Car car = null;
            if (carInput.length == 4) {
                int weight = Integer.parseInt(carInput[2]);
                String color = carInput[3];
                car = new Car(model, engine, weight, color);
            } else if (carInput.length == 3) {
                try {
                    int weight = Integer.parseInt(carInput[2]);
                    car = new Car(model, engine, weight);
                } catch (NumberFormatException ex) {
                    String color = carInput[2];
                    car = new Car(model, engine, color);

                }
            } else if (carInput.length == 2) {
                car = new Car(model, engine);

            }
            carsList.add(car);
        }
        for (Car car : carsList) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine() + ":");
            engineList.forEach(engine -> {
                if (engine.getModel().equals(car.getEngine())) {
                    System.out.println(engine.toString());
                }
            });
            if (car.getWeight() == 0) {
                System.out.println("Weight: n/a");
            } else {
                System.out.println("Weight: " + car.getWeight());
            }
            System.out.println("Color: " + car.getColor());
        }
    }
}
