package SoftUni.Advanced.DefiningClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String[] carInput = scanner.nextLine().split("\\s+");
            String brand = carInput[0];

            if (carInput.length ==1){
                Car car = new Car(brand);
                cars.add(car);
            }else {
                String model = carInput[1];
                int horsePower = Integer.parseInt(carInput[2]);
                Car car = new Car(brand,model,horsePower);
                cars.add(car);
            }
        }
        for (Car car:cars) {
            System.out.println(Car.carInfo(car));
        }
    }
}
