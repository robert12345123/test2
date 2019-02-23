package com.serializacja;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;
@Root(name= "KolekcjaOsob")
public class KolekcjaOsob {
    @Attribute
    int ile;
    @ElementList(name="Osoby")
    public List<Osoba> listaOsób;
    public KolekcjaOsob() {
        listaOsób = new ArrayList<Osoba>();
        ile = 0;
    }
    public void załaduj() {
        Osoba osoba1 = new Osoba("Jan", "Kowalski", "1980-11-02", new Adres("Poznań", "ul. Szklista 12", "60-111"));
        Osoba osoba2 = new Osoba("Anna", "Zamojska", "1988-03-02");
        Osoba osoba3 = new Osoba("Janina", "Kot", "1986-04-02");
        Osoba osoba4 = new Osoba("Antoni", "Robak", "1997-12-02");
        Osoba osoba5 = new Osoba("Weronika", "Kocińska", "2001-07-14");
        Osoba osoba6 = new Osoba("Zenon", "Abacki", "1978-02-23");
        Osoba prac1 = new Pracownik("Marian", "Cebula", "1988-02-23", new Adres("Mosina", "ul. Kwiatowa 12", "62-031"), 1000.0, 2000.0);
        Student student1 = new Student("Wanda", "Nowicka", "1999-08-11", 2, "socjologia");
        StudentInformatyki studIT = new StudentInformatyki("Karol", "Zalewski", "1997-08-21", new Adres("Wrocław", "ul. Polna 1", "55-555"), 2, "informatyka stosowana", PoziomUmiejętnościProgramowania.Dobry);
        osoba1.setPieniądze(2200);
        osoba2.setPieniądze(1900);
        osoba3.setPieniądze(3500);
        osoba4.setPieniądze(10);
        osoba5.setPieniądze(2300);
        osoba6.setPieniądze(950);
        student1.setPieniądze(2456.21);
        studIT.setPieniądze(1000.50);
        osoba1.setZachowanie(new Trzpiot());
        osoba2.setZachowanie(new Snob());
        osoba3.setZachowanie(new Rozrzutny());
        osoba5.setZachowanie(new Snob());
        osoba6.setZachowanie(new Oszczędny());
        student1.setZachowanie(new Snob());
        studIT.setZachowanie(new Oszczędny());
        prac1.setZachowanie(new Snob());
        listaOsób.add(osoba1);
        listaOsób.add(osoba2);
        listaOsób.add(osoba3);
        listaOsób.add(osoba4);
        listaOsób.add(osoba5);
        listaOsób.add(osoba6);
        listaOsób.add(student1);
        listaOsób.add(studIT);
        listaOsób.add(prac1);
        Collections.sort(listaOsób);
        for (Osoba os : listaOsób) {
            System.out.println(os.toString());
            if (os instanceof Student) {
                Student studen = (Student) os;
                studen.getKierunekStudiów();
            }
        }
    }

    public void symulujZachowanieWSklepie(Sklep sklep) {
        System.out.println("=== Symulacja zachowania w sklepie: " + sklep.getNazwaSklepu() + " ===");
        for (Osoba osoba : listaOsób) {
            double wydano = osoba.kupuj(osoba.getPieniądze(), sklep);
            osoba.zapłać(wydano);
        }
    }
    public void zapiszJSON() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String efekt = gson.toJson(listaOsób);
        File file = new File("kolekcja.json");
        try {
            PrintStream fp = new PrintStream(file);
            fp.println(efekt);
            fp.close();
        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        }
    }
    public void wczytajJSON() {
        File file = new File("kolekcja.json");
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String napis = br.readLine();
                br.close();
                fr.close();
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                     //   .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                        .excludeFieldsWithoutExposeAnnotation()
                        .create();
                //Gson gson = new Gson();
                //listaOsób = (ArrayList<Osoba>) gson.fromJson(napis, new TypeToken<ArrayList<Osoba>>(){}.getType());
                for (Osoba os : listaOsób)
                    System.out.println(os.toString());
            } catch (FileNotFoundException fe) {
                System.out.println(fe.getMessage());
            }
            catch(IOException ie){
                System.out.println(ie.getMessage());
            }
    }
    public void zapiszXML() {
        ile = this.listaOsób.size();
        File plik = new File("kolekcja.xml");
        Serializer serializer = new Persister();
        try
        {
            serializer.write(this, plik);
        }
        catch(Exception e)
        {
            System.out.println("5 " + e.getMessage());
        }
    }
    public List<Osoba> wczytajXML() {
        List<Osoba> nowa = new ArrayList<Osoba>();
        File plik = new File("kolekcja.xml");
        Serializer serializer = new Persister();
        try {
            //nowa = (List<Osoba>) serializer.read(List<Osoba>, plik);
        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        return nowa;
    }
}