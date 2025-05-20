package tramwaje;

public class Zajezdnia {

    private String nazwa;
    private Lista<Pojazd> pojazdy;

    public Zajezdnia(String _nazwa) {

        nazwa = _nazwa;
        pojazdy = new Lista<>();
    }

    public String getNazwa() {

        return nazwa;
    }

    public void zarejestrujPojazd(Pojazd pojazd) {

        pojazdy.dodajNaPoczatek(pojazd);
    }

    public void usunPojazd(Pojazd pojazd) {

//        pojazdy.usunElement(new ElementListy<>(pojazd));
    }
}
