package ru.netology.diplomaqamid.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.diplomaqamid.elements.News.getNewsElementsButtonCategoryFilter;
import static ru.netology.diplomaqamid.elements.News.getNewsElementsButtonDateEnd;
import static ru.netology.diplomaqamid.elements.News.getNewsElementsButtonDateStart;
import static ru.netology.diplomaqamid.elements.News.getNewsElementsButtonExpandNews;
import static ru.netology.diplomaqamid.elements.News.getNewsElementsButtonFilterNews;
import static ru.netology.diplomaqamid.elements.News.getNewsElementsButtonNews;
import static ru.netology.diplomaqamid.elements.News.getNewsElementsButtonOkDateStart;
import static ru.netology.diplomaqamid.elements.News.getNewsElementsButtonOkWrongMessage;
import static ru.netology.diplomaqamid.elements.News.getNewsElementsButtonSorting;
import static ru.netology.diplomaqamid.elements.News.getNewsElementsTitleFilterNews;

import io.qameta.allure.kotlin.Allure;
import ru.netology.diplomaqamid.elements.News;

public class NewsSteps {

    public static void clickButtonMainToolbar(){
        Allure.step("Нажать на Тулбар");
        onView(News.getAboutElementsButtonMainToolbar())
                .perform(click());
    }

    public static void clickButtonNews(){
        Allure.step("Нажать на кнопку Новости в Тулбар мобильного приложения");
        onView(getNewsElementsButtonNews())
                .perform(click());
    }

    public static void clickExpandNews(){
        Allure.step("Развернуть новость");
        onView(getNewsElementsButtonExpandNews())
                .perform(doubleClick());
    }

    public static void clickButtonSorting(){
        Allure.step("Нажать на кнопку сортировки новостей");
        onView(getNewsElementsButtonSorting())
                .perform(click());
    }

    public static void clickButtonFilterNews(){
        Allure.step("Нажать на кнопку Отфильтровать Новости");
        onView(getNewsElementsButtonFilterNews())
                .perform(click());
    }

    public static void clickButtonCategoryFilter(){
        Allure.step("Выбрать категорию для фильтрации новостей");
        onView(getNewsElementsButtonCategoryFilter())
                .perform(click());
    }

    public static void clickButtonDateStart(){
        Allure.step("Выбрать начальную дату");
        onView(getNewsElementsButtonDateStart())
                .perform(click());
    }

    public static void clickButtonOkDateStart(){
        Allure.step("Нажать кнопку ОК");
        onView(getNewsElementsButtonOkDateStart())
                .perform(click());
    }

    static String date = "11.05.2023";
    public static void clickButtonDateEnd(){
        Allure.step("Выбрать конечную дату");
        onView(getNewsElementsButtonDateEnd())
                .perform(replaceText(date));
    }

    public static void clickButtonOkWrongMessage(){
        Allure.step("Нажать на кнопку ОК в уведомлении об ошибке");
        onView(getNewsElementsButtonOkWrongMessage())
                .perform(click());
    }

    public static void clickButtonTitleFilterNews(){
        Allure.step("Нажать на кнопку Отфильтровать");
        onView(getNewsElementsTitleFilterNews())
                .check(matches(allOf(withText("Filter news"), isDisplayed())))
                .perform(click());
    }
}