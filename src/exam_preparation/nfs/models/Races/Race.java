package exam_preparation.nfs.models.Races;

import exam_preparation.nfs.models.Cars.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ivaylo on 11/5/2017.
 */
public abstract class Race {

//    length (int), route (string), a prizePool (int), and participants (Collection of Cars),

    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

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

    public int getLength() {
        return length;
    }

    public int getParticipantsCount() {
        return participants.size();
    }

    public void start(){
        if(this.participants.isEmpty()){
            throw new UnsupportedOperationException("Cannot start the race with zero participants.");
        }
        for (Car car : participants) {
            setPerformance(car);
            car.setInRace(false);
        }
        Comparator<Car> comp = (c1, c2) -> c2.getPerformance() - c1.getPerformance();
        this.participants.sort(comp);
    }

    public abstract void setPerformance(Car car);

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(String.format("%s - %s", this.route, this.length));
        Car first = this.participants.size() > 0 ? this.participants.get(0) : null;
        Car second = this.participants.size() > 1 ? this.participants.get(1) : null;
        Car third = this.participants.size() > 2 ? this.participants.get(2) : null;
        b.append(String.format("\n1. %s", getCar(first, this.prizePool * 50 / 100)));
        if(second != null){
            b.append(String.format("\n2. %s", getCar(second, this.prizePool * 30 / 100)));
        }
        if(third != null){
            b.append(String.format("\n3. %s", getCar(third, this.prizePool * 20 / 100)));
        }
        return b.toString();
    }

    private String getCar(Car car, int prize){
        if(car == null){
            return "";
        }
        return String.format("%s %s %dPP - $%d", car.getBrand(), car.getModel(),
                car.getPerformance(), prize);
    }




}
