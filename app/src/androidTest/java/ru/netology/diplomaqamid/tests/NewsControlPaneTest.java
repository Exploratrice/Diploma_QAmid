package ru.netology.diplomaqamid.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.diplomaqamid.util.Util.withIndex;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.diplomaqamid.elements.Authorization;
import ru.netology.diplomaqamid.elements.NewsControlPanel;
import ru.netology.diplomaqamid.steps.NewsControlPaneSteps;
import ru.netology.diplomaqamid.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Панель Управления новостями")
public class NewsControlPaneTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void Authorization () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Authorization.textAuthorization();
        } catch (NoMatchingViewException e) {
            return;
        }
        Authorization.textAuthorization();
        Authorization.clickLoginField();
        Authorization.clickPasswordField();
        SystemClock.sleep(1000);
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
    }

    @After
    public void Exit () {
        SystemClock.sleep(2000);
        Authorization.clickButtonExit(Authorization.getAuthorizationElementsButtonExit());
        SystemClock.sleep(2000);
        Authorization.clickButtonLogOut();
    }

    @Test
    @Story("46")
    @Description("Просмотр новостей в разделе Панель управления новостями мобильного приложения Мобильный хоспис (Positive Test)")
    public void viewingNewsControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickClickNews();
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("47")
    @Description("Удаление активной новости в разделе Панель управления новостями мобильного приложения (Positive Test)")
    public void deletingActiveNews() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(3000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickClickNews();
        NewsControlPaneSteps.clickButtonDeleteNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickOkDeleteNews();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("48")
    @Description("Сортировка новостей в разделе Панель управления новостями мобильного приложения (Positive Test)")
    public void sortingNewsControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPanel.clickButtonControlPanel();
        NewsControlPanel.clickButtonSorting();
        SystemClock.sleep(1000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("49")
    @Description("Редактирование новости в разделе Панель управления новостями мобильного приложения (Positive Test)")
    public void editNewsControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickClickNews();
        NewsControlPaneSteps.clickButtonEditNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonTitleNewsControlPanel();
        onView(withId(android.R.id.content)).perform(swipeUp());
        SystemClock.sleep(1000);
        NewsControlPaneSteps.clickButtonSaveEditingNews();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("50")
    @Description("Смена статуса новости в статусе Активна на статус Не Активна в разделе Панель управления новостями мобильного приложения (Positive Test)")
    public void changeNewsStatus() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickClickNews();
        NewsControlPaneSteps.clickButtonEditNews();
        NewsControlPaneSteps.clickButtonSwitcher();
        SystemClock.sleep(2000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        onView(withId(R.id.switcher))
                .check(matches(withText("Not active")))
                .check(matches(isDisplayed()));
        onView(withId(android.R.id.content)).perform(swipeDown());
        NewsControlPaneSteps.clickButtonSaveEditingNews();
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("51")
    @Description("Фильтрация новостей по статусу Не активна в разделе Панель управления новостями мобильного приложения (Positive Test)")
    public void filterNewsByStatusActive() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickFilterNewsControlPanel();
        NewsControlPaneSteps.clickRemoveCheckBoxActive();
        NewsControlPaneSteps.clickButtonFilterNewsControlPanel();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("52")
    @Description("Фильтрация новостей по статусу Активна в разделе Панель управления новостями мобильного приложения (Positive Test)")
    public void filterNewsByStatusNotActive() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickFilterNewsControlPanel();
        NewsControlPaneSteps.clickRemoveCheckBoxNotActive();
        NewsControlPaneSteps.clickButtonFilterNewsControlPanel();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("53")
    @Description("Создание новости в разделе Панель управления новостями мобильного приложения (Positive Test)")
    public void creationNewsInControlPanel() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(3000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickAddNews();
        NewsControlPaneSteps.clickButtonCategoryCreatingNews();
        SystemClock.sleep(3000);
        NewsControlPaneSteps.clickButtonTitleCreatingNews();
        NewsControlPaneSteps.clickButtonDateCreatingNews();
        NewsControlPaneSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(3000);
        NewsControlPaneSteps.clickButtonTimeCreatingNews();
        NewsControlPaneSteps.clickButtonOkTimeCreatingNews();
        NewsControlPaneSteps.clickDescriptionCreatingNews();
        NewsControlPaneSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(3000);
        onView(allOf(withIndex(withId(R.id.news_item_material_card_view), 0))).check(matches(isDisplayed()));
    }

    @Test
    @Story("54")
    @Description("Поле Категория пустое при создании новости в разделе Панель управления новостями мобильного приложения (Negative Test)")
    public void fieldCategoryIsEmptyCreationNews() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonTitleCreatingNews();
        NewsControlPaneSteps.clickButtonDateCreatingNews();
        NewsControlPaneSteps.clickButtonOkDateCreatingNews();
        NewsControlPaneSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonOkTimeCreatingNews();
        NewsControlPaneSteps.clickDescriptionCreatingNews();
        NewsControlPaneSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    @Test
    @Story("55")
    @Description("Поле Заголовок пустое при создании новости в разделе Панель управления новостями мобильного приложения (Negative Test)")
    public void fieldTitleIsEmptyCreationNews() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonCategoryCreatingNew();
        NewsControlPaneSteps.clickButtonDateCreatingNews();
        NewsControlPaneSteps.clickButtonOkDateCreatingNews();
        NewsControlPaneSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonOkTimeCreatingNews();
        NewsControlPaneSteps.clickDescriptionCreatingNews();
        NewsControlPaneSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    @Test
    @Story("56")
    @Description("Поле Дата публикации пустое при создании новости в разделе Панель управления новостями мобильного приложения (Negative Test)")
    public void fieldDateIsEmptyCreationNews() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonCategoryCreatingNews();
        NewsControlPaneSteps.clickButtonTitleCreatingNews();
        NewsControlPaneSteps.clickButtonTimeCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonOkTimeCreatingNews();
        NewsControlPaneSteps.clickDescriptionCreatingNews();
        NewsControlPaneSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    @Test
    @Story("57")
    @Description("Поле Время пустое при создании новости в разделе Панель управления новостями мобильного приложения (Negative Test)")
    public void fieldTimeIsEmptyCreationNews() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonCategoryCreatingNews();
        NewsControlPaneSteps.clickButtonTitleCreatingNews();
        NewsControlPaneSteps.clickButtonDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonOkDateCreatingNews();
        NewsControlPaneSteps.clickDescriptionCreatingNews();
        NewsControlPaneSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    @Test
    @Story("58")
    @Description("Поле Описание пустое при создании новости в разделе Панель управления новостями мобильного приложения (Negative Test)")
    public void fieldDescriptionIsEmptyCreationNews() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonCategoryCreatingNews();
        NewsControlPaneSteps.clickButtonTitleCreatingNews();
        NewsControlPaneSteps.clickButtonDateCreatingNews();
        NewsControlPaneSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonTimeCreatingNews();
        NewsControlPaneSteps.clickButtonOkTimeCreatingNews();
        NewsControlPaneSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        pressBack();
    }

    @Test
    @Story("59")
    @Description("Ввод в поле Категория названия категории при создании новости в разделе Панель управления новостями мобильного приложения (Negative Test)")
    public void categoryNameCreated() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonCategoryCreatingNewsEmpty();
        NewsControlPaneSteps.clickButtonTitleCreatingNews();
        NewsControlPaneSteps.clickButtonDateCreatingNews();
        NewsControlPaneSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonTimeCreatingNews();
        NewsControlPaneSteps.clickButtonOkTimeCreatingNews();
        NewsControlPaneSteps.clickDescriptionCreatingNews();
        NewsControlPaneSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();

    }

    @Test
    @Story("60")
    @Description("Поле Категория заполнено спецсимволами при создании новости в разделе Панель управления новостями мобильного приложения (Negative Test)")
    public void fieldCategoryWithSpecialCharacters() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonCategoryCreatingCharacters();
        NewsControlPaneSteps.clickButtonTitleCreatingNews();
        NewsControlPaneSteps.clickButtonDateCreatingNews();
        NewsControlPaneSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonTimeCreatingNews();
        NewsControlPaneSteps.clickButtonOkTimeCreatingNews();
        NewsControlPaneSteps.clickDescriptionCreatingNews();
        NewsControlPaneSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }

    @Test
    @Story("61")
    @Description("Поле Категория заполнено цифрами при создании новости в разделе Панель управления новостями мобильного приложения (Negative Test)")
    public void fieldCategoryConsistsOfNumbers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonCategoryCreatingNewsNumbers();
        NewsControlPaneSteps.clickButtonTitleCreatingNews();
        NewsControlPaneSteps.clickButtonDateCreatingNews();
        NewsControlPaneSteps.clickButtonOkDateCreatingNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonTimeCreatingNews();
        NewsControlPaneSteps.clickButtonOkTimeCreatingNews();
        NewsControlPaneSteps.clickDescriptionCreatingNews();
        NewsControlPaneSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
        pressBack();
    }

    @Test
    @Story("62")
    @Description("Поле Дата публикации заполнено датой будущего года при создании новости в разделе Панель управления новостями мобильного приложения (Positive Test)")
    public void fieldDateConsistsOfNextYearCreatingNews() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonControlPanel();
        NewsControlPaneSteps.clickAddNews();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonCategoryCreatingNews();
        NewsControlPaneSteps.clickButtonTitleCreatingNews();
        NewsControlPaneSteps.clickButtonDateCreatingNextDate();
        SystemClock.sleep(2000);
        NewsControlPaneSteps.clickButtonTimeCreatingNews();
        NewsControlPaneSteps.clickButtonOkTimeCreatingNews();
        NewsControlPaneSteps.clickDescriptionCreatingNews();
        NewsControlPaneSteps.clickButtonSaveCreatingNews();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }
}