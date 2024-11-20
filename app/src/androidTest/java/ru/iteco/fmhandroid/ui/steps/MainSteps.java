package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitElement;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;

import org.junit.Assert;

import ru.iteco.fmhandroid.ui.data.DataHelper;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.QuotesPage;
import ru.iteco.fmhandroid.ui.pages.NewsEditPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

public class MainSteps {
    public static int mainMenuButtonId = R.id.main_menu_image_button;
    public static int allNewsButton = R.id.all_news_text_view;
    public static int quotesButtID = R.id.our_mission_image_button;
    MainPage mainPage = new MainPage();
    AboutPage aboutPage = new AboutPage();
    QuotesPage quotesPage = new QuotesPage();
    NewsEditPage newsEditPage = new NewsEditPage();
    NewsPage newsPage = new NewsPage();

    @Step("Перейти в раздел Новости через главное меню")
    public void goToNewsPage() {
        Allure.step("Перейти в раздел Новости через главное меню");
        waitElement(mainMenuButtonId);
        mainPage.mainMenuButton.perform(click());
        mainPage.newsButton.check(matches(isDisplayed()));
        mainPage.newsButton.perform(click());
    }

    @Step("Перейти в раздел Новости с помощью кнопки в меню навигации приложения ")
    public void goToNewsPageWithPressNavigationMenuButton() {
        Allure.step("Перейти в раздел Новости с помощью кнопки в меню навигации приложения");
        waitElement(allNewsButton);
        mainPage.allNewsButton.perform(click());
    }

    @Step("Перейти в раздел О приложении с помощью кнопки в меню навигации приложения ")
    public void goToAboutPage() {
        Allure.step("Перейти в раздел О приложении с помощью кнопки в меню навигации приложения ");
        waitElement(mainMenuButtonId);
        mainPage.mainMenuButton.perform(click());
        mainPage.aboutButton.check(matches(isDisplayed()));
        mainPage.aboutButton.perform(click());
    }

    @Step("Перейти в раздел Цитаты с помощью кнопки на главной странице приложения ")
    public void goToQuotesPage() {
        Allure.step("Перейти в раздел Цитаты с помощью кнопки на главной странице приложения ");
        waitElement(quotesButtID);
        mainPage.quotesButton.perform(click());
    }

    @Step("Перейти в раздел Новости с помощью кнопки на главной странице приложения ")
    public void goToNewsPageWithPressButtonOnMainPage() {
        Allure.step("Перейти в раздел Новости с помощью кнопки на главной странице приложения");
        goToNewsPage();
    }

    @Step("Проверить видимость кнопки выхода из аккаунта ")
    public void logOutIsVisible() {
        mainPage.logOutButton.check(matches(isDisplayed()));
    }

    @Step("Проверить, что видна информация о разработчике приложения")
    public void isDeveloperTextViewDisplayed() {
        Allure.step("Проверить, что видна информация о разработчике приложения");
        aboutPage.aboutInfo.check(matches(isDisplayed()));
    }

    @Step("Проверить, что виден заголовок раздела Цитаты")
    public void isHeaderQuotesPageDisplayed() {
        Allure.step("Проверить, что виден заголовок раздела Цитаты");
        quotesPage.header.check(matches(isDisplayed()));
    }
    @Step("Нажать функциональную кнопку Назад")
    public void pressBack() {
        Espresso.pressBack();
    }

    @Step("Получить высоту первого элемента списка до клика")
    public int getHeightBeforeClick(ViewInteraction recyclerView) {
        int[] heightBeforeClick = {0};
        recyclerView.perform(new DataHelper.GetHeightAfterClickViewAction(heightBeforeClick));
        return heightBeforeClick[0];
    }
    @Step("Перейти в раздел редактирования новостей")
    public void goToNewsEditingPageStep(){
        newsEditPage.addingNewsButton.perform(click());
    }

    @Step("Кликнуть на первом элементе списка, чтобы элемент развернулся")
    public void clickFirstItem(ViewInteraction recyclerView) {
        Allure.step("Кликнуть на первом элементе списка, чтобы элемент развернулся");
        recyclerView.perform(actionOnItemAtPosition(0, click()));
    }
    @Step("Получить высоту первого элемента списка после клика")
    public int getHeightAfterClick(ViewInteraction recyclerView) {
        int[] heightAfterClick = {0};
        recyclerView.perform(new DataHelper.GetHeightAfterClickViewAction(heightAfterClick));
        return heightAfterClick[0];
    }

    @Step("Проверить, что высота первого элемента списка увеличилась после клика")
    public void checkHeightAfterClick(int heightBeforeClick, int heightAfterClick) {
        Allure.step("Проверить, что высота первого элемента списка увеличилась после клика");
        Assert.assertTrue(heightBeforeClick < heightAfterClick);
    }

    @Step("Кликнуть дважды на первом элементе списка, чтобы элемент развернулся и свернулся")
    public void doubleClickFirstItem(ViewInteraction recyclerView) {
        Allure.step("Кликнуть дважды на первом элементе списка, чтобы элемент развернулся и свернулся");
        recyclerView.perform(actionOnItemAtPosition(0, doubleClick()));
    }

    @Step("Проверить, что высота первого элемента списка осталась той же после двойного клика")
    public void checkHeightAfterDoubleClick(int heightBeforeClick, int heightAfterClick) {
        Allure.step("Проверить, что высота первого элемента списка осталась той же после двойного клика");
        assertEquals(heightBeforeClick, heightAfterClick);
    }
    @Step("Проверить видимость страницы Все новости")
    public void checkNewsPage() {
        Allure.step("Проверить видимость страницы Все новости");
        newsPage.filterNewsButton.check(matches(isDisplayed()));
    }
}