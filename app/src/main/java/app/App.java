package app;

import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Test", 1);

        Object i = map.get("BULL");
        System.out.println(i);
    }
}

