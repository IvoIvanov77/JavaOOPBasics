package exam_preparation_I.avatar.controllers;

import java.util.*;

public class WarManager {

    private Map<String, Nation> nations;
    private List<String> wars;

    public WarManager() {
        this.nations = new HashMap<>();
        this.nations.put("Air", new Nation("Air"));
        this.nations.put("Earth", new Nation("Earth"));
        this.nations.put("Fire", new Nation("Fire"));
        this.nations.put("Water", new Nation("Water"));
        this.wars = new ArrayList<>();
    }

    public void run(String line){
        String[] input = line.split(" ");

        String command = input[0];
        String type = input[1];
        switch (command){
            case "Bender" :{
                this.nations.get(type).addBender(Factory.getBender(line));
                break;
            }
            case "Monument" :{
                this.nations.get(type).addMonument(Factory.getMonument(line));
                break;
            }
            case "Status" : {
                System.out.println(this.nations.get(type));
                break;
            }
            case "War" : {
                makeWar(type);
                break;
            }

        }
    }

    public void printWars(){
        int counter = 1;
        for (String war : wars) {
            System.out.println(String.format("War %d issued by %s", counter, war));
            counter ++;

        }
    }


    private String getWinner(){
        double bestNationPower = Double.MIN_VALUE;
        String type = null;

        for (Nation nation : nations.values()) {
            if(nation.getTotalNationPower() > bestNationPower){
                bestNationPower = nation.getTotalNationPower();
                type = nation.getType();
            }
        }
        return type;
    }

    private void makeWar(String type){
        String winner = getWinner();
        for (Nation nation : nations.values()) {
            if(!nation.getType().equals(winner)){
                nation.clear();
            }
        }
        this.wars.add(type);
    }
}
