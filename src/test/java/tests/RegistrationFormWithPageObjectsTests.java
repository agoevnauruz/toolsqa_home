package tests;

import org.junit.jupiter.api.Test;
import static tests.TestData.*;


public class RegistrationFormWithPageObjectsTests extends TestBase {


    @Test
    void successfulTest() {
        regitrsationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender()
                .setUserNumber(userNumber)
                .setDateOfBirth("30", "May", "2000")
                .setSubjectsInput()
                .setHobbies()
                .setUploadPicture()
                .setCurrentAddress(userAdress)
                .setState()
                .setCity()
                .setSubmit()
                .checkFormOpen()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", "Other")
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "30 May,2000")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", userAdress)
                .checkResult("State and City", "NCR" + " " + "Delhi");

    }
}