package exam_preparation_III.paw_inc;

import exam_preparation_III.paw_inc.animals.Animal;
import exam_preparation_III.paw_inc.animals.Cat;
import exam_preparation_III.paw_inc.animals.Dog;
import exam_preparation_III.paw_inc.centers.AdoptionCenter;
import exam_preparation_III.paw_inc.centers.CastrationCenter;
import exam_preparation_III.paw_inc.centers.CleansingCenter;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {

    private Map<String, AdoptionCenter> adoptionCenters;
    private Map<String, CleansingCenter> cleansingCenters;
    private Map<String, CastrationCenter> castrationCenters;
    private Set<Animal> cleansedAnimals;
    private Set<Animal> adoptedAnimals;
    private Set<Animal> castratedAnimals;
    private int animalCounter;

    public AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.castrationCenters = new HashMap<>();
        this.cleansedAnimals = new HashSet<>();
        this.adoptedAnimals = new HashSet<>();
        this.castratedAnimals = new HashSet<>();
        this.animalCounter = 0;
    }

    public void run(String line){

        String[] input = line.split("\\s+\\|\\s+");
        String command = input[0];
        String name = null;
        if(input.length > 1){
            name = input[1];
        }
        switch (command){
            case "RegisterAdoptionCenter" : registerAdoptionCenter(name);
                break;
            case "RegisterCleansingCenter" : registerCleansingCenter(name);
                break;
            case "RegisterCastrationCenter" : registerCastrationCenter(name);
                break;
            case "RegisterDog" : registerDog(name, Integer.parseInt(input[2]),
                    Integer.parseInt(input[3]), input[4]);
                break;
            case "RegisterCat" : registerCat(name, Integer.parseInt(input[2]),
                    Integer.parseInt(input[3]), input[4]);
                break;
            case "SendForCleansing" : sendForCleansing(name, input[2]);
                break;
            case "SendForCastration" : sendForCastrating(name, input[2]);
                break;
            case "Cleanse" : cleanse(name);
                break;
            case "Castrate" : castrate(name);
                break;
            case "Adopt" : adopt(name);
                break;
            case "CastrationStatistics" :
                System.out.println(getCastrationStatistics());
                break;

        }

    }

    public void registerCleansingCenter(String name){

        this.cleansingCenters.put(name, Factory.createCleansingCenter(name));
    }

    public void registerAdoptionCenter(String name){

        this.adoptionCenters.put(name, Factory.createAdoptionCenter(name));
    }

    public void registerCastrationCenter(String name){

        this.castrationCenters.put(name, new CastrationCenter(name));
    }


	public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName){
        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
        adoptionCenter.registerAnimal(new Dog(name, age,  adoptionCenterName, learnedCommands));

    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName){
        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
        adoptionCenter.registerAnimal(new Cat(name, age,  adoptionCenterName, intelligenceCoefficient));

    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName){
        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        Collection<Animal> dirtyAnimals = adoptionCenter.sendingAnimalsForCleansing();
        cleansingCenter.receiveAnimalsForCleaning(dirtyAnimals);
        this.animalCounter += dirtyAnimals.size();
    }

    public void sendForCastrating(String adoptionCenterName, String castrationCenterName){
        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
        CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);
        Collection<Animal> dirtyAnimals = adoptionCenter.sendingAnimalsForCleansing();
        castrationCenter.receiveAnimalsForCastrating(dirtyAnimals);
    }

    public void cleanse(String cleansingCenterName){
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        Collection<Animal> animals = cleansingCenter.sendCleanedAnimals();
        for (AdoptionCenter adoptionCenter : adoptionCenters.values()) {
            adoptionCenter.receiveCleanedAnimals(animals);
        }
        this.cleansedAnimals.addAll(animals);
    }

    public void castrate(String castrationCenterName){
        CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);
        Collection<Animal> animals = castrationCenter.sendCastratedAnimals();
        for (AdoptionCenter adoptionCenter : adoptionCenters.values()) {
            adoptionCenter.receiveCastratedAnimals(animals);
        }
        this.castratedAnimals.addAll(animals);
    }

    public void adopt(String adoptionCenterName){
        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
        this.adoptedAnimals.addAll(adoptionCenter.adoptAnimals());
    }

    public void printStatistics(){
        System.out.println(getStatistics());
    }

    private String getStatistics(){
        return String.format(
                "Paw Incorporative Regular Statistics\n" +
                        "Adoption Centers: %d\n" +
                        "Cleansing Centers: %d\n" +
                        "Adopted Animals: %s\n" +
                        "Cleansed Animals: %s\n" +
                        "Animals Awaiting Adoption: %d\n" +
                        "Animals Awaiting Cleansing: %d",
                this.adoptionCenters.size(),
                this.cleansingCenters.size(),
                getAdoptedAnimals(),
                getCleansedAnimals(),
                getAnimalsAwaitingAdoption(),
                getAnimalsAwaitingCleansing()
        );
    }

    private String getCastrationStatistics(){
        return String.format(
                "Paw Inc. Regular Castration Statistics\n" +
                        "Castration Centers: %d\n" +
                        "Castrated Animals: %s",
                this.castrationCenters.size(),
                this.getCastratedAnimals()
        );
    }

    private String getAdoptedAnimals(){
        if(this.adoptedAnimals.isEmpty()){
            return "None";
        }
        List<String> result = this.adoptedAnimals.stream()
                .map(Animal::toString)
                .sorted()
                .collect(Collectors.toList());
        return String.join(", ", result);
    }

    private String getCleansedAnimals(){
        if(this.cleansedAnimals.isEmpty()){
            return "None";
        }
        List<String> result = this.cleansedAnimals.stream()
                .map(Animal::toString)
                .sorted()
                .collect(Collectors.toList());
        return String.join(", ", result);
    }

    private String getCastratedAnimals(){
        if(this.castratedAnimals.isEmpty()){
            return "None";
        }
        List<String> result = this.castratedAnimals.stream()
                .map(Animal::toString)
                .sorted()
                .collect(Collectors.toList());
        return String.join(", ", result);
    }

    private int getAnimalsAwaitingAdoption(){
        return this.cleansedAnimals.size() - this.adoptedAnimals.size();
    }
    private int getAnimalsAwaitingCleansing(){
        return this.animalCounter - this.cleansedAnimals.size();
    }


}
