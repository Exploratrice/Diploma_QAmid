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
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsEditPageSteps;

@Epic("Тестирование страницы редактирования новостей")
@RunWith(AllureAndroidJUnit4.class)
//@RunWith(AndroidJUnit4.class)

public class NewsEditTest {

    @Before
    public void setUp() {
        authorizationSteps.checkLogInAndLogInIfNot();
        mainSteps.goToNewsPageWithPressNavigationMenuButton();
        mainSteps.goToNewsEditingPageStep();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    NewsEditPageSteps newsEditPageSteps = new NewsEditPageSteps();


    @Test
    @DisplayName("Сортировка новостей в разделе редактирования новостей")
    public void testSortingNewsInEditingNews() {
        int itemCount = newsEditPageSteps.getItemCount();
        String firstDateBeforeSorting = newsEditPageSteps.getFirstDateBeforeSorting();
        newsEditPageSteps.scrollNewsToLastPosition(itemCount - 1);
        String lastDateBeforeSorting = newsEditPageSteps.getLastDateBeforeSorting(itemCount - 1);
        newsEditPageSteps.sortingNewsStep();
        newsEditPageSteps.scrollNewsToFirstPosition();
        String firstDateAfterSorting = newsEditPageSteps.getFirstDateAfterSorting();
        newsEditPageSteps.scrollNewsToLastPosition(itemCount - 1);
        String lastDateAfterSorting = newsEditPageSteps.getLastDateAfterSorting(itemCount - 1);
        newsEditPageSteps.checkDateAfterSortingOne(firstDateBeforeSorting, lastDateAfterSorting);
        newsEditPageSteps.checkDateAfterSortingTwo(lastDateBeforeSorting, firstDateAfterSorting);
    }

    @Test //N
    @DisplayName("Добавление новости")  //NO
    public void testAddingNews() {

        newsEditPageSteps.addingNews();
        newsEditPageSteps.scrollToNewsWithTittleAndClick();
        newsEditPageSteps.editingNews();
        newsEditPageSteps.checkAttributesNews();
    }

    @Test
    @DisplayName("Фильтрация новостей по статусу Активна")
    public void testFilterNewsByStatusActive() {
        newsEditPageSteps.filterNewsByStatusActive();
        int itemCount = newsEditPageSteps.getItemCount();
        newsEditPageSteps.isStatusActive(itemCount);
    }

    @Test //N
    @DisplayName("Фильтрация новостей по статусу Неактивна")
    public void testFilterNewsByStatusNotActive() {
        newsEditPageSteps.filterNewsByStatusNotActive();
        int itemCount = newsEditPageSteps.getItemCount();
        newsEditPageSteps.isStatusNotActive(itemCount);
    }

    @Test
    @DisplayName("Фильтрация новостей по статусу Активна и дате публикации")
    public void testFilterNewsByStatusActiveAndDatePublish() {
        newsEditPageSteps.addingNews();
        newsEditPageSteps.filterNewsByStatusActiveAndPublishDate();
        int itemCount = newsEditPageSteps.getItemCount();
        newsEditPageSteps.isStatusActiveAndPublishDateEqualsFilterDate(itemCount);
    }

    @Test //N
    @DisplayName("Смена статуса новости")
    public void testChangeNewsStatus() {
        newsEditPageSteps.addingNews();
        newsEditPageSteps.changeStatusNewsToNotActive();
        newsEditPageSteps.editingNews();
        newsEditPageSteps.checkNotActiveStatus();
    }

    @Test //N
    @DisplayName("Фильтрация новостей по статусу Неактивна и дате публикации")
    public void testFilterNewsByStatusNotActiveAndDatePublish() {
        newsEditPageSteps.addingNews();
        newsEditPageSteps.changeStatusNewsToNotActive();
        newsEditPageSteps.filterNewsByStatusNotActiveAndPublishDate();
        int itemCount = newsEditPageSteps.getItemCount();
        newsEditPageSteps.isStatusNotActiveAndPublishDateEqualsFilterDate(itemCount);
    }

    @Test
    @DisplayName("Отказ в добавление новости при незаполненном поле Категория")
    public void testRefusalAddingNewsWithEmptyFieldCategory() {
        newsEditPageSteps.addNewsWithEmptyFieldCategory();
        newsEditPageSteps.neverFieldsDoesntBeEmptyMessage();
    }

    @Test
    @DisplayName("Отказ в добавление новости при незаполненном поле Заголовок")
    public void testRefusalAddingNewsWithEmptyFieldTittle() {
        newsEditPageSteps.addNewsWithEmptyFieldTittle();
        newsEditPageSteps.neverFieldsDoesntBeEmptyMessage();
    }

    @Test
    @DisplayName("Отказ в добавление новости при незаполненном поле Дата")
    public void testRefusalAddingNewsWithEmptyFieldDate() {
        newsEditPageSteps.addNewsWithEmptyFieldDate();
        newsEditPageSteps.neverFieldsDoesntBeEmptyMessage();
    }

    @Test
    @DisplayName("Отказ в добавление новости при незаполненном поле Время")
    public void testRefusalAddingNewsWithEmptyFieldTime() {
        newsEditPageSteps.addNewsWithEmptyFieldTime();
        newsEditPageSteps.neverFieldsDoesntBeEmptyMessage();
    }

    @Test
    @DisplayName("Отказ в добавление новости при незаполненном поле Описание")
    public void testRefusalAddingNewsWithEmptyFieldDescription() {
        newsEditPageSteps.addNewsWithEmptyFieldDescription();
        newsEditPageSteps.neverFieldsDoesntBeEmptyMessage();
    }

    @Test //N
    @DisplayName("Отмена добавление новости при нажатии кнопки Отмена")
    public void testCancelAddingNewsWithPressCancel() {
        newsEditPageSteps.fillingAllFieldsNews();
        newsEditPageSteps.pressCancelButton();
        newsEditPageSteps.confirmCancelAddingNews();
        mainSteps.pressBack();
        int itemCount = newsEditPageSteps.getItemCount();
        newsEditPageSteps.isNewsNotCreated(itemCount);
    }

    @Test
    @DisplayName("Отмена добавление новости при нажатии кнопки Назад")
    public void testCancelAddingNewsWithPressBack() {
        newsEditPageSteps.fillingAllFieldsNews();
        mainSteps.pressBack();
        int itemCount = newsEditPageSteps.getItemCount();
        newsEditPageSteps.isNewsNotCreated(itemCount);
    }

    @Test //N
    @DisplayName("Удаление новости")
    public void testDeleteNews() {
        newsEditPageSteps.addingNews();
        newsEditPageSteps.deleteAddedNews();
        int itemCount = newsEditPageSteps.getItemCount();
        newsEditPageSteps.isNewsDeleted(itemCount);
    }

    @Test //N
    @DisplayName("Редактирование атрибутов новости")
    public void testChangeNewsAttribute() {
        newsEditPageSteps.addingNews();
        newsEditPageSteps.editingNews();
        newsEditPageSteps.changeCreatedNewsAttributes();
        newsEditPageSteps.editingNews();
        newsEditPageSteps.checkChangedNewsAttributes();
    }
}