package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.DataHelper.generateScreenshotName;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Attachment;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@Epic("Тестирование раздела О приложении")
@RunWith(AllureAndroidJUnit4.class)
//@RunWith(AndroidJUnit4.class)

public class AboutPageTest {

    @Rule
    public ActivityScenarioRule<AppActivity> myActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AboutSteps aboutStep = new AboutSteps();
    MainSteps mainStep = new MainSteps();

    @Before
    public void setUp() {
        authorizationSteps.checkLogInAndLogInIfNot();
        mainStep.goToAboutPage();
    }

    @Test
    @DisplayName("Наличие сведений о версии приложения")
    @Attachment
    public void testVisibleVersion() {
        aboutStep.isAppVersionDisplayed();
    }

    @Test
    @DisplayName("Наличие сведений о политике конфиденциальности ")
    @Attachment
    public void testVisiblePrivacyPolicy() {
        aboutStep.isAppPrivacyPolicyDisplayed();
    }
}