
package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.Data.correctLogin;
import static ru.iteco.fmhandroid.ui.data.Data.correctPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.checkToast;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitElement;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitUntilVisible;

import androidx.test.espresso.NoMatchingViewException;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;

public class AuthorizationSteps {
    public int enterButtonId = R.id.enter_button;
    public int LoginOutId = R.id.authorization_image_button;
    public int title = android.R.id.title;

    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Step("Авторизация валидными данными")
    public void login(String login, String password) {
        Allure.step("Авторизация валидными данными");
        waitElement(enterButtonId);
        authorizationPage.loginField.perform(replaceText(login));
        authorizationPage.passwordField.perform(replaceText(password));
        authorizationPage.loginButton.check(matches(isDisplayed())).perform(click());
    }
    @Step("Выход из аккаунта")
    public void logout() {
        Allure.step("Выход из аккаунта");
        onView(withId(LoginOutId)).perform(click());
        onView(withId(title)).check(matches(isDisplayed()));
        onView(withId(title)).perform(click());
    }

    public void checkLogInAndLogInIfNot() {
        if (logIn()) {
            login(correctLogin, correctPassword);
        }
    }

    @Step("Проверить видимость кнопки выхода из аккаунта.")
    public void logOutIsVisible() {
        authorizationPage.logOutButton.check(matches(isDisplayed()));
    }

    @Step("Выход из аккаунта")
    public void checkLogOutAndLogOutIfNot() {
        if (logOut()) {
            logout();
        }
    }

    @Step("Проверить сообщение о недопустимости входа с незаполненными логином или паролем")
    public void emptyLoginAndPassword() {
        Allure.step("Проверить наличие всплывающего сообщения при пустом логине и пароле");
        waitUntilVisible(checkToast(R.string.empty_login_or_password, true));
    }

    @Step("Проверить сообщение о неверном логине или пароле")
    public void loginOrPasswordIsWrong() {
        Allure.step("Проверить наличие всплывающего сообщения при невалидном логине и пароле");
        waitUntilVisible(checkToast(R.string.error, true));
    }

    public boolean logIn() {
        boolean check = false;
        try {
            waitElement(enterButtonId);
            authorizationPage.loginField.check(matches(isDisplayed()));
            check = true;
            return check;
        } catch (NoMatchingViewException e) {
            check = false;
            return check;
        } finally {
            return check;
        }
    }

    public boolean logOut() {
        boolean check = false;
        try {
            waitElement(LoginOutId);
            logOutIsVisible();
            check = true;
            return check;
        } catch (NoMatchingViewException e) {
            check = false;
            return check;
        } finally {
            return check;
        }
    }
}
