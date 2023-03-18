package src;

import java.util.InputMismatchException;
import java.util.Scanner;
//TODO: gui
public class Main {

    static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        GUI.inputWindow();

        Person p1 = new Person();
        Person p2 = new Person();
        Person dog = new Person();
        double distance = 0;
        boolean notDoneChoosing = true;
        while (notDoneChoosing) {
            try {
                System.out.print("1. személy sebessége: ");
                p1.speed = scn.nextDouble();

                System.out.print("2. személy sebessége: ");
                p2.speed = scn.nextDouble();

                System.out.print("Személyek távolsága: ");
                distance = scn.nextDouble();

                System.out.print("Köztük futó kutya sebessége: ");
                dog.speed = scn.nextDouble();

                notDoneChoosing = false;
            } catch (InputMismatchException e) {
                System.out.println("A beírt adat nem szám. Csak egész vagy tizedes számokat használhat.");
                scn.nextLine(); //elviszi az előző sor enterét (nélküle loop lesz)
            }
        }

        double stepTime;
        double previousDistance = 0;
        double dogDistanceRanInACycle = 0;
        double dogTraveled = 0;
        int dogCycle = 0;

        while (distance > 0) {
            try {
                System.out.print("Következő pillanatig eltelt idő: ");
                stepTime = scn.nextDouble();

                previousDistance = distance;

                distance -= p1.speed * stepTime + p2.speed * stepTime;
                dogDistanceRanInACycle += dog.speed * stepTime;
                /*Ahányszor a kutya túlfutna az egyik emberen, hozzáadódik a köreihez egy szám.
                  Ami a túlmenet, az hozzáadódik a következő körben futotthoz.
                  HA NEM FUT TÚL: minusu lesz a következő körben a távolsága.
                  EZ GOND????? TODO: megkérdezni a ha nem fut túl esetet*/
                if (dogDistanceRanInACycle >= distance) {
                    dogDistanceRanInACycle -= distance;
                    dogCycle += 1;
                }
                dogTraveled += dogDistanceRanInACycle;

            } catch (InputMismatchException e) {
                System.out.println("A beírt adat nem szám. Csak egész vagy tizedes számokat használhat.");
            }
            System.out.println("Két személy távolsága: " + distance);
            System.out.println("A kutya ennyiszer fordult meg eddig: " + dogCycle);
            System.out.println("A kutya egy körön belül megtett távja (körönként nullázódik): "
                    +dogDistanceRanInACycle);
            System.out.println("A kutya összesen ennyit futott: " + dogTraveled);
            System.out.println();
        }

        if (distance < 0) {
            System.out.printf("A személyek túlmentek egymáson. Ha %f idő telt volna el "+
                    "az előző időponthoz képest, akkor találkoztak volna.%n", previousDistance / (p1.speed
                    + p2.speed));
        } else {
            System.out.println("Személyek találkoztak.");
        }
    }
}
