package src;

public class Calculator {
    private final Person p1 = new Person();
    private final Person p2 = new Person();
    private final Person dog = new Person();
    double distance;
    double dogDistanceRanInACycle = 0;
    double dogTraveled = 0;
    int dogCycle = 0;

    Calculator(double p1, double p2, double dog, double distance) {
        this.p1.speed = p1;
        this.p2.speed = p2;
        this.dog.speed = dog;
        this.distance = distance;
    }

    /**
     * Visszaadja a következő lépés adatait.
     * @param stepTime - Idő a következő pillanatig.
     * */
    public void nextState(double stepTime) {
        double previousDistance = distance;

        distance -= p1.speed * stepTime + p2.speed * stepTime;
        dogDistanceRanInACycle += dog.speed * stepTime;
                /*Ahányszor a kutya túlfutna az egyik emberen, hozzáadódik a köreihez egy szám.
                  Ami a túlmenet, az hozzáadódik a következő körben futotthoz.
                  HA NEM FUT TÚL: mínusz lesz a következő körben a távolsága.
                  EZ GOND????? TODO: megkérdezni a ha nem fut túl esetet*/
        if (dogDistanceRanInACycle >= distance) {
            dogDistanceRanInACycle -= distance;
            dogCycle += 1;
        }
        dogTraveled += dogDistanceRanInACycle;

        GUI.Set.distance(String.valueOf(distance));
        GUI.Set.dogRounds(String.valueOf(dogCycle));
        GUI.Set.dogDistanceRanInACycle(String.valueOf(dogDistanceRanInACycle));
        GUI.Set.dogAllDistance(String.valueOf(dogTraveled));

        if (distance < 0) {
            GUI.inform("Találkoztak és túlmentek", String.format("Ha %f idő telt volna el az előző időponthoz " +
                    "képest, akkor találkoztak volna.",(previousDistance / (p1.speed+ p2.speed))), 1);
            GUI.askDeleteEntries();

        } else if (distance == 0) {
            GUI.inform("Személyek találkoztak.", "A személyek találkoztak és nem mentek túl egymáson." , 1);
            GUI.askDeleteEntries();
        }
    }
}
