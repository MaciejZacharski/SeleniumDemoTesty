package Models;

public class Customer {


    private String firstName = "Maciej";
    private String lastName = "Testowy";
    private String countryNameSelect = "Poland";
    private String address1 = "Marecka";
    private String address2 = "22";
    private String postalCode = "123-12";
    private String cityName = "Warszawa";
    private String phoneNumber = "123443211";
    private String emailAddress = "test128@gmail.com";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountryNameSelect() {
        return countryNameSelect;
    }

    public void setCountryNameSelect(String countryNameSelect) {
        this.countryNameSelect = countryNameSelect;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
