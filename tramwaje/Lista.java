package tramwaje;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class Lista<T> {

    private int liczbaElementow;
    private ElementListy<T> pierwszy;
    private ElementListy<T> ostatni;

    public Lista() {

        init();
    }

    public Lista(T[] elementy) {

        init();

        for(T element : elementy)
            dodajNaKoniec(element);
    }

    private void init() {

        liczbaElementow = 0;
        pierwszy = null;
        ostatni = pierwszy;
    }

    public Lista<T> dodajNaKoniec(T element) {

        ElementListy<T> nowy = new ElementListy<>(element, null);

        if(rozmiar() == 0)
            pierwszy = nowy;
        else
            ostatni.nastepny = nowy;

        ostatni = nowy;
        liczbaElementow++;

        return this;
    }

    public int rozmiar() {

        return liczbaElementow;
    }

    @Override
    public String toString() {

        String[] lista = new String[liczbaElementow];

        IteratorListy iteratorListy = iterator();
        int index = 0;
        while (iteratorListy.hasNext())
            lista[index++] = iteratorListy.next().toString();

        return Arrays.toString(lista);
    }

    public IteratorListy iterator() {

        return new IteratorListy(pierwszy);
    }

    private class ElementListy<T> {

        private ElementListy<T> nastepny;
        private final T wartosc;

        public ElementListy(T _wartosc, ElementListy<T> _nastepny) {

            ustawNastepny(_nastepny);
            wartosc = _wartosc;
        }

        public void ustawNastepny(ElementListy<T> _nastepny) {

            nastepny = _nastepny;
        }

        public ElementListy<T> getNastepny() {

            return nastepny;
        }

        public T getWartosc() {

            return wartosc;
        }
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
    }
}
