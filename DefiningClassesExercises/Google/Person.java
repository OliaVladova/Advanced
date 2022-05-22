package SoftUni.Advanced.DefiningClassesExercises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    //only 1 company and car, but can have multiple parents, children, and pokemons.
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person(Company company, Car car, List<Parents> parents, List<Children> children, List<Pokemon> pokemons) {
        this.company = company;
        this.car = car;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public Person(){
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company).append("\n");
        }
        builder.append("Car:").append("\n");
        if (car != null) {
            builder.append(car).append("\n");
        }

        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemons) {
            builder.append(pokemon).append("\n");
        }

        builder.append("Parents:").append("\n");
        for (Parents parent : parents) {
            builder.append(parent).append("\n");
        }

        builder.append("Children:").append("\n");
        for (Children child : children) {
            builder.append(child).append("\n");
        }

        return builder.toString();
    }
}
