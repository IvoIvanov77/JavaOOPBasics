package inheritance.exercises.mordor_cruelty_plan;

class Mordor {

    private String mood;
    private int points;

    Mordor() {
        this.points = 0;

    }

    void eat(Food food){
        this.points += food.getPoints();
    }

    private int getPoints(){
        return this.points;
    }

    private String getMood(){
        if(this.getPoints() < -5){
            return "Angry";
        }
        if(this.getPoints() >= - 5 && this.getPoints() < 0){
            return "Sad";
        }
        if(this.getPoints() >= 0 && this.getPoints() < 15){
            return "Happy ";
        }
        return "JavaScript";
    }

    @Override
    public String toString() {
        return String.format("%d\n%s", this.getPoints(), this.getMood());
    }
}
