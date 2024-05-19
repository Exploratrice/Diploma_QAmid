package ru.netology.diplomaqamid.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static ru.netology.diplomaqamid.elements.Main.getMainElementsButtonAllNews;

import io.qameta.allure.kotlin.Allure;

public class MainSteps {

    public static void clickButtonAllNews(){
        Allure.step("Нажать на кнопку ВСЕ НОВОСТИ");
        onView(getMainElementsButtonAllNews())
                .perform(click());
    }
}