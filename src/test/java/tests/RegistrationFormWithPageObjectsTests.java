package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static tests.TestData.*;
import static tests.TestData.userAdress;


public class RegistrationFormWithPageObjectsTests extends TestBase {


    @Test
    void successfulTest() {
        regitrsationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender("Other")
                .setUserNumber(TestData.userNumber)
                .setDateOfBirth("30", "May", "2000")
                .setSubjectsInput("Maths")
                .setHobbies("Sports")
                .setUploadPicture("img/1.png")
                .setCurrentAddress("Some street 1")
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit()
                .checkFormOpen("Thanks for submitting the form")
                .checkResult("Student Name", firstName )
                .checkResult("Student Name", lastName)
                .checkResult("Student Email", userEmail )
                .checkResult("Gender", "Other" )
                .checkResult("Mobile", userNumber )
                .checkResult("Date of Birth", "30 May,2000")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "Some street 1")
                .checkResult("State and City", "NCR" + "Delhi");
    }
}