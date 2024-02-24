package co.com.pragma.project.models;

public class PurchasingDataInformationFormDTO {
    private String firstNameFul;
    private String country;
    private String city;
    private String creditCard;
    private String month;
    private String year;

    public PurchasingDataInformationFormDTO() {
    }

    public PurchasingDataInformationFormDTO(String firstNameFul, String country, String city, String creditCard, String month, String year) {
        this.firstNameFul = firstNameFul;
        this.country = country;
        this.city = city;
        this.creditCard = creditCard;
        this.month = month;
        this.year = year;
    }

    public String getFirstNameFul() {
        return firstNameFul;
    }

    public void setFirstNameFul(String firstNameFul) {
        this.firstNameFul = firstNameFul;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}