package co.com.pragma.project.utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

import static co.com.pragma.project.ui.HomeUI.getLocatorListProductsInYourCart;

public class SelectLocator {

    private SelectLocator(){}
    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());

    public static int getAmountYourCart() {
        return getLocatorListProductsInYourCart().size();
    }
}
