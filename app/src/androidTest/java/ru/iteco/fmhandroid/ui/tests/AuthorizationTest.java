package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.correctLogin;
import static ru.iteco.fmhandroid.ui.data.Data.correctPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.generateScreenshotName;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitElement;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.data.Data;
import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;


@Epic("Тестирование страницы авторизации приложения")
@RunWith(AllureAndroidJUnit4.class)
//@RunWith(AndroidJUnit4.class)

public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();

    @Before
    public void setUp() {

        authorizationSteps.checkLogOutAndLogOutIfNot();
    }

    @Test
    @DisplayName("Авторизация с валидными логином и паролем")
    public void correctLoginAndPasswordAuthorizationTest() {
        authorizationSteps.login(correctLogin, correctPassword);
        waitElement(authorizationSteps.LoginOutId);
        mainSteps.logOutIsVisible();
    }

    @Test
    @DisplayName("Авторизация с незаполненными полями логина и пароля")
    public void emptyLoginAndPasswordAuthorizationTest() {
        authorizationSteps.login("", "");
        authorizationSteps.emptyLoginAndPassword();
    }

    @Test
    @DisplayName("Ввод валидного логина и невалидого пароля при авторизации")
    public void correctLoginWrongPasswordAuthorizationTest() {
        authorizationSteps.login(Data.correctLogin, Data.wrongPassword);
        authorizationSteps.loginOrPasswordIsWrong();
    }

    @Test
    @DisplayName("Ввод невалидного логина и валидого пароля при авторизации")
    public void wrongLoginWrongCorrectPasswordAuthorizationTest() {
        authorizationSteps.login(Data.wrongLogin, Data.correctPassword);
        authorizationSteps.loginOrPasswordIsWrong();
    }

    @Test
    @DisplayName("Ввод валидного логина и пустого пароля при авторизации")
    public void correctLoginEmptyPasswordAuthorizationTest() {
        authorizationSteps.login(Data.correctLogin, "");
        authorizationSteps.emptyLoginAndPassword();
    }

    @Test
    @DisplayName("Ввод пустого логина и валидного пароля при авторизации")
    public void emptyLoginCorrectPasswordAuthorizationTest() {
        authorizationSteps.login("", Data.correctPassword);
        authorizationSteps.emptyLoginAndPassword();
    }
}