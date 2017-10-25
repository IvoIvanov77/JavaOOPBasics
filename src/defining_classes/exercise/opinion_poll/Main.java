package defining_classes.exercise.opinion_poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        int n = Integer.parseInt(reader.readLine());
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            String[] input = line.split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            people[i] = new Person(name, age);

        }

        Arrays.stream(people).filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));



    }
}
