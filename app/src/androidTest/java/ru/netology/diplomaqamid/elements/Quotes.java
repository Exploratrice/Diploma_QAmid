package ru.netology.diplomaqamid.elements;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.diplomaqamid.WithIndex.withIndex;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.netology.diplomaqamid.steps.QuotesSteps;

public class Quotes extends QuotesSteps {

    public static Matcher<View> getQuotesElementsButtonThematicQuote() {
        return allOf(withId(R.id.our_mission_image_button));
    }

    public static Matcher<View> getQuotesElementsButtonExpandThematicQuote() {
        return allOf(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
    }

    public static Matcher<View> getQuotesElementsButtonExpandTwoThematicQuotes() {
        return allOf(withIndex(withId(R.id.our_mission_item_list_recycler_view), 0));
    }
}