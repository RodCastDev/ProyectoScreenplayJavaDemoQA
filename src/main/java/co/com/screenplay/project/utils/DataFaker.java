package co.com.screenplay.project.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataFaker {
    private DataFaker() {
    }

    private static Faker faker = Faker.instance(new Locale("es", "CO"));

    public static String fackeNumberRageOneAndNine(){
        return String.valueOf(faker.number().numberBetween(1,7));
    }

}
