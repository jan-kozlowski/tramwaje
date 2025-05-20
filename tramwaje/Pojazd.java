package tramwaje;

public class Pojazd {

    private double szybkoscMaksymalna;
    private String numer;
    private Zajezdnia zajezdnia;

    public Pojazd(double _szybkoscMaksymalna, String _numer, Zajezdnia _zajezdnia) {

        szybkoscMaksymalna = _szybkoscMaksymalna;
        numer = _numer;
        zajezdnia = _zajezdnia;

        // nie moze istniec niezarejstrowany pojazd
        zajezdnia.zarejestrujPojazd(this);
    }

    public String opisSzybkosci() {

        return "szybkość maksymalna: " + szybkoscMaksymalna;
    }

    public String opisNumeru() {

        return "numer: " + numer;
    }

    public String opisZajezdni() {

        return "nazwa zajezdni: " + zajezdnia.getNazwa();
    }

    @Override
    public String toString() {

        return getClass().getSimpleName()+":\n"+
                opisSzybkosci()+"\n"+
                opisNumeru()+"\n"+
                opisZajezdni();
    }
}
