package ru.netology.diplomaqamid.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.diplomaqamid.elements.Authorization;
import ru.netology.diplomaqamid.steps.AuthorizationSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Авторизация")
public class AuthorizationTest {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @Story("1")
    @Description("Авторизация в мобильном приложении (Positive Test)")
    public void successfulAuthorization () {
        SystemClock.sleep(5000);
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        Authorization.clickButtonExit(Authorization.getAuthorizationElementsButtonExit());
        AuthorizationSteps.clickButtonLogOut();
    }

    @Test
    @Story("2")
    @Description("Пустое поле Логин при авторизации в мобильном приложении (Negative Test)")
    public void loginFieldIsEmpty () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginEmpty();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    @Test
    @Story("3")
    @Description("Поле Логин заполнено данными несуществующего/незарегистрированного пользователя при авторизации в мобильном приложении (Negative Test)")
    public void loginFieldUnregisteredUser () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldUnregisteredUser();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later."), isDisplayed())); //Wrong login or password
    }

    @Test
    @Story("4")
    @Description("Поле Логин заполнено одним символом при авторизации в мобильном приложении (Negative Test)")
    public void LoginFieldOneLetter () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldOneLetter();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("5")
    @Description("Поле Логин заполнено спецсимволами при авторизации в мобильном приложении (Negative Test)")
    public void LoginFieldWithSpecialCharacters () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldWithSpecialCharacters();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("6")
    @Description("Поле Логин заполнено буквами разного регистра при авторизации в мобильном приложении (Negative Test)")
    public void LoginFieldLettersOfDifferentCase () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldLettersOfDifferentCase();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("7")
    @Description("В поле Логин поставлен пробел между букв при авторизации в мобильном приложении (Negative Test)")
    public void LoginFieldSpaceBetweenLetters () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldSpaceBetweenLetters();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("8")
    @Description("В поле Логин поставлен пробел в начале строки при авторизации в мобильном приложении (Negative Test)")
    public void LoginFieldSpaceAtTheBeginning () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldSpaceAtTheBeginning();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("9")
    @Description("В поле Логин поставлен пробел в конце строки при авторизации в мобильном приложении (Negative Test)")
    public void LoginFieldSpaceAtTheEnd () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldSpaceAtTheEnd();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }


    @Test
    @Story("10")
    @Description("Поле Логин заполнено иероглифами при авторизации в мобильном приложении (Negative Test)")
    public void LoginFieldWithHieroglyph () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldWithHieroglyph();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("11")
    @Description("Поле Логин заполнено символами с засечками при авторизации в мобильном приложении (Negative Test)")
    public void LoginFieldWithSerifCharacters () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldWithSerifCharacters();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("12")
    @Description("Поле Логин заполнено буквами с цифрами при авторизации в мобильном приложении (Negative Test)")
    public void LoginFieldWithCharactersAndNumbers () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldWithCharactersAndNumbers();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }
    @Test
    @Story("13")
    @Description("Ограничение на количество символов в поле Логин при авторизации в мобильном приложении (Negative Test)")
    public void RestrictionWhenManyLettersInLoginField () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickRestrictionWhenManyLettersInLoginField();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("14")
    @Description("В поле Логин поставлен дефис между букв при авторизации в мобильном приложении (Negative Test)")
    public void LoginFieldHyphenBetweenLetters () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldHyphenBetweenLetters();
        AuthorizationSteps.clickPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("15")
    @Description("Пустое поле Пароль при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldIsEmpty () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldIsEmpty();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    @Test
    @Story("16")
    @Description("Поле Пароль заполнено данными несуществующего/незарегистрированного пользователя при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldUnregisteredUser () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldUnregisteredUser();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("17")
    @Description("Поле Пароль заполнено одним символом при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldOneLetter () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldOneLetter();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("18")
    @Description("Поле Пароль заполнено спецсимволами при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldWithSpecialCharacters () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldWithSpecialCharacters();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("19")
    @Description("Поле Пароль заполнено буквами разного регистра при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldLettersOfDifferentCase () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldLettersOfDifferentCase();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }
    @Test
    @Story("20")
    @Description("В поле Пароль поставлен пробел между букв при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldSpaceBetweenLetters () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldSpaceBetweenLetters();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("21")
    @Description("В поле Пароль поставлен пробел в начале строки при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldSpaceAtTheBeginning () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldSpaceAtTheBeginning();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("22")
    @Description("В поле Пароль поставлен пробел в конце строки при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldSpaceAtTheEnd () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldSpaceAtTheEnd();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }


    @Test
    @Story("23")
    @Description("Поле Пароль заполнено иероглифами при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldWithHieroglyph () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldWithHieroglyph();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("24")
    @Description("Поле Пароль заполнено символами с засечками при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldWithSerifCharacters () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldWithSerifCharacters();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("25")
    @Description("Поле Пароль заполнено буквами с цифрами при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldWithCharactersAndNumbers () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldWithCharactersAndNumbers();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }
    @Test
    @Story("26")
    @Description("Ограничение на количество символов в поле Пароль при авторизации в мобильном приложении (Negative Test)")
    public void RestrictionWhenManyLettersInPasswordField () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickRestrictionWhenManyLettersInPasswordField();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }

    @Test
    @Story("27")
    @Description("В поле Пароль поставлен дефис между букв при авторизации в мобильном приложении (Negative Test)")
    public void PasswordFieldHyphenBetweenLetters () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldHyphenBetweenLetters();
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
        SystemClock.sleep(3000);
        onView(allOf(withContentDescription("Something went wrong. Try again later"), isDisplayed()));
    }
}