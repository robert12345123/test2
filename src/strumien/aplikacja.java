import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.serializacja.Adres;
import com.serializacja.Osoba;
import com.serializacja.Pracownik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class aplikacja {
    public static void main(String[] args) {

        Pracownik osoba1 = new Pracownik("Jan", "Kowalski", "1980-11-02", new Adres("Poznań", "ul. Szklista 12", "60-111"), 100, 5411.20);
        Pracownik osoba2 = new Pracownik("Anna", "Zamojska", "1989-03-02", new Adres("Leszno", "", "55-555"), 100, 5678.23);
        Pracownik osoba3 = new Pracownik("Janina", "Kot", "1986-04-02", new Adres("Leszno", "", "55-555"), 100, 7400.20);
        Pracownik osoba4 = new Pracownik("Antoni", "Robak", "1997-12-02", new Adres("Leszno", "", "55-555"), 100, 3600.50);
        Pracownik osoba5 = new Pracownik("Weronika", "Kocińska", "2001-07-14", new Adres("Leszno", "", "55-555"), 100, 2670.00);
        Pracownik osoba6 = new Pracownik("Zenon", "Abacki", "1978-02-23", new Adres("Leszno", "", "55-555"), 100, 8200.20);
        List<Pracownik> pracownicy = new ArrayList<Pracownik>();
        pracownicy.add(osoba1);
        pracownicy.add(osoba2);
        pracownicy.add(osoba3);
        pracownicy.add(osoba4);
        pracownicy.add(osoba5);
        pracownicy.add(osoba6);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        gson.toJson(pracownicy);
        // zapis do pliku
        //zabawa ze stream's
        List<Pracownik> urodzeniePrzed = pracownicy
                .stream()
                .filter((p) -> p.getDataUrodzenia().getYear() < 1989)
                .collect(Collectors.toList());
        //3 pierwszych pracowników urodzonych przed określonym rokiem

        //for(Pracownik prac : urodzeniePrzed)
        //    System.out.println(prac.toString());
        urodzeniePrzed.forEach(System.out::println);
        //urodzeniePrzed.forEach((p) -> System.out.print(p.getNazwisko() + " " + p.getDataUrodzenia()));
        //Wszystkich pracowników posortowanych według (rosnącej) pensji

        //Pracowników urodzonych w pierwszej połowie roku posortowanych wg imion
        //Sumę pensji wszystkich pracowników


    }
}