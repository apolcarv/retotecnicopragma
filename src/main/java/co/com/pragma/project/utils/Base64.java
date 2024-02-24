package co.com.pragma.project.utils;

public class Base64 {

    private Base64() {
    }

    public static String decode(String texto) {
        return new String(java.util.Base64.getDecoder().decode(texto));
    }
}