package tramwaje;

public class Autobus extends Pojazd {

    private double zuzyciePaliwa;

    public Autobus(double _szybkoscMaksymalna, String _numer, ZajezdniaAutobusowa _zajezdnia, double _zuzyciePaliwa) {

        super(_szybkoscMaksymalna, _numer, _zajezdnia);

        // nie moze istniec niezarejstrowany pojazd
        zajezdnia.zarejestrujPojazd(this);

        ustawZuzyciePaliwa(_zuzyciePaliwa);
    }

    public Autobus ustawZuzyciePaliwa(double _zuzyciePaliwa) {

        zuzyciePaliwa = _zuzyciePaliwa;
        return this;
    }

    public String opisZuzyciaPaliwa() {

        return "- zużycie paliwa: " + zuzyciePaliwa;
    }

    @Override
    public String pelenOpis() {

        return super.pelenOpis()+"\n"+opisZuzyciaPaliwa();
    }
}
