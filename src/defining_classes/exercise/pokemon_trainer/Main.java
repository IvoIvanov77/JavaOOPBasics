package defining_classes.exercise.pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Tournament tournament = new Tournament();

        String line = reader.readLine();

        if(line.isEmpty()){
            return;
        }

        while(!line.equalsIgnoreCase("Tournament")){

            tournament.addTrainer(line);

            line = reader.readLine();
        }

        line = reader.readLine();
        while (!line.equalsIgnoreCase("end")){
            tournament.play(line);
            line = reader.readLine();
        }

        tournament.printTrainers();

    }
}
