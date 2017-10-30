package defining_classes.exercise.car_salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            Engine engine = Engine.getInstance(line);
            engines.put(engine.getModel(), engine);
        }

        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            String line = reader.readLine();
            String[] input = line.split("\\s+");
            String model = input[0];
            Engine engine = engines.get(input[1]);
            Car car;
            switch (input.length){
                case 2:
                    car = new Car(model, engine);
                    break;
                case 3: {
                    try {
                        Integer weight = Integer.parseInt(input[2]);
                        car = new Car(model, engine, weight);
                    }catch(NumberFormatException e) {
                        String color = input[2];
                        car = new Car(model, engine, color);
                    }
                    break;
                }
                default: {
                    Integer weight = Integer.parseInt(input[2]);
                    String color = input[3];
                    car = new Car(model, engine, weight, color);
                    break;
                }

            }
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
