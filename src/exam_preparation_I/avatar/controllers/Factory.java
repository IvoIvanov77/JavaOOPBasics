package exam_preparation_I.avatar.controllers;

import exam_preparation_I.avatar.benders.*;
import exam_preparation_I.avatar.monuments.*;

class Factory {

    static Bender getBender(String line){
//        •	Bender {type} {name} {power} {secondaryParameter}
        String[] input = line.split(" ");
        String type = input[1];
        String name = input[2];
        int power = Integer.parseInt(input[3]);
        double secondaryParameter = Double.parseDouble(input[4]);

        switch (type){
            case "Air" : return new AirBender(name, power, secondaryParameter);
            case "Earth" : return new EarthBender(name, power, secondaryParameter);
            case "Fire" : return new FireBender(name, power, secondaryParameter);
            case "Water" : return new WaterBender(name, power, secondaryParameter);
        }
        return null;
    }

    static Monument getMonument(String line){
//        •	Monument {type} {name} {affinity}
        String[] input = line.split(" ");
        String type = input[1];
        String name = input[2];
        int affinity = Integer.parseInt(input[3]);

        switch (type){
            case "Air" : return new AirMonument(name, affinity);
            case "Earth" : return new EarthMonument(name, affinity);
            case "Fire" : return new FireMonument(name, affinity) ;
            case "Water" : return new WaterMonument(name, affinity);
        }
        return null;
    }
}
