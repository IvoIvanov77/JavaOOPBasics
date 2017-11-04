package inheritance.exercises.mordor_cruelty_plan;

class Food {

    private String name;
    private int points;


    Food(String name) {
        this.name = name;
    }

    int getPoints() {
        switch (this.name.toLowerCase()){
            case "cram" : return 2;
            case "lembas" : return 3;
            case "apple" : return 1;
            case "melon" : return 1;
            case "honeycake" : return 5;
            case "mushrooms" : return -10;
            default: return -1;
        }
    }
}
