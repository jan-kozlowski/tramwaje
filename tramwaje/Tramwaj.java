package tramwaje;

public class Tramwaj extends Pojazd {

    private final Lista<Wagon> wagony;

    public Tramwaj(double _szybkoscMaksymalna, String _numer, ZajezdniaTramwajowa _zajezdnia, Wagon[] _wagony) {

        super(_szybkoscMaksymalna, _numer, _zajezdnia);

        wagony = new Lista<>(_wagony);

        if(wagony.rozmiar() < 1)
            throw new IllegalStateException("Podano zbyt mało wagonów");
        if(wagony.rozmiar() > 3)
            throw new IllegalStateException("Podano zbyt dużo wagonów");

        // nie moze istniec niezarejstrowany pojazd
        zajezdnia.zarejestrujPojazd(this);
    }

    public String opisWagonow() {

        return "- wagony: " + wagony.toString();
    }

    @Override
    public String pelenOpis() {

        return super.pelenOpis()+"\n"+opisWagonow();
    }
}
