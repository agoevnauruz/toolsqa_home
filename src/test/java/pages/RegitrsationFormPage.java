package pages;

import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegitrsationFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public RegitrsationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
        public RegitrsationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
            return this;
    }
        public RegitrsationFormPage setLastName(String value) {
        $("#lastName").setValue(value);
            return this;
    }
        public RegitrsationFormPage setUserEmail(String value) {
            $("#userEmail").setValue("alex@egorov.com");
            return this;
    }
        public RegitrsationFormPage setGender(String value) {
        $("#genterWrapper").$(byText("Other")).click();
            return this;
    }
    public RegitrsationFormPage setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }
        public RegitrsationFormPage setDateOfBirth (String day, String month, String year) {
            $("#dateOfBirthInput").click();
            calendarComponent.setDate(day, month, year);
            return this;
    }
    public RegitrsationFormPage setSubjectsInput(String value){
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        return this;
    }
    public RegitrsationFormPage setHobbies(String value){
       $(byText("Sports")).click();
        return this;
    }
    public RegitrsationFormPage setUploadPicture (String value){
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        return this;
    }
    public RegitrsationFormPage setCurrentAddress (String value){
        $("#currentAddress").setValue("Some street 1");
        return this;
    }
    public RegitrsationFormPage setState (String value){
        $("#state").click();
        $(byText("NCR")).click();
        return this;
    }
    public RegitrsationFormPage setCity (String value){
        $("#city").click();
        $(byText("Delhi")).click();
        return this;
    }
    public RegitrsationFormPage setSubmit (){
        $("#submit").click();
        return this;
    }
    public RegitrsationFormPage checkFormOpen(String value){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }
    public RegitrsationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}
