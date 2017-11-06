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

    public void start(){
        if(this.participants.isEmpty()){
            System.out.println("Cannot start the race with zero participants");
            return;
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
        StringBuilder b = new StringBuilder(String.format("%s - %s\n", this.route, this.length));
        Car first = this.participants.size() > 0 ? this.participants.get(0) : null;
        Car second = this.participants.size() > 1 ? this.participants.get(1) : null;
        Car third = this.participants.size() > 2 ? this.participants.get(2) : null;
        b.append(String.format("1. %s", getCar(first, this.prizePool * 50 / 100)));
        b.append(String.format("2. %s", getCar(second, this.prizePool * 30 / 100)));
        b.append(String.format("3. %s", getCar(third, this.prizePool * 20 / 100)));
        return b.toString();
    }

    private String getCar(Car car, int prize){
        if(car == null){
            return "";
        }
        return String.format("%s %s %dPP - $%d\n", car.getBrand(), car.getModel(),
                car.getPerformance(), prize);
    }


//    “{route} - {length}
// 1. {brand} {model} {performancePoints}PP - ${moneyWon}
// 2. {brand} {model} {performancePoints}PP - ${moneyWon}
// 3. {brand} {model} {performancePoints}PP - ${moneyWon}”
//            1, 2 and 3 – being the 1st, 2nd and 3rd participants (the winners).
//    If there are LESS than 3 participants, print as much as there are.
//    In case there are NO participants, print “Cannot start the race with zero participants.”,
//    and IGNORE the command.

}
