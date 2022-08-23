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
            $("#userEmail").setValue(value);
            return this;
    }
        public RegitrsationFormPage setGender() {
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
    public RegitrsationFormPage setSubjectsInput(){
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        return this;
    }
    public RegitrsationFormPage setHobbies(){
       $(byText("Sports")).click();
        return this;
    }
    public RegitrsationFormPage setUploadPicture (){
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        return this;
    }
    public RegitrsationFormPage setCurrentAddress (String value){
        $("#currentAddress").setValue(value);
        return this;
    }
    public RegitrsationFormPage setState (){
        $("#state").click();
        $(byText("NCR")).click();
        return this;
    }
    public RegitrsationFormPage setCity (){
        $("#city").click();
        $(byText("Delhi")).click();
        return this;
    }
    public RegitrsationFormPage setSubmit (){
        $("#submit").click();
        return this;
    }
    public RegitrsationFormPage checkFormOpen(){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }
    public RegitrsationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}
