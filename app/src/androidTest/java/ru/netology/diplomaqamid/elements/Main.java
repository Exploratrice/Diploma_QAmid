package ru.netology.diplomaqamid.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.diplomaqamid.steps.MainSteps;

public class Main extends MainSteps {

    public static Matcher<View> getMainElementsButtonAllNews() {
        return withId(R.id.all_news_text_view);
    }
}