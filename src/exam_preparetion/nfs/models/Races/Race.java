package exam_preparetion.nfs.models.Races;

import exam_preparetion.nfs.models.Cars.Car;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ivaylo on 11/5/2017.
 */
public abstract class Race {

//    length (int), route (string), a prizePool (int), and participants (Collection of Cars),

    int length;
    String route;
    int prizePool;
    Collection<Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public void addCar(Car car) {
        car.setInRace(true);
        this.participants.add(car);
    }
}
