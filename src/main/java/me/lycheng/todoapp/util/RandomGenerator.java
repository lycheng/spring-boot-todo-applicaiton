package me.lycheng.todoapp.util;

import java.util.UUID;

public class RandomGenerator {

    public static String str(int size) {
        if (size <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";
            int index = (int)(alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
