package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DummyTicketPage extends BasePage {

    WebDriver driver;

    public DummyTicketPage(WebDriver driver) {
        super(driver);
    }

    // --------------- Ticket Details ----------------
    By confirmationForOptionLocator = By.className("woocommerce-message");

    By couponLinkLocator = By.className("showcoupon");
    By couponCodeInputLocator = By.name("coupon_code");
    By applyCouponButtonLocator = By.name("apply_coupon");
    By couponErrorMessageLocator = By.id("coupon-error-notice");
    // --------------- Passenger Details ----------------
    By passengerNameLocator = By.id("travname");
    By passengerLastNameLocator = By.id("travlastname");

    By dateOfBirthLocator = By.id("dob");
    By monthLocator = By.className("ui-datepicker-month");
    By yearLocator = By.className("ui-datepicker-year");

    By todayButtonLocator = By.xpath("//button[.='Today']");
    By doneButtonLocator = By.xpath("//button[.='Done']");

    By sexOptionLocator = By.name("sex");

    // TODO: Add Locators for More passengers details
    // --------------- Travel Details ----------------
    By tripTypeLocator = By.name("traveltype");

    By fromCityLocator = By.id("fromcity");
    By toCityLocator = By.id("tocity");

    By departureDateLocator = By.id("departon");
    By returnDateLocator = By.id("returndate");

    // --------------- Delivery options ----------------
    //TODO: Add Locators for delivery options

    // --------------- Billing Details ----------------
    By billingNameLocator = By.id("billname");
    By phoneLocator = By.id("billing_phone");
    By emailLocator = By.id("billing_email");

    By countryLocator = By.cssSelector("[aria-label='Country']");
    By StreetAddressLocator = By.id("billing_address_1");
    By cityLocator = By.id("billing_city");
    By stateLocator = By.cssSelector("[aria-label='State / District / Province']");
    By ZipCodeLocator = By.id("billing_postcode");
    // --------------- Additional information ----------------
    //TODO: Add Locators for additional information
    // --------------- Your order ----------------
    By productDetailsLocator = By.className("product-details");
    By productTotalLocator = By.cssSelector("td .product-total");
    By productQuantityLocator = By.cssSelector("td div .product-quantity");

    By paymentMethodLocator = By.name("payment_method");

    By frameLocator = By.xpath("//iframe[@title='Secure payment input frame']");
    By CardNumberLocator = By.id("payment-numberInput");
    By ExpiryDateLocator = By.id("payment-expiryInput");
    By CVVLocator = By.id("payment-cvcInput");

    By placeOrderButtonLocator = By.id("place_order");


    /**
     * Selects a ticket.
     */
    public void selectTicketOption(String TicketOption) {
        System.out.println("Selected Ticket Option: " + TicketOption);
        By optionLocator = By.xpath("//li[contains(.,'" + TicketOption + "')]//input");
        click(optionLocator);
    }
    public void ClickOnCouponLink() {
        click(couponLinkLocator);
    }

    public void applyCoupon(String couponCode) {
        type(couponCodeInputLocator, couponCode);
        click(applyCouponButtonLocator);
    }
    public String getCouponErrorMessage() {
        return getText(couponErrorMessageLocator);
    }
    /**
     * Passenger details
     */
    public void fillPassengerName(String name, String lastName) {
        type(passengerNameLocator, name);
        type(passengerLastNameLocator, lastName);
    }
    public void selectDate(By fieldLocator,String date) {
        click(fieldLocator);
        String [] dateParts = date.split("/");
        selectByText(yearLocator, dateParts[2]);
        selectByValue(monthLocator, (Integer.parseInt(dateParts[1]) - 1) + "");
        By DayLocator = By.xpath("//a[@data-date="+dateParts[0]+"]");
        click(DayLocator);
    }
    public void selectDateOfBirth(String dateOfBirth) {
        selectDate(dateOfBirthLocator, dateOfBirth);
    }
    public void selectSex(String sex){
        // index 0 for Male, 1 for Female
        int index = sex.equalsIgnoreCase("Male") ? 0 : 1;
        click(sexOptionLocator, index);
    }
    /**
     * Travel Details
     */
    public void selectTripType(String tripType) {
        // index 0 for One Way, 1 for Round Trip
        int index = tripType.equalsIgnoreCase("One Way") ? 0 : 1;
        click(tripTypeLocator, index);
    }
    public void fillFromToCities(String fromCity, String toCity) {
        type(fromCityLocator, fromCity);
        type(toCityLocator, toCity);
    }
    public void selectDepartueDate(String departureDate) {
        selectDate(departureDateLocator, departureDate);
    }
    public void selectReturnDate(String returnDate) {
        selectDate(returnDateLocator, returnDate);
    }
    /**
     * Delivery options
     */
    //TODO: Add methods to delivery options
    /**
     * Billing Details
     */
    public void enterBillingName(String billingName) {
        type(billingNameLocator, billingName);
    }
    public void enterPhone(String phone) {
        type(phoneLocator, phone);
    }
    public void enterEmail(String email) {
        type(emailLocator, email);
    }
    public void selectCountry(String country) {
        click(countryLocator);
        By countryOptionLocator = By.xpath("//li[.='" + country + "']");
        click(countryOptionLocator);
    }
    public void enterStreetAddress(String streetAddress) {
        type(StreetAddressLocator, streetAddress);
    }
    public void enterCity(String city) {
        type(cityLocator, city);
    }
    public void selectState(String state) {
        click(stateLocator);
        By stateOptionLocator = By.xpath("//li[.='" + state + "']");
        click(stateOptionLocator);
    }
    public void enterZipCode(String zipCode) {
        type(ZipCodeLocator, zipCode);
    }
    /**
    * Additional information
    */
    //TODO: Add methods for additional information

    /**
    * Your order
    */
    public String getProductDetails() {
        return getText(productDetailsLocator);
    }
    public String getProductQuantity() {
        return getText(productQuantityLocator);
    }
    public String getProductTotal() {
        return getText(productTotalLocator);
    }
    public void selectPaymentMethod(String paymentMethod) {
        // index 0 for Credit Card/Debit Card, 1 for PayPal
        int index = paymentMethod.matches("Credit Card|Debit Card") ? 0 : 1;
        click(paymentMethodLocator, index);
    }

    public void enterCardDetails(String cardNumber, String expiryDate, String cvv) {
        switchToFrame(frameLocator);
        type(CardNumberLocator, cardNumber);
        type(ExpiryDateLocator, expiryDate);
        type(CVVLocator, cvv);
        switchToDefaultContent();
    }

    public void placeOrder() {
        click(placeOrderButtonLocator);
    }
}