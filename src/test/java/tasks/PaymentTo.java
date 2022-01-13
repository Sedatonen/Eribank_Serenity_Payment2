package tasks;

import helper.HelperMethods;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import pages.HomePage;
import pages.PaymentPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class PaymentTo implements Task {

    @Override
    @Step("{0} logins to the eribank")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.PAYMENT_BTN, isClickable()).forNoMoreThan(3).seconds(),
                Click.on(HomePage.PAYMENT_BTN),

                WaitUntil.the(PaymentPage.COUNTRY_TEXT, isClickable()).forNoMoreThan(3).seconds(),
                Click.on(PaymentPage.PHONE_TEXT),
                SendKeys.of(HelperMethods.getRandomPhone()).into(PaymentPage.PHONE_TEXT),

                Click.on(PaymentPage.NAME_TEXT),
                SendKeys.of(HelperMethods.getRandomFirstname()).into(PaymentPage.NAME_TEXT),

                //Click.on(PaymentPage.AMOUNT),
                SendKeys.of(String.valueOf(HelperMethods.getRandomPrice())).into(PaymentPage.AMOUNT),

                Click.on(PaymentPage.COUNTRY_BTN),
                Click.on(PaymentPage.getCountry(HelperMethods.getRandomCountry())),
                //Click.on(PaymentPage.COUNTRY_TEXT),
                //SendKeys.of(this.country).into(PaymentPage.COUNTRY_TEXT),
                Click.on(PaymentPage.SEND_PAYMENT_BTN),
                WaitUntil.the(PaymentPage.SENDPAYMENTYES_BUTTON, isClickable()).forNoMoreThan(3).seconds(),
                Click.on(PaymentPage.SENDPAYMENTYES_BUTTON)
        );

    }

    public static PaymentTo info(Integer country) {
        return instrumented(PaymentTo.class,country);
    }
}
