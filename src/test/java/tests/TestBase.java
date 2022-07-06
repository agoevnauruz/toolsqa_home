package tests;

import Pages.RegitrsationFormPage;
import Pages.components.CalendarComponent;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegitrsationFormPage regitrsationFormPage = new RegitrsationFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}