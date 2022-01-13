package steps;

import helper.HelperMethods;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.PaymentPage;
import tasks.LoginToEriBank;
import tasks.PaymentTo;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class AuthSteps {
    public static int balance;

    @Managed(driver = "Appium")

    public WebDriver herMobileDevice;

    String actorName = "sedat";
    Actor actor = Actor.named(actorName);

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Open browser and homepage screen")
    public void open_browser_and_homepage_screen() {
        actor.can(BrowseTheWeb.with(herMobileDevice));

    }

    @When("Login with company username {string} and password {string}")
    public void login_with_company_username_and_password(String username, String password) {
        actor.attemptsTo(LoginToEriBank.login(username, password));

    }

    @When("Make payment with random phone,name,payments and countries")
    public void make_payment_with_random_phone_name_payments_and_countries() {
        actor.attemptsTo(PaymentTo.info());
        balance = 100;
        balance = balance - HelperMethods.getRandomPrice();
    }

    @Then("Should see that log out page")
    public void should_see_that_log_out_page() throws InterruptedException {
        Thread.sleep(1500);
//        actor.should(
//                GivenWhenThen.seeThat(the(PaymentPage.getLastBalance(balance))
//                        , containsText("Your balance is: "+balance+".00$")));
        Ensure.that(PaymentPage.getLastBalance(balance)).isDisplayed();
    }


}
