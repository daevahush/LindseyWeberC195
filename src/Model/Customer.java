package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Customer{
    private int customerID;
    private String customerName;
    private int addressID;
    private String address;
    private String address2;
    private int cityID;
    private String city;
    private int countryID;
    private String country;
    private String postalCode;
    private String phone;

    public static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
    public static ObservableList<Customer> updateCustomer = FXCollections.observableArrayList();

    public Customer(int customerID, String customerName, int addressID, String address, String address2,
                    int cityID, String city, int countryID, String country, String postalCode, String phone) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.addressID = addressID;
        this.address = address;
        this.address2 = address2;
        this.cityID = cityID;
        this.city = city;
        this.countryID = countryID;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void addCustomer(Customer newCustomer) {
        allCustomers.add(newCustomer);
    }

    public static void addUpdateCustomer(Customer newCustomer) {
        updateCustomer.add(newCustomer);
    }

}
