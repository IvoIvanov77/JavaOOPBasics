package defining_classes.exercise.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        GoogleAction action = new GoogleAction();

        String line = reader.readLine();

        while (!line.equals("End")){
            action.addPerson(line);
            line = reader.readLine();
        }

        Person person = action.getPerson(reader.readLine());
        System.out.println(person);

    }
}
