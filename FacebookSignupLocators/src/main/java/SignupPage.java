import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage{

    By firstNameField = By.xpath("//label[contains(. ,'First name')]/preceding-sibling::input");
    By surNameField = By.xpath("//label[contains(., 'Surname')]/preceding-sibling::input");

    By BirthDayField = By.xpath("//span[contains(text(), 'Day')]/ancestor::div[@role='combobox']");
    By BirthMonthField = By.xpath("//span[contains(text(), 'Month')]/ancestor::div[@role='combobox']");
    By BirthYearField = By.xpath("//span[contains(text(), 'Year')]/ancestor::div[@role='combobox']");

    By genderField = By.xpath("//span[contains(.,\"gender\")]/parent::div");

    By mobileNumberField = By.xpath("//label[text()='Mobile number or email address']/preceding-sibling::input");

    By passwordField = By.cssSelector("input[type='password']");

    By submitButton = By.xpath("//div[@role='button'] //span[text()='Submit']");
    By iHaveAnAccountButton = By.xpath("//div[@role='button'] //span[contains(text(), 'already')]");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        sendKeys(firstNameField,firstName);
    }

    public void enterSurName(String surName) {
        sendKeys(surNameField, surName);
    }
    private void selectDropdownOption(By dropdownField, String optionValue) {
        click(dropdownField);

        String optionXpath = String.format("//div[@role='option' and normalize-space()='%s']", optionValue);
        click(By.xpath(optionXpath));
    }

    public void selectBirthDate(String day, String month, String year) {
        selectDropdownOption(BirthDayField, day);
        selectDropdownOption(BirthMonthField, month);
        selectDropdownOption(BirthYearField, year);
    }

    public void selectGender(String gender) {
        selectDropdownOption(genderField, gender);

    }
    public void enterPhoneNumber(String phoneNumber) {
        sendKeys(mobileNumberField, phoneNumber);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public void clickIHaveAnAccount() {
        click(iHaveAnAccountButton);
    }

    public void signup(User user) {

        enterFirstName(user.getFirstName());
        enterSurName(user.getSurName());

        selectBirthDate(
                user.getBirthDay(),
                user.getBirthMonth(),
                user.getBirthYear()
        );

        selectGender(user.getGender());
        enterPhoneNumber(user.getPhoneNumber());
        enterPassword(user.getPassword());

        clickSubmit();
    }
}
