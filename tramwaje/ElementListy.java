package tramwaje;

public class ElementListy<T> {

    private ElementListy<T> poprzedni;
    private ElementListy<T> nastepny;
    private T wartosc;

    public ElementListy(T _wartosc, ElementListy<T> _poprzedni, ElementListy<T> _nastepny) {

        ustawPoprzedni(_poprzedni);
        ustawNastepny(_nastepny);
        wartosc = _wartosc;
    }

    public void ustawPoprzedni(ElementListy<T> _poprzedni) {

        poprzedni = _poprzedni;
    }

    public void ustawNastepny(ElementListy<T> _nastepny) {

        nastepny = _nastepny;
    }

    public T getWartosc() {

        return wartosc;
    }

    public ElementListy<T> getPoprzedni() {

        return poprzedni;
    }

    public ElementListy<T> getNastepny() {

        return nastepny;
    }
}
