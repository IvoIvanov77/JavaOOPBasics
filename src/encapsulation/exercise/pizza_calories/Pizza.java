package encapsulation.exercise.pizza_calories;

import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private Topping[] toppingList;
    private double totalCalories;

    Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppingList(numberOfToppings);
        this.totalCalories = 0;

    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty() || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    void setDough(String flourType, String type, double weight) {
        this.dough = new Dough(flourType, type, weight);
        this.totalCalories += this.dough.getCalories();
    }

    private void setToppingList(int numberOfToppings) {
        if(numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingList = new Topping[numberOfToppings];
    }

    void addTopping(Topping topping, int index){
        this.toppingList[index] = topping;
        this.totalCalories += topping.getCalories();

    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.totalCalories);
    }
}
