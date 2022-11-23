package qa.annenko.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityListComponent {

    public StateAndCityListComponent selectFromList(String value){
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }
}