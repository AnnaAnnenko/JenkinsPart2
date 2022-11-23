package qa.annenko.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.annenko.pages.PracticeFormPages;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TestForPracticeFormWithTestData extends TestBase {
    PracticeFormPages practiceFormPages = new PracticeFormPages();

    @Test
    @Owner("abramova")
    @Feature("practice form")
    @Story("заполнение формы")
    @DisplayName("Проверка, что форма сохраняется в соответствии с введенными значениями")
    public void checkFieldsOfForm() {

        step("Открываем страницу заполнения формы", () -> {
            practiceFormPages.openPage();
        });

        step("Заполняем форму данными", () -> {
            practiceFormPages.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setUserNumber(phone)
                    .setDateOfBirth(day, month, year)
                    .setSubjectInput(subject)
                    .setHobbieInput(hobbie)
                    .uploadPicture(picture)
                    .setCurrentAddressInput(address)
                    .setStateInput(state).setCityInput(city)
                    .clickSubmit();
        });

        step("Проверяем, что форма заполнилась корректно", () -> {
            practiceFormPages.checkTableVisible()
                    .checkRegistrationTable("Student Name", firstName + " " + lastName)
                    .checkRegistrationTable("Student Email", email)
                    .checkRegistrationTable("Gender", gender)
                    .checkRegistrationTable("Mobile", phone)
                    .checkRegistrationTable("Subjects", subject)
                    .checkRegistrationTable("Address", address)
                    .checkRegistrationTable("Picture", picture)
                    .checkRegistrationTable("Hobbies", hobbie)
                    .checkRegistrationTable("Date of Birth", day + " " + month + "," + year)
                    .checkRegistrationTable("State and City", state + " " + city);
        });
    }
}