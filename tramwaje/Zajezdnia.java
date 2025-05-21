package tramwaje;

import java.util.Arrays;

public abstract class Zajezdnia {

    private String nazwa;
    protected Lista<Pojazd> pojazdy;

    public Zajezdnia(String _nazwa) {

        nazwa = _nazwa;
        pojazdy = new Lista<>();
    }

    public String getNazwa() {

        return nazwa;
    }

    public void zarejestrujPojazd(Pojazd pojazd) {

        pojazdy.dodajNaKoniec(pojazd);
    }

    @Override
    public String toString() {

        String[] nazwyPojazdow = new String[pojazdy.rozmiar()];

        int index = 0;
        Lista<Pojazd>.IteratorListy iteratorListy = pojazdy.iterator();
        while (iteratorListy.hasNext())
            nazwyPojazdow[index++] = iteratorListy.next().opisNumeru();

        return nazwa+":\n"+"- pojazdy: "+ Arrays.toString(nazwyPojazdow);
    }
}
