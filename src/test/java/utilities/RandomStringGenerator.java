package utilities;

import com.github.javafaker.Faker;

public class RandomStringGenerator {

    private static final Faker f = new Faker();

    public static String randomFirstName() {
        return f.name().firstName();
    }

    public static String randomLastName() {
        return f.name().lastName();
    }

    public static String randomEmail() {
        return
                f.name().firstName().toLowerCase()
                        + "." +
                        f.name().lastName().toLowerCase()
                        + "@gmail.com";
    }
}