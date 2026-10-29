import java.util.ArrayList;
import java.util.Arrays;
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
    public static int readInt(Scanner scanner, String prompt, String errorMess, int minV, int maxV) {
        String tmp;
        ArrayList<Character> digits = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

        int n = -1;
        boolean isOk;
        while (n==-1) {
            isOk = true;
            tmp = readLine(scanner, prompt);
            for( char ch: tmp.toCharArray()) {
                if(!digits.contains(ch)) {
                    isOk = false;
                    System.out.println(errorMess);
                    break;
                }
            }
            //if (isOk) {
            // поскольку исключения мы не проходили
            // -я упорно "горожу огород" без них.
            // подозреваю, что все далжно решаться через
            // scanner.nextInt() / scanner.hasNextInt()
            // но у меня не хватает мозгов, "как это вывернуть"
            // про parseInt - правда, тоже не проходили, но я подумал,
            // что это "меньший" "выход за границы"
            if (isOk && tmp.length()<4)  {
                n = Integer.parseInt(tmp);
                if(n<minV || n>maxV) {
                    System.out.println(errorMess);
                    n = -1;
                }
            }
            // ну и с Исключением -
            /*try {
                n = Integer.parseInt(tmp);
            } catch (NumberFormatException _) {
                ;
            }*/

            if (isOk || tmp.length()<4)  {
                if(n<minV || n>maxV) {
                    System.out.println(errorMess);
                    n = -1;
                }
            }

        }
        return n;
    }
    public static String readName(Scanner scanner, int carNumber) {
        return readLine(scanner, String.format("— Введите название машины №%d:", carNumber));
    }

    public static int readSpeed(Scanner scanner, int carNumber) {
        int speed = 0;
        String prompt = String.format("— Введите скорость машины №%d:", carNumber);
        return readInt(scanner, prompt, "— Неправильная скорость", 0, 250);
    }

    public static Car readCar(int carNumber, Scanner scanner) {

        String name = readName(scanner, carNumber);
        int speed = readSpeed(scanner, carNumber);
        return  new Car(name, speed);
    }
}
