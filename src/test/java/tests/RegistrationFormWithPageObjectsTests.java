package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationFormWithPageObjectsTests extends TestBase {


    @Test
    void successfulTest() {
        String firstName = "Neo";
        String lastName = "Rus";
        regitrsationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail("alex@egorov.com")
                .setGender("Other")
                .setUserNumber("0123456789")
                .setDateOfBirth("30", "May", "2000")
                .setSubjectsInput("Maths")
                .setHobbies("Sports")
                .setUploadPicture("img/1.png")
                .setCurrentAddress("Some street 1")
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit()
                .checkFormOpen("Thanks for submitting the form")
                .checkResult("Student name", firstName + " " +  lastName)
                .checkResult("Student email", "alex@egorov.com" )
                .checkResult("Date of Birth", "30 May,2000");
    }
}