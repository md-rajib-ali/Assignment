package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage{
    public WebDriver mydriver;

    public CreateAnAccountPage(WebDriver wdriver) {
        mydriver = wdriver;
        PageFactory.initElements(wdriver, this);
    }

    By lnkCreateAnAccount = By.xpath("//a[contains(text(), 'Create an Account')]");
    By txtFirstName = By.xpath("//input[@name='firstname']");
    By txtLastName = By.xpath("//input[@name='lastname']");
    By txtEmail = By.xpath("//input[@name='email']");
    By txtPassword = By.xpath("//input[@id='password']");
    By txtConfirmPassword = By.xpath("//input[@name='password_confirmation']");
    By btnCreateAnAccount = By.xpath("//button[@title= 'Create an Account']");
    By msgConfirmation = By.xpath("//div[@role='alert']");
    By msgError = By.xpath("//div[@role='alert']");
    By msgPasswordMismatchError = By.xpath("//div[@id='password-confirmation-error']");
    By msgFirstNameError = By.xpath("//div[@id='firstname-error']");
    By msgEmailError = By.xpath("//div[@id='email_address-error']");
    By msgPasswordStrengthError = By.xpath("//div[@id='password-error']");

    public void clickOnCreateAnAccountLink() {
        mydriver.findElement(lnkCreateAnAccount).click();
    }

    public void setFirstName(String firstname) {
        mydriver.findElement(txtFirstName).sendKeys(firstname);
    }

    public void setLastName(String lastname) {
        mydriver.findElement(txtLastName).sendKeys(lastname);
    }

    public void setEmail(String email) {
        mydriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        mydriver.findElement(txtPassword).sendKeys(password);
    }

    public void setConfirmPassword(String confirmpassword) {
        mydriver.findElement(txtConfirmPassword).sendKeys(confirmpassword);
    }

    public void clickOnCreateAnAccountButton() {
        mydriver.findElement(btnCreateAnAccount).click();
    }

    public String getConfirmationMessage() {
        return mydriver.findElement(msgConfirmation).getText();
    }

    public String getErrorMessage() {
        return mydriver.findElement(msgError).getText();
    }

    public String getPasswordMismatchErrorMessage() {
        return mydriver.findElement(msgPasswordMismatchError).getText();
    }

    public String getFirstNameErrorMessage() {
        return mydriver.findElement(msgFirstNameError).getText();
    }

    public String getEmailErrorMessage() {
        return mydriver.findElement(msgEmailError).getText();
    }

    public String getPasswordStrengthErrorMessage() {
        return mydriver.findElement(msgPasswordStrengthError).getText();
    }
}
