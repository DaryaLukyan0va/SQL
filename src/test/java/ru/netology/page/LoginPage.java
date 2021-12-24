package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.domain.User;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("input[name=\"login\"]");
    private final SelenideElement passwordField = $("input[name=\"password\"]");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(User.AuthInfo loginInfo) {
        loginField.setValue(loginInfo.getLogin());
        passwordField.setValue(loginInfo.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public void cleanLoginFields() {
        loginField.doubleClick().sendKeys(Keys.BACK_SPACE);
        passwordField.doubleClick().sendKeys(Keys.BACK_SPACE);
    }
}
