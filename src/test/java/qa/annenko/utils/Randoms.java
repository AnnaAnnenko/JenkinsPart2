package qa.annenko.utils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Randoms {

    public static String getRandomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder result = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            result.append(AB.charAt(rnd.nextInt(AB.length())));
        return result.toString();
    }

    public static String getRandomMonth() {
        List<String> months = Arrays.asList(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
        return months.get(new Random().nextInt(months.size()));
    }
}