package encapsulation.exercise.football_team_generator;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

class Team {
    private String name;
    private Map<String, Player> players;

    Team(String name) {
        this.setName(name);
        this.players = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    void addPlayer(String playerName, double endurance, double sprint,
                   double dribble, double passing, double shooting){

        try{
            Player player = new Player(playerName, endurance, sprint, dribble, passing,shooting);
            this.players.put(player.getName(), player);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }

    void removePlayer(String playerName){
        if(this.players.remove(playerName) == null){
            System.out.println(String.format("Player %s is not in %s team.",
                   playerName, this.name));
        }
    }

    private double getAverageRating(){
        OptionalDouble average = this.players.values().stream()
                .mapToDouble(Player::getAverageStats)
                .average();
        if(average.isPresent()){
            return average.getAsDouble();
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f", this.name, this.getAverageRating());
    }
}
