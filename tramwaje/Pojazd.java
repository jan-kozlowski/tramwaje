package tramwaje;

public abstract class Pojazd {

    private double szybkoscMaksymalna;
    private String numer;
    Zajezdnia zajezdnia;

    public Pojazd(double _szybkoscMaksymalna, String _numer, Zajezdnia _zajezdnia) {

        szybkoscMaksymalna = _szybkoscMaksymalna;
        numer = _numer;
        zajezdnia = _zajezdnia;
    }

    public String opisSzybkosci() {

        return "- szybkość maksymalna: " + szybkoscMaksymalna;
    }

    public String opisNumeru() {

        return numer + " ("+getClass().getSimpleName()+")";
    }

    public String opisZajezdni() {

        return "- nazwa zajezdni: '" + zajezdnia.getNazwa()+"'";
    }

    public String pelenOpis() {

        return opisNumeru()+":\n"+
                opisSzybkosci()+"\n"+
                opisZajezdni();
    }

    @Override
    public String toString() {

        return pelenOpis();
    }
}
