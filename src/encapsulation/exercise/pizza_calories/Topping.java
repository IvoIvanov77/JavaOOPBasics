package encapsulation.exercise.pizza_calories;

class Topping{

    private String type;
    private double calories;
    private double weight;

    Topping(String type, double weight) {
        setTypeAndCalories(type);
        setWeight(weight);
        this.calories = 2 *this.calories *  this.weight;
    }

    private void setTypeAndCalories(String type) {
        switch (type.toLowerCase()){
            case "meat" :{
                this.type = type;
                this.calories = 1.2;
                break;
            }
            case "veggies" :{
                this.type = type;
                this.calories = 0.8;
                break;
            }
            case "cheese" :{
                this.type = type;
                this.calories = 1.1;
                break;
            }
            case "sauce" :{
                this.type = type;
                this.calories = 0.9;
                break;
            }
            default: throw new IllegalArgumentException(String.format(
                    "Cannot place %s on top of your pizza.",
                    type));
        }
    }

    private void setWeight(double weight){
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format(
                    "%s weight should be in the range [1..50].",
                    this.type));
        }
        this.weight = weight;
    }

    double getCalories() {
        return this.calories;
    }
}
