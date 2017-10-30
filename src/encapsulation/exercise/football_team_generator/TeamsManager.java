package encapsulation.exercise.football_team_generator;

import java.util.HashMap;
import java.util.Map;

class TeamsManager {

    private Map<String, Team> teams;

    TeamsManager() {
        this.teams = new HashMap<>();
    }

    void addTeam(Team team){
        this.teams.put(team.getName(), team);
    }

    Team getTeam(String name){
        Team team = this.teams.get(name);
        if(team == null){
            throw new IllegalArgumentException(String.format(
                    "Team %s does not exist.",name));
        }
        return team;
    }

}
