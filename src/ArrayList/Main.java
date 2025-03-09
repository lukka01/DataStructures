package ArrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> phones = new ArrayList<String>();
        phones.add("Samsung");
        phones.add("iphone");
        phones.add("Xiaomi");

        phones.set(1,"Some android");
        phones.remove(0);
        for (int i = 0; i < phones.size(); i++) {
            System.out.println(phones.get(i));
        }

    }
}
