import java.util.ArrayList;

public class Race {
    private Car leader;
    private int duration;
    ArrayList<Car> cars = new ArrayList<>();
    Race(int duration) {
        this.duration = duration;
    }
    void addCar(Car car) {
        cars.add(car);
    }
    String getLeader() {
        int dist = 0;
        int tempDist = 0;

        for(Car car: cars){
            tempDist = car.getDistance(duration);
            if (tempDist>=dist){
                this.leader = car;
                dist = tempDist;
            }
        }
        return this.leader.name;
    }

}