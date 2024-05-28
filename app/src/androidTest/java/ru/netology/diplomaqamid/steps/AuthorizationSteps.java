package ru.netology.diplomaqamid.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.netology.diplomaqamid.elements.Authorization.getAuthorizationElementsButtonLogOut;
import static ru.netology.diplomaqamid.elements.Authorization.getAuthorizationElementsLoginField;
import static ru.netology.diplomaqamid.elements.Authorization.getAuthorizationElementsPasswordField;
import static ru.netology.diplomaqamid.elements.Authorization.getAuthorizationElementsTextAuthorization;

import io.qameta.allure.kotlin.Allure;

public class AuthorizationSteps {

    public static void clickButton(Integer resourceId){
        Allure.step("Нажать на кнопку Войти");
        onView(withId(resourceId))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    public static void clickLoginField(){
        Allure.step("В поле Логин ввести: login2");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("login2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordField(){
        Allure.step("В поле Пароль ввести: password2");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("password2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickButtonExit(Integer resourceId) {
        Allure.step("Нажать на кнопку Выход");
        onView(withId(resourceId))
                .perform(click());
    }

    public static void clickButtonLogOut(){
        Allure.step("Нажать на кнопку для выхода из приложения");
        onView(getAuthorizationElementsButtonLogOut())
                .perform(click());
    }

    public static void textAuthorization(){
        Allure.step("Отобразилаcь страница Авторизации");
        onView(getAuthorizationElementsTextAuthorization())
                .check(matches(isDisplayed()));
    }

    public static void clickLoginEmpty() {
        Allure.step("Поле Логин оставить пустым");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText(" "), closeSoftKeyboard());
    }

    public static void clickLoginFieldUnregisteredUser() {
        Allure.step("Ввести в поле Логин данные несуществующего/незарегистрированного");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("log1234"), closeSoftKeyboard());
    }

    public static void clickLoginFieldOneLetter() {
        Allure.step("Ввести в поле Логин один символ");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("l"), closeSoftKeyboard());
    }
    public static void clickLoginFieldWithSpecialCharacters() {
        Allure.step("Ввести в поле Логин спецсимволы");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("%$*@&(*^"), closeSoftKeyboard());
    }

    public static void clickLoginFieldLettersOfDifferentCase() {
        Allure.step("Ввести в поле Логин буквы разного регистра");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("LOgin2"), closeSoftKeyboard());
    }

    public static void clickLoginFieldSpaceBetweenLetters() {
        Allure.step("Поставить пробел между букв в поле Логин");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("login 2"), closeSoftKeyboard());
    }

    public static void clickLoginFieldSpaceAtTheBeginning() {
        Allure.step("Поставить пробел в начале строки в поле Логин");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText(" login2"), closeSoftKeyboard());
    }

    public static void clickLoginFieldSpaceAtTheEnd() {
        Allure.step("Поставить пробел в конце строки в поле Логин");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("login2 "), closeSoftKeyboard());
    }

    public static void clickLoginFieldWithHieroglyph() {
        Allure.step("Ввести в поле Логин иероглифы");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("円炎"), closeSoftKeyboard());
    }

    public static void clickLoginFieldWithSerifCharacters() {
        Allure.step("Ввести в поле Логин символы с засечками");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("čárkou"), closeSoftKeyboard());
    }

    public static void clickLoginFieldWithCharactersAndNumbers() {
        Allure.step("Ввести в поле Логин буквы и цифры");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("login12345"), closeSoftKeyboard());
    }

    public static void clickRestrictionWhenManyLettersInLoginField() {
        Allure.step("Ввести в поле Логин большое количество символов");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("fdfgdkfjhkdghfgkhfjkjfkghfkhfjkvfjvbzkvbzjvbsjkfhkjdvd"), closeSoftKeyboard());
    }

    public static void clickLoginFieldHyphenBetweenLetters() {
        Allure.step("Поставить дефис между букв в поле Логин");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("log-in"), closeSoftKeyboard());
    }

    public static void clickPasswordFieldIsEmpty(){
        Allure.step("Поле Пароль оставить пустым");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText(" "), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldUnregisteredUser(){
        Allure.step("Ввести в поле Пароль данные несуществующего/незарегистрированного пользователя");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("pass1234"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldOneLetter(){
        Allure.step("Ввести в поле Пароль один символ");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("p"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldWithSpecialCharacters(){
        Allure.step("Ввести в поле Пароль спецсимволы");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("%$*@&(*^"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldLettersOfDifferentCase(){
        Allure.step("Ввести в поле Пароль буквы разного регистра");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("PasSWord2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldSpaceBetweenLetters() {
        Allure.step("Ввести в поле Пароль пробел в середине");
        onView(getAuthorizationElementsPasswordField())
                .perform(replaceText("password 2"), closeSoftKeyboard());
    }

    public static void clickPasswordFieldSpaceAtTheBeginning() {
        Allure.step("Поставить пробел в начале строки в поле Пароль");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText(" password2"), closeSoftKeyboard());
    }

    public static void clickPasswordFieldSpaceAtTheEnd() {
        Allure.step("Поставить пробел в конце строки в поле Пароль");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("password2 "), closeSoftKeyboard());
    }

    public static void clickPasswordFieldWithHieroglyph() {
        Allure.step("Ввести в поле Пароль иероглифы");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("円炎"), closeSoftKeyboard());
    }

    public static void clickPasswordFieldWithSerifCharacters() {
        Allure.step("Ввести в поле Пароль символы с засечками");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("čárkou"), closeSoftKeyboard());
    }

    public static void clickPasswordFieldWithCharactersAndNumbers() {
        Allure.step("Ввести в поле Пароль буквы и цифры");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("password12345"), closeSoftKeyboard());
    }

    public static void clickRestrictionWhenManyLettersInPasswordField() {
        Allure.step("Ввести в поле Пароль большое количество символов");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("fdfgdkfjhkdghfgkhfjkjfkghfkhfjkvfjvbzkvbzjvbsjkfhkjdvd"), closeSoftKeyboard());
    }

    public static void clickPasswordFieldHyphenBetweenLetters() {
        Allure.step("Поставить дефис между букв в поле Пароль");
        onView(getAuthorizationElementsLoginField())
                .perform(replaceText("pass-word"), closeSoftKeyboard());
    }
}