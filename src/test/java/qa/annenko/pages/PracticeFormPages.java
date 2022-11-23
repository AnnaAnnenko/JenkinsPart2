package qa.annenko.pages;

import com.codeborne.selenide.SelenideElement;
import qa.annenko.pages.components.CalendarComponent;
import qa.annenko.pages.components.ResultsTableComponent;
import qa.annenko.pages.components.StateAndCityListComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPages {
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement userNumber = $("#userNumber");
    private SelenideElement gender = $("#genterWrapper");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement buttonSubmit = $("#submit");
    private SelenideElement stateList = $("#state");
    private SelenideElement cityList = $("#city");
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    StateAndCityListComponent stateAndCityListComponent = new StateAndCityListComponent();

    public PracticeFormPages openPage() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PracticeFormPages setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPages clearFirstName(String value) {
        firstNameInput.clear();

        return this;
    }

    public PracticeFormPages setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPages setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPages setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public PracticeFormPages setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public PracticeFormPages setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPages checkRegistrationTable(String key, String value) {
        resultsTableComponent.checkTable(key, value);

        return this;
    }

    public PracticeFormPages checkTableVisible() {
        resultsTableComponent.checkTableVisible();

        return this;
    }

    public PracticeFormPages setSubjectInput(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPages setHobbieInput(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPages uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPages setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public PracticeFormPages setStateInput(String value) {
        stateList.click();
        stateAndCityListComponent.selectFromList(value);

        return this;
    }

    public PracticeFormPages setCityInput(String value) {
        cityList.click();
        stateAndCityListComponent.selectFromList(value);

        return this;
    }

    public PracticeFormPages clickSubmit() {
        buttonSubmit.click();

        return this;
    }
}