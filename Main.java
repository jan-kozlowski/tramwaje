import tramwaje.Pojazd;
import tramwaje.Zajezdnia;

public class Main {

    public static void main(String[] args) {

        Zajezdnia mojaZajezdnia = new Zajezdnia("przystanek 1");
        Pojazd p1 = new Pojazd(15, "ABCD", mojaZajezdnia);
        System.out.println(p1);

    }
}
