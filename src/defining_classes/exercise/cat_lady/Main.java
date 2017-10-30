package defining_classes.exercise.cat_lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> cats = new HashMap<>();

        String line = reader.readLine();

        while (!line.equalsIgnoreCase("end")){
            Cat cat = new Cat(line);
            cats.put(cat.getName(), cat);
            line = reader.readLine();
        }

        String name = reader.readLine();

        System.out.println(cats.get(name));
    }
}
