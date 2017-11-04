package inheritance.exercises.animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;

        List<Animal> animals = new ArrayList<>();

        while (true){
            if("Beast!".equals(line = reader.readLine())){
                break;
            }
            String[] input = reader.readLine().split(" ");

            try{
                animals.add(getAnimal(line, input));
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        animals.forEach(System.out::println);
    }

    private static Animal getAnimal(String line, String[] input){
        switch (line){
            case "Animal" : return new Animal(input[0], input[1], input[2]);
            case "Dog" : return new Dog(input[0], input[1], input[2]);
            case "Cat" : return new Cat(input[0], input[1], input[2]);
            case "Frog" : return new Frog(input[0], input[1], input[2]);
            case "Kitten" : return new Kitten(input[0], input[1], input[2]);
            case "Tomcat" : return new Tomcat(input[0], input[1], input[2]);
            default:throw new IllegalArgumentException("Invalid input!");
        }
    }

}
