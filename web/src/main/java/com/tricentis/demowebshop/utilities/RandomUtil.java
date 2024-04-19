package com.tricentis.demowebshop.utilities;

import java.util.Random;

public class RandomUtil {

    private static final String ALPHANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static Random random = new Random();

    public RandomUtil() {
        random = new Random();
    }

    public static String getRandomString(int stringLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALPHANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALPHANUMERICAL_ALL_CAPS.length())));
        }
        return stringBuilder.toString();
    }

    public static int getRandomNumberInBorder(int max) {
        return random.nextInt(max);
    }
}
