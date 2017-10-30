package encapsulation.exercise.football_team_generator;

class Player {

    private String name;
    private Stats stats;

    Player(String name, double endurance, double sprint, double dribble,
           double passing, double shooting) {
        this.setName(name);
        this.stats = new Stats(endurance, sprint, dribble, passing, shooting);
    }

    double getAverageStats() {
        return stats.getAverageStats();
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

    @Override
    public String toString() {
        return this.name;
    }

    class Stats {
//        endurance, sprint, dribble, passing and shooting
        private double endurance;
        private double sprint;
        private double dribble;
        private double passing;
        private double shooting;

        Stats(double endurance, double sprint, double dribble, double passing, double shooting) {
            this.setEndurance(endurance);
            this.setSprint(sprint);
            this.setDribble(dribble);
            this.setPassing(passing);
            this.setShooting(shooting);
        }

        double getEndurance() {
            return endurance;
        }

        private void setEndurance(double endurance) {
            if(!isValidStats(endurance)){
                throw new IllegalArgumentException(getErrorMessage("Endurance"));
            }
            this.endurance = endurance;
        }

        double getSprint() {
            return sprint;
        }

        private void setSprint(double sprint) {
            if(!isValidStats(sprint)){
                throw new IllegalArgumentException(getErrorMessage("Sprint"));
            }
            this.sprint = sprint;
        }

        double getDribble() {
            return dribble;
        }

        private void setDribble(double dribble) {
            if(!isValidStats(dribble)){
                throw new IllegalArgumentException(getErrorMessage("Dribble"));
            }
            this.dribble = dribble;
        }

        double getPassing() {
            return passing;
        }

        private void setPassing(double passing) {
            if(!isValidStats(passing)){
                throw new IllegalArgumentException(getErrorMessage("Passing"));
            }
            this.passing = passing;
        }

        double getShooting() {
            return shooting;
        }

        private void setShooting(double shooting) {
            if(!isValidStats(shooting)){
                throw new IllegalArgumentException(getErrorMessage("shooting"));
            }
            this.shooting = shooting;
        }

        double getAverageStats() {
            return (this.getDribble() + this.getShooting() + this.getEndurance() +
                    this.getPassing() + this.getSprint()) / 5.0;
        }


        private boolean isValidStats(double stats){
            return stats >= 0 && stats <= 100;
        }

        private String getErrorMessage(String stats){
            return String.format("%s should be between 0 and 100.", stats);
        }
    }
}
