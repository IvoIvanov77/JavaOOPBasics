package encapsulation.exercise.football_team_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        TeamsManager manager = new TeamsManager();

        while (true){
            if("end".equalsIgnoreCase(line = reader.readLine())){
                break;
            }

            try{
                String[] input = line.split(";");
                String command = input[0];
                String teamName = input[1];

                switch (command){
                    case "Team" :
                        manager.addTeam(new Team(teamName));
                        break;
                    case "Add":{
                        String playerName = input[2];
                        Team team = manager.getTeam(teamName);
                        team.addPlayer(playerName,
                                Double.parseDouble(input[3]),
                                Double.parseDouble(input[4]),
                                Double.parseDouble(input[5]),
                                Double.parseDouble(input[6]),
                                Double.parseDouble(input[7])

                        );
                        break;
                    }
                    case "Remove" :{
                        String playerName = input[2];
                        Team team = manager.getTeam(teamName);
                        team.removePlayer(playerName);
                        break;
                    }
                    case "Rating" :{
                        Team team = manager.getTeam(teamName);
                        System.out.println(team);
                    }
                }

            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }


        }


    }
}
