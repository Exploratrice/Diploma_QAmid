package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;

import ru.iteco.fmhandroid.ui.pages.AddingNewsPage;
import ru.iteco.fmhandroid.ui.pages.NewsEditPage;

public class AddingNewsPageSteps {

    AddingNewsPage addingNewsPage = new AddingNewsPage();
    NewsEditPage newsEditPage = new NewsEditPage();


    public void addNews(String category, String tittle, String date, String time, String description) {
        fillingNewsFields(category, tittle, date, time, description);
        clickSaveButton();
    }

    public void fillingNewsFields(String category, String tittle, String date, String time, String description) {
        newsEditPage.addNewsButton.perform(click());
        fillInNewsCategoryField(category);
        fillInNewsTitleField(tittle);
        fillInPublicDateField(date);
        fillInTimeField(time);
        fillInNewsDescriptionField(description);
    }

    public void fillInNewsCategoryField(String category) {
        addingNewsPage.categoryField.perform(replaceText(category));
    }

    public void fillInNewsTitleField(String text) {
        addingNewsPage.tittleField.perform(replaceText(text));
    }

    public void fillInPublicDateField(String text) {
        addingNewsPage.dateField.perform(replaceText(text));
    }

    public void fillInTimeField(String text) {
        addingNewsPage.timeField.perform(replaceText(text));
    }

    public void fillInNewsDescriptionField(String text) {
        addingNewsPage.descriptionField.perform(replaceText(text));
    }
    public void clickSaveButton() {
        addingNewsPage.saveButton.perform(click());
    }

    public void clickCancelButton() {
        addingNewsPage.cancelButton.perform(click());
    }

    public void clickOKButton() {
        addingNewsPage.cancelMessage.perform(click());
    }
}