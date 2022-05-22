package SoftUni.Advanced.DefiningClassesExercises.Google;

public class Car {
    //{carModel} {carSpeed}
    private String carModel;
    private int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return carModel + " " + carSpeed;
    }
}
