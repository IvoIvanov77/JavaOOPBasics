package encapsulation.exercise.pizza_calories;

class Dough {

    private Flour flourType;
    private String type;
    private double calories;
    private double weight;

    Dough(String flourType, String type, double weight) {
        this.flourType = new Flour(flourType);
        setTypeAndCalories(type);
        setWeight(weight);
        this.calories = 2 * this.calories * this.flourType.calories * this.weight;
    }


    //    crispy, chewy or homemade
    private void setTypeAndCalories(String type) {
        switch (type.toLowerCase()){
            case "crispy" :{
                this.type = type;
                this.calories = 0.9;
                break;
            }
            case "chewy" :{
                this.type = type;
                this.calories = 1.1;
                break;
            }
            case "homemade" :{
                this.type = type;
                this.calories = 1.0;
                break;
            }
            default: throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight){
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    double getCalories() {
        return calories;
    }

    class Flour {
        String type;
        double calories;

        Flour(String type) {
            this.setType(type);
            this.setCalories();
        }

        void setType(String type) {
            if(type == null || type.trim().isEmpty()
                    || !isValidType(type)){
                throw new IllegalArgumentException("Invalid type of dough.");
            }
            this.type = type;
        }

        void setCalories() {
            switch (this.type.toLowerCase()){
                case "white": this.calories = 1.5;
                break;
                case "wholegrain":this.calories = 1.0;
                break;
            }
        }

        private boolean isValidType(String type){
            return type.equalsIgnoreCase("white")
                    || type.equalsIgnoreCase("wholegrain");
        }

    }
}
