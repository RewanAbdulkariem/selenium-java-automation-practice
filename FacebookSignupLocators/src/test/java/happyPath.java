import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class happyPath{
    WebDriver driver;
    SignupPage signupPage;

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/r.php?entry_point=login");
        signupPage = new SignupPage(driver);
    }

    @Test
    public void happyPathTest() {
        User user = new User(
                "Rewan",
                "Abdulkariem",
                "1",
                "January",
                "2001",
                "Female",
                "010" + System.currentTimeMillis(),
                "password123"
        );
        signupPage.signup(user);
    }
    @Test
    public void GoToLoginPage() {
        signupPage.clickIHaveAnAccount();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
