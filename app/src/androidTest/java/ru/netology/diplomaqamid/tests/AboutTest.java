package ru.netology.diplomaqamid.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
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
import ru.netology.diplomaqamid.steps.AboutSteps;
import ru.netology.diplomaqamid.steps.AuthorizationSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Раздел О приложении")
public class AboutTest {

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
    @Story("15")
    @Description("Переход по ссылке Политика конфиденциальности в разделе О приложении (Positive Test)")
    public void transitionPrivacyPolicy() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AboutSteps.clickButtonMainToolbar();
        AboutSteps.clickButtonAbout();
        SystemClock.sleep(2000);
        AboutSteps.clickButtonPrivacyPolicy();
        SystemClock.sleep(1000);
        onView(withId(R.id.action_bar_root)).check(matches(isDisplayed()));
        //Выход
        pressBack();
    }

    @Test
    @Story("16")
    @Description("Переход по ссылке Пользовательское соглашение в разделе О приложении (Positive Test)")
    public void transitionTermsOfUse() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AboutSteps.clickButtonMainToolbar();
        AboutSteps.clickButtonAbout();
        SystemClock.sleep(2000);
        AboutSteps.clickButtonTermsOfUse();
        SystemClock.sleep(1000);
        onView(withId(R.id.action_bar_root)).check(matches(isDisplayed()));
        //Выход
        pressBack();
    }
}