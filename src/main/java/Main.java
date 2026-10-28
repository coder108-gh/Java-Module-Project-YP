import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        int carsCount = 3;
        Race race = new Race(24);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i<carsCount; i++) {
            race.addCar(readCar(i+1, scanner));
        }
        scanner.close();

        System.out.println("Самая быстрая машина: "+race.getLeader());

    }

    public static String readLine(Scanner scanner, String prompt) {
        String line = "";
        while (line.isBlank()) {
            System.out.println(prompt);
            line = scanner.nextLine();
        }
        return line;
    }
    public static String readName(Scanner scanner, int carNumber) {
        return readLine(scanner, String.format("— Введите название машины №%d:", carNumber));
    }

    public static void printInvalidSpeed(String prompt) {
        System.out.println("— Неправильная скорость");
        System.out.println(prompt);

    }
    public static int readSpeed(Scanner scanner, int carNumber) {
        int speed = 0;
        String prompt = String.format("— Введите скорость машины №%d:", carNumber);
        System.out.println(prompt);
        while(true){
            if (scanner.hasNextInt()) {
                speed = scanner.nextInt();
                if (speed>=0 && speed<=250) {
                    if (scanner.hasNextLine()){
                        scanner.nextLine();
                    }
                    return speed;
                }
                else {
                    printInvalidSpeed(prompt);
                }
            }
            else {
                scanner.nextLine();
                printInvalidSpeed(prompt);
            }
        }

    }

    public static Car readCar(int carNumber, Scanner scanner) {

        String name = readName(scanner, carNumber);
        int speed = readSpeed(scanner, carNumber);
        return  new Car(name, speed);
    }
}
