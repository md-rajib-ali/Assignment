package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public WebDriver mydriver;

    public SignInPage(WebDriver wdriver) {
        mydriver = wdriver;
        PageFactory.initElements(wdriver, this);
    }

    By lnkSignIn = By.xpath("//a[contains(text(), 'Sign In')]");
    By txtEmail = By.xpath("//input[@id='email']");
    By txtPassword = By.xpath("//input[@id='pass']");
    By btnSignIn = By.xpath("//button[@id='send2']");
    By msgSignInError = By.xpath("//div[@role='alert']");
    By msgEmptyEmailError = By.xpath("//div[@id='email-error']");
    By msgEmptyPasswordError = By.xpath("//div[@id='pass-error']");
    By msgEmailError = By.xpath("//div[@id='email-error']");
    By msgLogin = By.xpath("//span[@class='logged-in']");

    public void clickOnSignInLink() {
        mydriver.findElement(lnkSignIn).click();
    }

    public void setEmail(String email) {
        mydriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        mydriver.findElement(txtPassword).sendKeys(password);
    }

    public void clickOnSignInButton() {
        mydriver.findElement(btnSignIn).click();
    }

    public String  getSignInErrorMessage(){
        return mydriver.findElement(msgSignInError).getText();
    }

    public String  getEmptyEmailError(){
        return mydriver.findElement(msgEmptyEmailError).getText();
    }

    public String  getEmptyPasswordError(){
        return mydriver.findElement(msgEmptyPasswordError).getText();
    }

    public String getEmailErrorMessage() {
        return mydriver.findElement(msgEmailError).getText();
    }

    public String getLoginMessage() {
        return mydriver.findElement(msgLogin).getText();
    }

}
