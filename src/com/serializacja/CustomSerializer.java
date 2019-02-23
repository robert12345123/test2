package com.serializacja;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CustomSerializer implements JsonSerializer<ArrayList<Osoba>> {
    private static Map<String, Class> map = new TreeMap<String, Class>();
    static {
        map.put("Osoba", Osoba.class);
        map.put("Student", Student.class);
        map.put("StudentInformatyki", StudentInformatyki.class);
        map.put("Pracownik", Pracownik.class);
        map.put("Adres", Adres.class);
        map.put("LocalDate", LocalDate.class);
    }
    @Override
    public JsonElement serialize(ArrayList<Osoba> src, Type typeOfSrc,
                                 JsonSerializationContext context) {
        if (src == null)
            return null;
        else {
            JsonArray ja = new JsonArray();
            for (Osoba bc : src) {
                Class c = map.get(bc.typ);
                if (c == null)
                    throw new RuntimeException("Nieznana klasa: " + bc.typ);
                ja.add(context.serialize(bc, c));

            }
            return ja;
        }
    }
}
