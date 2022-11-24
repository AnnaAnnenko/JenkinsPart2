package qa.annenko.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.annenko.helpers.Attach;
import qa.annenko.properties.Properties;
import qa.annenko.utils.Randoms;

public class TestBase {
    Faker faker = new Faker();
    Randoms randoms = new Randoms();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(10,30)),
            month = String.valueOf(randoms.getRandomMonth()),
            year = String.valueOf(faker.number().numberBetween(1990,2022)),
            subject = "History",
            hobbie = "Reading",
            picture = "1.png",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = Properties.browser();
        Configuration.browserVersion  = Properties.browserVersion();
        Configuration.browserSize = Properties.screenSize();
        if (!Properties.remoteBrowser().equals("")) {
            Configuration.remote = Properties.remoteBrowser();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }

    @AfterEach
    void Attachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}