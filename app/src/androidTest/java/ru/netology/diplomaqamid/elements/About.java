package ru.netology.diplomaqamid.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.diplomaqamid.steps.AboutSteps;


public class About extends AboutSteps {

    public static Matcher<View> getAboutElementsButtonMainToolbar() {
        return allOf(withId(R.id.main_menu_image_button));
    }

    public static  Matcher<View> getAboutElementsButtonAbout() {
        return allOf(withId(android.R.id.title), withText("About"));
    }

    public static Matcher<View> getAboutElementsButtonPrivacyPolicy() {
        return allOf(withId(R.id.about_privacy_policy_value_text_view));
    }

    public static Matcher<View> getAboutElementsButtonTermsOfUse() {
        return withId(R.id.about_terms_of_use_value_text_view);
    }
}