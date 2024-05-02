package stepdefs;


import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactListAddUserPage;
import pages.ContactListLogInPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CreateUserStepDefinitions {
    String firstName;
    String lastName;
    String email;
    String password;

    ContactListLogInPage logInPage = new ContactListLogInPage();
    ContactListAddUserPage addUserPage = new ContactListAddUserPage();
    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        Driver.getDriver().get(url);
        // Driver.getDriver().get(ConfigReader.getProperty("contact_list_url")); // this returns always same url
    }

    @When("user clicks on sign up button")
    public void userClicksOnSignUpButton() {
        logInPage.signupButton.click();


    }

    @And("User enters firstname, lastname, email, password")
    public void userEntersFirstnameLastnameEmailPassword() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        password ="Password.123";

        addUserPage.firstNameFiled.sendKeys(firstName);
        addUserPage.lastNameFiled.sendKeys(lastName);
        addUserPage.emailField.sendKeys(email);
        addUserPage.passwordField.sendKeys(password);

    }

    @And("user clicks on submit button")
    public void userClicksOnSubmitButton() {
        addUserPage.submitButton.click();
    }

    @And("user closes browser")
    public void userClosesBrowser() {
        Driver.tearDown();
    }

    @Then("verify the user via API request")
    public void verifyTheUserViaAPIRequest() {
    }
}