package defining_classes.exercise.speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            Car car = Car.getInstanceForString(line);
            cars.put(car.getModel(), car);
        }

        String line = reader.readLine();

        while(!"end".equalsIgnoreCase(line)){
            String[] token = line.split("\\s+");
            String model = token[1];
            double distance = Double.parseDouble(token[2]);
            Car car = cars.get(model);
            car.drive(distance);
            line = reader.readLine();
        }

        cars.values().forEach(car -> System.out.printf("%s %.2f %.0f%n",
                car.getModel(), car.getFuelAmount(), car.getTraveledDistance()));

    }
}
