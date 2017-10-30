package encapsulation.exercise.pizza_calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

//    Pizza Meatless 2
//    Dough Wholegrain Crispy 100
//    Topping Veggies 50
//    Topping Cheese 50
//    END

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaArguments = reader.readLine().split("\\s+");


        try {
            if (pizzaArguments[0].equals("Dough")) {
                Dough dough = new Dough(pizzaArguments[1], pizzaArguments[2],
                        Double.parseDouble(pizzaArguments[3]));
                return;
            }
            Pizza pizza = new Pizza(pizzaArguments[1], Integer.parseInt(pizzaArguments[2]));

            String[] doughArguments = reader.readLine().split("\\s+");

            pizza.setDough(doughArguments[1], doughArguments[2],
                    Double.parseDouble(doughArguments[3]));

            String line;

            for (int i = 0; i < Integer.parseInt(pizzaArguments[2]); i++) {
                if("end".equalsIgnoreCase(line = reader.readLine())){
                    break;
                }

                String[] toppingArguments = line.split("\\s+");
                pizza.addTopping(new Topping(toppingArguments[1],
                        Double.parseDouble(toppingArguments[2])), i);
            }

            System.out.println(pizza);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }
}
