package com.treeset;
import com.kolekcja.Osoba;
import java.util.Comparator;

/**
 * NazwiskoComparator porównuje obiekty klasy osoba wg nazwiska a jeśli są równe, to porównuje wg pola imię
 */
public class NazwiskoComparator implements Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2) {
        if (!o1.getNazwisko().equals(o2.getNazwisko()))
          return o1.getNazwisko().compareTo(o2.getNazwisko());
        else
            return o1.getImię().compareTo(o2.getImię());
    }
}
