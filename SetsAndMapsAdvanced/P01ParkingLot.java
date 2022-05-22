package SoftUni.Advanced.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingList = new LinkedHashSet<>();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] carsInput = input.split(", ");
            switch (carsInput[0]) {
                case "IN":
                    String car = carsInput[1];
                    parkingList.add(car);
                    break;
                case "OUT":
                    String carToRemove = carsInput[1];
                    parkingList.remove(carToRemove);
                    break;
            }
            input = scanner.nextLine();
        }
        if (parkingList.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car:parkingList) {
                System.out.println(car);
            }
        }
    }
}
