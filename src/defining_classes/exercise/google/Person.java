package defining_classes.exercise.google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String birthDate;
    private Company company;
    private Car car;
    private List<Pokemon> pokemon;
    private List<Person> parents;
    private List<Person> children;

    private Person() {
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    Person(String name) {
        this();
        this.name = name;
    }

    private Person(String name, String birthDate) {
        this();
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    private String getCompany() {
        if(this.company == null){
            return "";
        }
        return "\n" + company.toString();
    }

    void setCompany(String companyName, String department, double salary) {
        this.company = new Company(companyName, department, salary);

    }

    private String getCar() {
        if(this.car == null){
            return "";
        }
        return "\n" + car.toString();
    }


    void addPokemon(String pokemonName, String pokemonType){
        this.pokemon.add(new Pokemon(pokemonName, pokemonType));
    }

    void addParent(String parentName, String birthDate){
       this.parents.add(new Person(parentName, birthDate));
    }

    void addChild(String parentName, String birthDate){
        this.children.add(new Person(parentName, birthDate));
    }


    private String getChildren(){
        if(this.children.isEmpty()){
            return "";
        }

        return String.format("\n%s", this.children.toString().replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "\n"));
    }

    private String getParents(){
        if(this.parents.isEmpty()){
            return "";
        }

        return String.format("\n%s", this.parents.toString().replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "\n"));
    }

    private String getPokemon(){
        if(this.pokemon.isEmpty()){
            return "";
        }

        return String.format("\n%s", this.pokemon.toString().replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "\n"));
    }


    void setCar(String carName, int speed) {
        this.car = new Car(carName, speed);
    }

    @Override
    public String toString() {
        if(this.birthDate == null){
            return String.format("%s\n" +
                            "Company:" +
                            "%s\n" +
                            "Car:" +
                            "%s\n" +
                            "Pokemon:" +
                            "%s\n" +
                            "Parents:" +
                            "%s\n" +
                            "Children:" +
                            "%s\n", this.name, this.getCompany(), this.getCar(),
                    this.getPokemon(),
                    this.getParents(),
                    this.getChildren());
        }
        return String.format("%s %s", this.name, this.birthDate);
    }

    private class Company {
        private String name;
        private String department;
        private double salary;

        Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", this.name, this.department, this.salary);
        }
    }

    private class Pokemon {

        private String name;
        private String type;

        Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name, this.type);
        }
    }

    private class Car {

        private String name;
        private int speed;

        public Car(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return String.format("%s %d", this.name, this.speed);
        }
    }
}
