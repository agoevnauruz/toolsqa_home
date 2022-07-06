package tests;

import Pages.RegitrsationFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormWithPageObjectsTests extends TestBase {


    @Test
    void successfulTest() {
        String firstName = "Neo";
        String lastName = "Rus";

        regitrsationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail("alex@egorov.com")
                .setGender("Other");
        regitrsationFormPage.setUserNumber("0123456789");
        regitrsationFormPage.setDateOfBirth("30", "May", "2000");
        regitrsationFormPage.setSubjectsInput("Maths");
        regitrsationFormPage.setHobbies("Sports");
        regitrsationFormPage.setUploadPicture("img/1.png");
        regitrsationFormPage.setCurrentAddress("Some street 1");
        regitrsationFormPage.setState("NCR");
        regitrsationFormPage.setCity("Delhi");
        regitrsationFormPage.setSubmit();

  //      $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        regitrsationFormPage
                .checkResult("Student name", firstName + " " +  lastName)
                .checkResult("Student email", "alex@egorov.com" )
                .checkResult("Date of Birth", "30 May,2000");
    }
}