package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.ro.Si;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.BaseClass;
import pageObjects.CreateAnAccountPage;
import pageObjects.SignInPage;
import utilities.RandomStringGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Steps extends BaseClass {

    @Before
    public void setUp() throws IOException {

        configprop = new Properties();
        FileInputStream configpropfile = new FileInputStream("config.properties");
        configprop.load(configpropfile);

        if (configprop.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        if (configprop.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Given("I am on the Magento homepage")
    public void i_am_on_the_magento_homepage() {
        driver.get(configprop.getProperty("url"));
    }
    @When("I click on {string} link")
    public void i_click_on_the_link(String title) {
        caap = new CreateAnAccountPage(driver);
        caap.clickOnCreateAnAccountLink();
    }

    @And("I land on {string} page")
    public void i_land_on_the_page(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @When("I enter my first name {string}")
    public void i_enter_my_first_name(String fname) {
        caap.setFirstName(fname);
    }

    @When("I enter my last name {string}")
    public void i_enter_my_last_name(String lname) {
        caap.setLastName(lname);
    }

    @When("I enter a valid email address")
        public void i_enter_a_valid_email_address (){
            caap.setEmail(RandomStringGenerator.randomEmail());
    }

    @When("I enter a valid email address {string}")
    public void i_enter_a_valid_email_address(String validemail) {
        caap.setEmail(validemail);
    }

    @When("I enter a valid password {string}")
    public void i_enter_a_valid_password(String vldpwd) {
        caap.setPassword(vldpwd);
    }

    @When("I confirm the password {string}")
    public void i_confirm_the_password(String cnfpwd) {
        caap.setConfirmPassword(cnfpwd);
    }

    @When("I click the 'Create An Account' button")
    public void i_click_the_create_an_account_button() throws InterruptedException {
        caap.clickOnCreateAnAccountButton();
        Thread.sleep(5000);
    }

    @Then("I should be redirected to the {string} page")
    public void i_should_be_redirected_to_the_page(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @Then("I should see a welcome message {string}")
    public void i_should_see_a_welcome_message(String cnfmsg) {
        Assert.assertEquals(cnfmsg, caap.getConfirmationMessage());
    }

    @When("I enter an email address {string} that is already registered")
    public void i_enter_an_email_address_that_is_already_registered(String existingemail) {
        caap.setEmail(existingemail);
    }

    @When("I enter a password {string}")
    public void i_enter_a_password(String pwd) {
        caap.setPassword(pwd);
    }

    @When("I leave the first name field blank")
    public void i_leave_the_first_name_field_blank() {
        caap.setFirstName(" ");
    }

    @When("I enter an invalid email address {string}")
    public void i_enter_an_invalid_email_address(String invalidemail) {
        caap.setEmail(invalidemail);
    }

    @When("I enter a weak password {string}")
    public void i_enter_a_weak_password(String weakpwd) {
        caap.setPassword(weakpwd);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String errmsg) {
        Assert.assertEquals(errmsg, caap.getErrorMessage());
    }

    @Then("I should see password mismatch error message {string}")
    public void i_should_see_password_mismatch_error_message(String pwderrmsg) {
        Assert.assertEquals(pwderrmsg, caap.getPasswordMismatchErrorMessage());
    }

    @Then("I should see first name error message {string}")
    public void i_should_see_first_name_error_message(String firstnameerror) {
        Assert.assertEquals(firstnameerror, caap.getFirstNameErrorMessage());
    }

    @Then("I should see email error message {string}")
    public void i_should_see_email_error_message(String emailerrmsg) {
        Assert.assertEquals(emailerrmsg, caap.getEmailErrorMessage());
    }

    @Then("I should see password strength error message {string}")
    public void i_should_see_password_strength_error_message(String pwdstrmsg) {
        Assert.assertEquals(pwdstrmsg, caap.getPasswordStrengthErrorMessage());
    }

    @When("I click on the {string} link")
    public void i_click_the_link(String string) {
        sip = new SignInPage(driver);
        sip.clickOnSignInLink();
    }

    @When("I enter a valid email {string} and password {string}")
    public void i_enter_a_valid_email_and_password(String mail, String pwd) {
        sip.setEmail(mail);
        sip.setPassword(pwd);
    }

    @When("I enter an invalid email format {string} and password {string}")
    public void i_enter_an_invalid_email_format_and_password(String mail, String pwd) {
        sip.setEmail(mail);
        sip.setPassword(pwd);
    }

    @When("I click the 'Sign In' button")
    public void i_click_Sign_In_the_button() throws InterruptedException {
        sip.clickOnSignInButton();
        Thread.sleep(5000);
    }

    @When("I enter an invalid email {string} and password {string}")
    public void i_enter_an_invalid_email_and_password(String invmail, String invpwd) {
        sip.setEmail(invmail);
        sip.setPassword(invpwd);
    }

    @When("I leave the email and password fields empty")
    public void i_leave_the_email_and_password_fields_empty() {
        sip.setEmail("");
        sip.setPassword("");
    }
    @Then("I should see validation errors for both fields:")
    public void i_should_see_validation_errors_for_both_fields(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> expectedErrors = dataTable.asMap(String.class, String.class);

        for (Map.Entry<String, String> entry : expectedErrors.entrySet()) {
            String actualErrorMessage="";

            String expectedErrorMessage = entry.getValue();

            if(entry.getKey().trim().equals("Email Address"))
                actualErrorMessage = sip.getEmptyEmailError();
            if(entry.getKey().trim().equals("Password"))
                actualErrorMessage = sip.getEmptyPasswordError();

            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        }
    }

    @Then("I should see sign in error message {string}")
    public void i_should_see_sign_in_error_message(String signinerrmsg) {
        Assert.assertEquals(signinerrmsg, sip.getSignInErrorMessage());
    }

    @Then("I should see invalid email error message {string}")
    public void i_should_see_invalid_email_error_message(String invalidemailerrmsg) {
        Assert.assertEquals(invalidemailerrmsg, sip.getEmailErrorMessage());
    }

    @Then("I should be see the message {string}")
    public void i_should_be_see_the_message(String loginmsg) {
        Assert.assertEquals(loginmsg, sip.getLoginMessage());
    }
}
