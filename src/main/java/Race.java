import java.util.ArrayList;

public class Race {
    Car leader;
    int duration;
    ArrayList<Car> cars = new ArrayList<>();
    Race(int duration) {
        this.duration = duration;
    }
    void addCar(Car car) {
        cars.add(car);
    }
    void getLeader() {
        int dist = 0;
        int tempDist = 0;

        for(Car car: cars){
            tempDist = car.getDistance(duration);
            if (tempDist>=dist){
                this.leader = car;
                dist = tempDist;
            }
        }
    }
    String getLeaderName() {
        return this.leader.name;
    }


}