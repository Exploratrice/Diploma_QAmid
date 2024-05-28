package ru.netology.diplomaqamid.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

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
import ru.netology.diplomaqamid.steps.AuthorizationSteps;
import ru.netology.diplomaqamid.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Раздел Новости")
public class NewsTest {

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
            AuthorizationSteps.textAuthorization();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordField();
        SystemClock.sleep(1000);
        Authorization.clickButton(Authorization.getAuthorizationElementsButton());
    }

    @After
    public void Exit () {
        SystemClock.sleep(2000);
        Authorization.clickButtonExit(Authorization.getAuthorizationElementsButtonExit());
        SystemClock.sleep(2000);
        AuthorizationSteps.clickButtonLogOut();
    }

    @Test
    @Story("33")
    @Description("Просмотр новостей в разделе Новости мобильного приложения (Positive Test)")
    public void viewingNews() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.clickExpandNews();
        SystemClock.sleep(2000);
        onView(withId(R.id.news_list_swipe_refresh)).check(matches(isDisplayed()));
    }

    @Test
    @Story("34")
    @Description("Сортировка новостей в разделе Новости мобильного приложения (Positive Test)")
    public void newsSorting() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonSorting();
        onView(withId(R.id.news_list_swipe_refresh)).check(matches(isDisplayed()));
    }

    @Test
    @Story("35")
    @Description("Фильтрация новостей без выбора параметров в разделе Новости (Positive Test)")
    public void filteringNewsWithNoParams() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonCategoryFilter();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    @Test
    @Story("36")
    @Description("Фильтрация новостей без категории, но с начальной  и конечной датой в разделе Новости (Positive Test)")
    public void filteringNewsWithCertainPeriodTime() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCategoryFilter();
        SystemClock.sleep(2000);
        onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }

    @Test
    @Story("37")
    @Description("Фильтрация новостей без категории и конечной даты, далее с добавлением конечной даты в разделе Новости (Negative Test)")
    public void filteringNewsWithCertainPeriodTimeWithoutDateEnd() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NewsSteps.clickButtonMainToolbar();
        NewsSteps.clickButtonNews();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonCategoryFilter();
        SystemClock.sleep(2000);
        NewsSteps.clickButtonOkWrongMessage();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCategoryFilter();
        SystemClock.sleep(1000);
        onView(withId(R.id.all_news_cards_block_constraint_layout)).check(matches(isDisplayed()));
    }
}