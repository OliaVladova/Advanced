package SoftUni.Advanced.DefiningClassesExercises.CarSalesman;

import java.security.PrivateKey;

public class Engine {
    //model, power, displacement, and efficiency
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Power: ").append(this.power).append("\n");
        if(this.displacement == 0){
            sb.append("Displacement: n/a\n");
        }else {
            sb.append("Displacement: ").append(this.displacement).append("\n");
        }
        sb.append("Efficiency: ").append(this.efficiency);
        return sb.toString();
    }
}
