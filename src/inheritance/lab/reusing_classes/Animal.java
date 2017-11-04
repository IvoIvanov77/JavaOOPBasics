package inheritance.lab.reusing_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Animal {

    protected List<Food> foodEaten = new ArrayList<>();

    final void eat(Food food){
        this.foodEaten.add(food);
    }

    final void eatAll(Food[] foods){
        Collections.addAll(foodEaten, foods);
    }


}
