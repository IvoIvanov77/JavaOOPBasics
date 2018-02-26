package exam_preparation.nfs.models.Races;

import exam_preparation.nfs.models.Cars.Car;

public class CircuitRace extends Race {

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    public void setPerformance(Car car) {

    }
}
