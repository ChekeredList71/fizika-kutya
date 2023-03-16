import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        Person p1 = new Person(0);
        Person p2 = new Person(0);
        double distance = 0;
        boolean notDoneChoosing = true;
        while (notDoneChoosing) {
            try {
                System.out.print("1. személy sebessége: ");
                p1 = new Person(scn.nextDouble());

                System.out.print("2. személy sebessége: ");
                p2 = new Person(scn.nextDouble());
                System.out.print("Személyek távolsága: ");
                distance = scn.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("A beírt adat nem szám. Csak egész vagy tizedes számokat használhat.");

            } finally {
                notDoneChoosing = false;
            }
        }

        double stepTime;
        double previousDistance = 0;

        while (distance > 0) {
            try {
                System.out.print("Következő pillanatig eltelt idő: ");
                stepTime = scn.nextDouble();
                previousDistance = distance;
                distance = distance - p1.speed * stepTime - p2.speed * stepTime;
            } catch (InputMismatchException e) {
                System.out.println("A beírt adat nem szám. Csak egész vagy tizedes számokat használhat.");
            }
            System.out.println("Két személy távolsága: " + distance);
        }

        if (distance < 0) {
            System.out.println(String.format("A személyek túlmentek egymáson. Ha %s idő telt volna el "+
                    "az előző időponthoz képest, akkor találkoztak volna.", String.valueOf((previousDistance/(p1.speed
                    + p2.speed)))));
        } else {
            System.out.println("Személyek találkoztak.");
        }
    }
}
