package SoftUni.Advanced.DefiningClassesExercises.RawData;

public class Tire {
    private int age;
    private double pressure ;

    public Tire(double pressure,int age) {
        this.age = age;
        this.pressure = pressure;
    }

    public int getAge() {
        return age;
    }

    public double getPressure() {
        return pressure;
    }
}
