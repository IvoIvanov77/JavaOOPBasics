package polymorphism.exercises.wild_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String line;

        while (true){
            if("end".equalsIgnoreCase(line = reader.readLine())){
                break;
            }
            Animal animal = getAnimal(line);
            Food food = getFood(reader.readLine());
            assert animal != null : "No animal";
            animal.makeSound();
            try{
                animal.eat(food);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
            animals.add(animal);

//            System.out.println(animal);
        }

        animals.forEach(System.out::println);


    }

    private static Animal getAnimal(String line){

        String[] animalData = line.split(" ");
        String animalType = animalData[0];
        String animalName = animalData[1];
        Double animalWeight = Double.parseDouble(animalData[2]);
        String livingRegion = animalData[3];

        switch (animalType){
            case "Cat":{
                String breed = animalData[4];
                return new Cat(animalType, animalName, animalWeight, livingRegion, breed);
            }
            case "Tiger" : {
                return new Tiger(animalType, animalName, animalWeight, livingRegion);
            }
            case "Mouse" : {
                return new Mouse(animalType, animalName, animalWeight, livingRegion);
            }
            case "Zebra" : {
                return new Zebra(animalType, animalName, animalWeight, livingRegion);
            }
            default:return null;
        }

    }

    private static Food getFood(String line){
        String[] foodData = line.split(" ");
        String foodType = foodData[0];
        int foodQuantity = Integer.parseInt(foodData[1]);

        switch (foodType){
            case "Vegetable" : return new Vegetable(foodQuantity);
            case "Meat" : return new Meat(foodQuantity);
            default: return null;
        }

    }


}
