package exam_preparation_I.avatar.controllers;

import exam_preparation_I.avatar.benders.Bender;
import exam_preparation_I.avatar.monuments.Monument;

import java.util.ArrayList;
import java.util.List;

public class Nation {

    private String type;
    private List<Bender> benders;
    private List<Monument> monuments;

    Nation(String type) {
        this.type = type;
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    void addBender(Bender bender){
        this.benders.add(bender);
    }

    void addMonument(Monument monument){
        this.monuments.add(monument);
    }

    double getTotalNationPower(){

        double bendersPower = 0;
        for (Bender bender : benders) {
            bendersPower += bender.getTotalPower();
        }

        long monumentsAffinity = 0;

        for (Monument monument : monuments) {
            monumentsAffinity += monument.getAffinity();
        }
        return bendersPower + (bendersPower / 100) * monumentsAffinity;
    }

    void clear(){
        this.monuments.clear();
        this.benders.clear();
    }

    private String bendersToString(){
        if (this.benders.isEmpty()){
            return "None";
        }
        StringBuilder b = new StringBuilder();
        for (Bender bender : benders) {
            b.append("\n###").append(bender.toString());
        }
        return b.toString();
    }

    private String monumentsToString(){
        if (this.monuments.isEmpty()){
            return "None";
        }
        StringBuilder b = new StringBuilder();
        for (Monument monument : monuments) {
            b.append("\n###").append(monument.toString());
        }
        return b.toString();
    }


    @Override
    public String toString() {
        return  String.format(
                "%s Nation\n" +
                "Benders: " +
                "%s" +
                "\nMonuments: " +
                "%s",
                this.type, bendersToString(), monumentsToString()
        );
    }
}
