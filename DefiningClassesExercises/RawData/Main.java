package SoftUni.Advanced.DefiningClassesExercises.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCars = Integer.parseInt(scanner.nextLine());
         List<Car> carsList = new ArrayList<>();

        for (int i = 0; i < numCars; i++) {
            //"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure}
            // {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}",
            String[] inputCars = scanner.nextLine().split("\\s+");
            String model = inputCars[0];
            int speed = Integer.parseInt(inputCars[1]);
            int power = Integer.parseInt(inputCars[2]);
            int cargoWeight = Integer.parseInt(inputCars[3]);
            String cargoType = inputCars[4];
            double tire1Pressure = Double.parseDouble(inputCars[5]);
            int tire1Age = Integer.parseInt(inputCars[6]);
            double tire2Pressure = Double.parseDouble(inputCars[7]);
            int tire2Age = Integer.parseInt(inputCars[8]);
            double tire3Pressure = Double.parseDouble(inputCars[9]);
            int tire3Age = Integer.parseInt(inputCars[10]);
            double tire4Pressure = Double.parseDouble(inputCars[11]);
            int tire4Age = Integer.parseInt(inputCars[12]);
           Tire tireOne = new Tire(tire1Pressure,tire1Age);
           Tire tireTwo = new Tire(tire2Pressure,tire2Age);
           Tire tireThree = new Tire(tire3Pressure,tire3Age);
           Tire tireFour = new Tire(tire4Pressure,tire4Age);
           List<Tire> tires = new ArrayList<>();
           tires.add(tireOne);
           tires.add(tireTwo);
           tires.add(tireThree);
           tires.add(tireFour);

           Car car = new Car(model,new Engine(speed,power),new Cargo(cargoWeight,cargoType),tires);
           carsList.add(car);
        }
        String commandToPrint = scanner.nextLine();
        if (commandToPrint.equals("fragile")){
            for (Car car:carsList) {
                if (car.getCargo().getType().equals(commandToPrint)){
                    for (Tire tire:car.getTires()) {
                        if (tire.getPressure()<1){
                            System.out.printf("%s\n",car.getModel());
                            break;
                        }
                    }

                }
            }
        }else if (commandToPrint.equals("flamable")) {
            for (Car car:carsList) {
                if (car.getCargo().getType().equals(commandToPrint)){
                    if (car.getEngine().getPower()>250){
                        System.out.printf("%s\n",car.getModel());
                    }
                }
            }
        }
    }
}
