package ru.netology.diplomaqamid.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static ru.netology.diplomaqamid.elements.Quotes.getQuotesElementsButtonExpandThematicQuote;
import static ru.netology.diplomaqamid.elements.Quotes.getQuotesElementsButtonExpandTwoThematicQuotes;
import static ru.netology.diplomaqamid.elements.Quotes.getQuotesElementsButtonThematicQuote;

import io.qameta.allure.kotlin.Allure;

public class QuotesSteps {

    public static void clickButtonThematicQuote(){
        Allure.step("Нажать на кнопку Тематические цитаты");
        onView(getQuotesElementsButtonThematicQuote())
                .perform(click());
    }

    public static void clickButtonExpandThematicQuote(){
        Allure.step("Развернуть тематическую цитату");
        onView(getQuotesElementsButtonExpandThematicQuote())
                .perform(click());
    }

    public static void clickButtonExpandTwoThematicQuotes(){
        Allure.step("Развернуть две тематические цитаты");
        onView(getQuotesElementsButtonExpandTwoThematicQuotes())
                .perform(click());
    }
}