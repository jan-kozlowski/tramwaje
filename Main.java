import tramwaje.*;

public class Main {

    public static void main(String[] args) {

        ZajezdniaAutobusowa zajezdniaAutobusowa = new ZajezdniaAutobusowa("Przystanek autobusowy");
        ZajezdniaTramwajowa zajezdniaTramwajowa = new ZajezdniaTramwajowa("Przystanek tramwajowy");
        Autobus a1 = new Autobus(15, "A1", zajezdniaAutobusowa, 123);
        Autobus a2 = new Autobus(15, "B1", zajezdniaAutobusowa, 123);
        Autobus a3 = new Autobus(15, "C157", zajezdniaAutobusowa, 123);
        Tramwaj t1 = new Tramwaj(2, "T1", zajezdniaTramwajowa,
                new Wagon[]{new Wagon(), new WagonSilnikowy(), new WagonSilnikowy()});
        Tramwaj t2 = new Tramwaj(2, "T123", zajezdniaTramwajowa,
                new Wagon[]{new Wagon()});

        System.out.println(zajezdniaAutobusowa);
        System.out.println("---------------------");
        System.out.println(zajezdniaTramwajowa);
    }

}
