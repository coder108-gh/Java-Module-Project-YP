public class Car {
    String name;
    int speed;

    Car (String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    int getDistance(int hrs) {
        return hrs * this.speed;
    }
}