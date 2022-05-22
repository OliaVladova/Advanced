package SoftUni.Advanced.DefiningClassesExercises.SpeedRacing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < numCars; i++) {
            String[] inputCars = scanner.nextLine().split("\\s+");
            //"{Model} {FuelAmount} {FuelCostFor1km}

            String model = inputCars[0];
            double FuelAmount = Double.parseDouble(inputCars[1]);
            double FuelCostFor1km = Double.parseDouble(inputCars[2]);
            Car car = new Car(model, FuelAmount, FuelCostFor1km);
            cars.put(model, car);

        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] carInput = input.split("\\s+");
            String CarModel = carInput[1];
            int amountOfKm = Integer.parseInt(carInput[2]);
            if (cars.containsKey(CarModel)) {
                Car car = cars.get(CarModel);
                boolean canMove = car.canMove(amountOfKm, car);
                if (canMove) {
                    double newFuel = car.getFuelAmount() - car.getCostForKilometer() * amountOfKm;
                    car.setFuelAmount(newFuel);
                    int distance = car.getDistance() + amountOfKm;
                    car.setDistance(distance);
                } else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
            input = scanner.nextLine();
        }
        //Model} {fuelAmount} {distanceTraveled
        for (Map.Entry<String, Car> car : cars.entrySet()) {
            System.out.printf("%s %.2f %d\n",car.getKey(),car.getValue().getFuelAmount(),car.getValue().getDistance());
        }
    }
}
