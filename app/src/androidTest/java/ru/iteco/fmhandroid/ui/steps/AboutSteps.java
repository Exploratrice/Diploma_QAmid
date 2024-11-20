package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pages.AboutPage;

public class AboutSteps {
    AboutPage aboutScreen = new AboutPage();

    @Step("Проверить наличие раздела About")
    public void isAppVersionDisplayed() {
        Allure.step("Проверить наличие сведений о версии приложения");
        aboutScreen.versionText.check(matches(isDisplayed()));
        aboutScreen.versionInfo.check(matches(isDisplayed()));
    }

    @Step("Проверить наличие сведений о Privacy Policy")
    public void isAppPrivacyPolicyDisplayed() {
        Allure.step("Проверить наличие сведений о политике конфиденциальности");
        aboutScreen.aboutPrivacy.check(matches(isDisplayed()));
    }
}