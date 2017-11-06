package exam_preparation.nfs.models.Races;

import exam_preparation.nfs.models.Cars.Car;

import java.util.Comparator;

/**
 * Created by ivaylo on 11/5/2017.
 */
public class DragRace extends Race{
    public DragRace(Integer length, String route, Integer prizePool) {
        super(length, route, prizePool);
    }


    @Override
    public void setPerformance(Car car) {
        car.setPerformance(car.getEnginePerformance());
    }


}
