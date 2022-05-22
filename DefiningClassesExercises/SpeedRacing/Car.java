package SoftUni.Advanced.DefiningClassesExercises.SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double costForKilometer;
    private int distance = 0;

    public Car(String model, double fuelAmount, double costForKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costForKilometer = costForKilometer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getCostForKilometer() {
        return costForKilometer;
    }

    public void setCostForKilometer(double costForKilometer) {
        this.costForKilometer = costForKilometer;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean canMove(int distance, Car car) {
        double neededFuel = distance * car.getCostForKilometer();
        if (car.fuelAmount - neededFuel >= 0) {
            return true;
        }
        return false;
    }
}
