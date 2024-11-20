package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public ViewInteraction mainMenuButton;
    public ViewInteraction newsButton;
    public ViewInteraction aboutButton;
    public ViewInteraction allNewsButton;

    public ViewInteraction logOutButton;

    public ViewInteraction quotesButton;

    public MainPage(){
        mainMenuButton = onView(allOf(withId(R.id.main_menu_image_button), withContentDescription(R.string.main_menu)));
        newsButton = onView(withText(R.string.news));
        aboutButton = onView(withText(R.string.about));
        allNewsButton = onView(allOf(withId(R.id.all_news_text_view),
                withText(R.string.all_news)));

        logOutButton = onView(allOf(withId(R.id.authorization_image_button)));

        quotesButton = onView(allOf(withId(R.id.our_mission_image_button)));
    }
}
