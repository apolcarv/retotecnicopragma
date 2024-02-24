package co.com.pragma.project.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

import static co.com.pragma.project.utils.Constant.*;

public class Random {

    private Random() {
    }

    private static final Faker faker = com.github.javafaker.Faker.instance(new Locale("es", "CO"), new java.util.Random());

    public static int randomNumberTwoAndFour() {
        return faker.number().numberBetween(TWO, FOUR);
    }

    public static int randomNumberOneToNine() {
        return faker.number().numberBetween(ONE, NINE);
    }

    public static int randomNumberOneToSix() {
        return faker.number().numberBetween(ONE, SIX);
    }

    public static int randomNumberOneToTwo() {
        return faker.number().numberBetween(ONE, TWO);
    }
}