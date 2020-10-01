package ru.levelup.qa.at.java.collections.maps;

import ru.levelup.qa.at.java.statics.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringMap {

    public static void main(String[] args) {
        System.out.println("=== Hash Map ===");
        hashMapString();
        System.out.println("===== === === === =====");

        Map<String, Map<String, List<Person>>> map = new HashMap<>();
    }

    static void hashMapString() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("mama", "myla");
        hashMap.put("papa", "ramu");
        hashMap.put("kolobok", "lisa");
        hashMap.put("vorona", "syr");

        System.out.println(hashMap);
        System.out.println("=====");

        hashMap.put("mama", "gulyala");
        System.out.println(hashMap);
        System.out.println("=====");

        String kolobokValue = hashMap.get("kolobok");
        System.out.println(kolobokValue);
        System.out.println("=====");

        String vovanValue = hashMap.get("vovan");
        System.out.println(vovanValue);
        System.out.println("=====");

        if (!hashMap.containsKey("mmmm")) {
            hashMap.put("mmmm", "6");
        }
        hashMap.putIfAbsent("mmmm", "7");
        System.out.println(hashMap.get("mmmm"));

        // Обежать Map
        for (String key : hashMap.keySet()) {
            System.out.println("Key: " + key + " | value: " + hashMap.get(key));
        }
        System.out.println("=====");
        System.out.println("=====");

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " | value: " + entry.getValue());
        }
        System.out.println("=====");
        System.out.println("=====");

        // NPE
//        String substringVovan = vovanValue.substring(3, 10); // null.substring(3, 10)
//        System.out.println(substringVovan);
//        System.out.println("=====");
    }

}
