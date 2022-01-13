package helper;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class HelperMethods {
    public static Faker faker = new Faker();

    public static String getRandomFirstname() {
        return faker.name().firstName();
    }

    public static int getRandomPrice() {
        return faker.random().nextInt(1,99);
    }

    public static String getRandomPhone(){
        return faker.phoneNumber().cellPhone();
    }

    public static int getRandomCountry() {
        return faker.random().nextInt(1,10);
    }

}
