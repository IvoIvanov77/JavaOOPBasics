package inheritance.exercises.mordor_cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        Mordor mordor = new Mordor();

        for (String s : input) {
            Food food = new Food(s);
            mordor.eat(food);
        }

        System.out.println(mordor);

    }
}
