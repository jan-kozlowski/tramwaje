package tramwaje;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class Lista<T> {

    private int liczbaElementow;
    private ElementListy<T> pierwszy;
    private ElementListy<T> ostatni;

    public Lista() {

        liczbaElementow = 0;
        pierwszy = null;
        ostatni = pierwszy;
    }

    public Lista<T> dodajNaPoczatek(T element) {

        ElementListy<T> nowy;

        if(rozmiar() == 0) {
            nowy = new ElementListy<>(element, null, null);
            ostatni = nowy;
        }
        else {
            nowy = new ElementListy<>(element, null, pierwszy);
            pierwszy.ustawPoprzedni(nowy);
        }

        pierwszy = nowy;
        liczbaElementow++;
        return this;
    }

    public Lista<T> usunNaPoczatku() {

        if(rozmiar() == 0) {
            return this;
        }

        pierwszy = pierwszy.getNastepny();
        pierwszy.ustawPoprzedni(null);
        liczbaElementow--;
        return this;
    }

    public Lista<T> usunNaKoncu() {

        if(rozmiar() == 0) {
            return this;
        }

        ostatni = ostatni.getPoprzedni();
        ostatni.ustawNastepny(null);
        liczbaElementow--;
        return this;
    }

    public int rozmiar() {

        return liczbaElementow;
    }

    public IteratorListy iterator() {

        return new IteratorListy(pierwszy);
    }

    public void wypiszOdPoczatku() {

        String[] wynik = new String[rozmiar()];

        IteratorListy iteratorListy = iterator();
        int index = 0;
        while (iteratorListy.hasNext()) {

            wynik[index++] = iteratorListy.next().toString();
        }

        System.out.println(Arrays.toString(wynik));
    }

    public Lista<T> usunElement(ElementListy<T> element) {

        if(element == null)
            return this;

        if(element == pierwszy && element == ostatni) {

            pierwszy = null;
            ostatni = null;
            liczbaElementow = 0;
            return this;
        }
        if(element == pierwszy)
            return usunNaPoczatku();
        if(element == ostatni)
            return usunNaKoncu();

        element.getPoprzedni().ustawNastepny(element.getNastepny());
        element.getNastepny().ustawPoprzedni(element.getPoprzedni());

        liczbaElementow--;
        return this;
    }

    public class IteratorListy implements Iterator<T> {

        ElementListy<T> poprzedni;
        ElementListy<T> biezacy;

        public IteratorListy(ElementListy<T> _biezacy) {

            poprzedni = null;
            biezacy = _biezacy;
        }

        @Override
        public boolean hasNext() {
            return biezacy != null;
        }

        @Override
        public T next() {

            if(!hasNext())
                return null;

            poprzedni = biezacy;
            biezacy = biezacy.getNastepny();
            return poprzedni.getWartosc();
        }

        @Override
        public void remove() {

            if(poprzedni == null)
                throw new IllegalStateException();

            usunElement(poprzedni);
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Iterator.super.forEachRemaining(action);
        }
    }
}
