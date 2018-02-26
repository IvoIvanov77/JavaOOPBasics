package exam_preparation.nfs.models.Races;

import exam_preparation.nfs.models.Cars.Car;

public class TimeLimitRace extends Race{

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    @Override
    public void setPerformance(Car car) {
        car.setPerformance(this.getLength() * car.getHorsepower() / 100 * car.getAcceleration());
    }

    @Override
    public void addCar(Car car) {
        if(this.getParticipantsCount() < 1){
            super.addCar(car);
        }
    }

//    private String getTime(){
//        Car car = this.
//    }
}
