package defining_classes.exercise.raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Company company = new Company();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {

            String line = reader.readLine();
            company.addCar(line);

        }

        company.printCars(reader.readLine());
    }
}
