package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestBase{
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1800x900";
    }

    @Test
    void qaapf() {

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Neo");

        $("#lastName").setValue("Rus");

        $("#userEmail").setValue("neorus@gmail.com");

        $(byText("Other")).click();

        $("#userNumber").setValue("0123456789");

        $("#dateOfBirthInput").click();

        $(byText("2000")).scrollIntoView(true).click();
        $(byText("May")).click();
        $(byText("1")).click();

        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").sendKeys("English");
        $("#subjectsInput").pressEnter();

        $(byText("Reading")).click();
        $(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("img.jpg");

        $("#currentAddress").setValue("Avenue 1");

        $("#state").click();
        $(byText("Haryana")).click();

        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();

        $(".modal-content").shouldHave(
                text("Neo"),
                text("Rus"),
                text("neorus@gmail.com"),
                text("Other"),
                text("1 May,2000"),
                text("Reading, Music"),
                text("img.jpg"),
                text("Avenue 1"),
                text("Haryana"),
                text("Karnal"),
                text("English"));

    }


}