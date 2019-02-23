package com.pizzeria;
import com.kolekcja.*;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Pizza sycylijska = new Pizza("sycylijska ostra", Rozmiar.M);
        Rozmiar r = sycylijska.getRozmiarPizzy();
        System.out.println("Pizza ma rozmiar: " + r + " " + r.getSize());
        System.out.println("Pizza ma średnicę: " + sycylijska.getSrednicaPizzy());
        Student stud = new Student("Jan", "Nowak", "2000-01-01", 2, "psychiatria");
        Para<Student, Pizza> para = new Para<>(stud, sycylijska);
        Osoba os1 = new Osoba("Jan", "Nowak", "2000-01-01");
        Osoba os2 = new Osoba("Anna", "Nowicka", "2000-01-01", new Adres("Poznań", "ul. Szeroka 1", "60-001"));
        Osoba os3 = new Osoba("Emilia", "Abacka", "2010-01-01");
        Osoba os4 = new Osoba("Jan", "Nowak", "2000-01-01");
        List<Osoba> osoby = Arrays.asList
        (
                os1,
                os2,
                os3,
                new Osoba("Jan", "Kot", "1990-01-02")
        );
        Collections.sort(osoby, new SortowanieWgDaty());
        System.out.println(os1.toString());
        System.out.println(os2.toString());
        int[] tab = new int[]{1, 5, 22, 17, 3, 18, 11, 4, 15, 5, 7, 2, 9, 11, 12, 5, 1, 18};
        Stack<Integer> stos = new Stack<Integer>();
        for(int liczba : tab)
            stos.push(liczba);
        for(int i = 1; i < 10; i++) {
            int x = stos.pop();
            System.out.print(x + ", ");
        }
        System.out.println();
        while(!stos.isEmpty())
            System.out.print(stos.pop() + ", ");
        System.out.println();
        ArrayDeque<Integer> kolejka = new ArrayDeque<>();
        for(int liczba : tab)
            kolejka.push(liczba);
        for(int i = 1; i < 10; i++) {
            int x = kolejka.pop();
            System.out.print(x + ", ");
        }
        System.out.println();
        while(!stos.isEmpty())
            System.out.print(kolejka.pop() + ", ");
        Queue<Integer> kolejka2 = new ArrayDeque<>();
        for(int liczba : tab)
            ((ArrayDeque<Integer>) kolejka2).push(liczba);
        for(int i = 1; i < 10; i++) {
            int x = ((ArrayDeque<Integer>) kolejka2).pop();
            System.out.print(x + ", ");
        }
        Hashtable<String, Integer> miasta = new Hashtable<>();
        miasta.put("Poznań", 550);
        miasta.put("Wrocław", 650);
        miasta.put("Praga", 2150);
        miasta.put("Berlin", 3550);
        miasta.put("Katowice", 350);
        miasta.put("Warszawa", 2100);
        Hashtable<String, String> miastaKraje = new Hashtable<>();
        miastaKraje.put("Polska", "Poznań");
        miastaKraje.put("Polska", "Wrocław");
        miastaKraje.put("Niemcy", "Berlin");
        miastaKraje.put("Polska", "Katowice");
        miastaKraje.put("Czechy", "Praga");
        miastaKraje.put("Syria", "Aleppo");
        miastaKraje.put("Egipt", "Kair");
        for(Map.Entry<String, String> wpis : miastaKraje.entrySet()) {
            String miasto =wpis.getValue();
            System.out.println("Miasto: " + miasto);
            for(Map.Entry<String, Integer> wpis2 : miasta.entrySet())
            if (wpis2.getKey().equals(miasto))
                  System.out.println("Kraj= " + wpis.getKey() + ", miasto= " + wpis.getValue() + " " + wpis2.getValue());
        }



    }
}
