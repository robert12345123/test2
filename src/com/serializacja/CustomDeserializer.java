package com.serializacja;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class CustomDeserializer implements JsonDeserializer<List<Osoba>> {

    private static Map<String, Class> map = new TreeMap<String, Class>();
    static {
        map.put("Osoba", Osoba.class);
        map.put("Student", Student.class);
        map.put("StudentInformatyki", StudentInformatyki.class);
        map.put("Oszczędny", Oszczędny.class);
        map.put("Rozrzutny", Rozrzutny.class);
        map.put("Pracownik", Pracownik.class);
        map.put("Adres", Adres.class);
        map.put("LocalDate", LocalDate.class);
    }

    public List<Osoba> deserialize(JsonElement json, Type typeOfT,
                                   JsonDeserializationContext context) throws JsonParseException {
        List list = new ArrayList<Osoba>();
        JsonArray ja = json.getAsJsonArray();
        for (JsonElement je : ja) {

            String type = je.getAsJsonObject().get("typ").getAsString();
            Class c = map.get(type);
            if (c == null)
                throw new RuntimeException("Nieznana klasa: " + type);
            list.add(context.deserialize(je, c));
        }
        return list;

    }
}
