import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DummyTicketPage;

public class BookingTest {
    WebDriver driver;
    DummyTicketPage dummyTicketPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        dummyTicketPage = new DummyTicketPage(driver);
    }


    @Test
    public void BookingFlow() {
        // 1. Ticket Details
        dummyTicketPage.selectTicketOption("Visa Application");

        // 2. Passenger Details
        dummyTicketPage.fillPassengerName("John", "Johnson");
        dummyTicketPage.selectDateOfBirth("15/05/1995");
        dummyTicketPage.selectSex("Female");

        // 3. Travel Details
        dummyTicketPage.selectTripType("One Way");
        dummyTicketPage.fillFromToCities("Cairo", "Dubai");
        dummyTicketPage.selectDepartueDate("20/12/2026");

        // 4. Billing Details
        dummyTicketPage.enterBillingName("John");
        dummyTicketPage.enterPhone("0123456789");
        dummyTicketPage.enterEmail("John@example.com");
        dummyTicketPage.selectCountry("Egypt");
        dummyTicketPage.enterStreetAddress("123 Testing St");
        dummyTicketPage.enterCity("Alexandria");
        dummyTicketPage.selectState("Alexandria");
        dummyTicketPage.enterZipCode("21500");

        // 5. Payment & Action
        dummyTicketPage.selectPaymentMethod("Credit Card");
        dummyTicketPage.enterCardDetails("1234123412341234", "12/28", "123"); // لو الـ Field متاح

        dummyTicketPage.placeOrder();
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
