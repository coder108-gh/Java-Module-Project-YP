import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main {
    public static void main(String[] args)
    {

        int carsCount = 3;
        Race race = new Race(24);

        for (int i = 0; i<carsCount; i++) {
            race.addCar(readCar(i+1));
        }
        race.getLeader();

        System.out.println("Самая быстрая машина: "+race.getLeaderName());

    }
    public static Car readCar(int carNumber) {

        String name;
        int speed;
        Scanner scanner = new Scanner(System.in);
        String templ1 = "— Введите название машины №%d:";
        String templ2 = "— Введите скорость машины №%d:";

        System.out.println();
        System.out.println(String.format(templ1, carNumber));
        name = scanner.next();  // Lamborghini
        System.out.println(String.format(templ2, carNumber));

        while(true){
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("— Неправильная скорость");
                System.out.println(String.format(templ2, carNumber));
                continue;
            }
            speed = scanner.nextInt();

            if (speed<0 || speed>250) {
                System.out.println("— Неправильная скорость");
                System.out.println(String.format(templ2, carNumber));
                continue;
            }
            return new Car(name, speed);
        }
    }
}