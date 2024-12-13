package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ru.iteco.fmhandroid.ui.data.Data.tittleNews;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitUntilVisible;

import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pages.AddingNewsPage;
import ru.iteco.fmhandroid.ui.pages.EditNews;
import ru.iteco.fmhandroid.ui.pages.NewsEditPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

import static ru.iteco.fmhandroid.ui.pages.NewsEditPage.scrollAndClickToNewsWithTittle;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.errorAddingMessageId;

public class NewsEditPageSteps {

    EditNews editNews = new EditNews();
    AddingNewsPage addingNewsPage = new AddingNewsPage();
    NewsEditPage newsEditPage = new NewsEditPage();
    NewsPage newsPage = new NewsPage();

    @Step("Добавить новость")
    public void addingNews() {
        Allure.step("Добавить новость");
        addingNewsPage.addNews(Data.categoryFifth, tittleNews, Data.dateNews, Data.timeNews, Data.descriptionNews);
        DataHelper.waitElement(R.id.news_list_recycler_view);
        newsEditPage.refreshListOfNews();
    }

    @Step("Проверить, что все атрибуты новости соответствуют заданным при ее создании")
    public void checkAttributesNews() {
        Allure.step("Проверить, что все атрибуты новости соответствуют заданным при ее создании");
        onView(withText(tittleNews)).check(matches(isDisplayed()));
        onView(withText(Data.dateNews)).check(matches(isDisplayed()));
    }

    @Step("Скролл списка до созданной новости и кликаем на нее")
    public void scrollToNewsWithTittleAndClick() {
        Allure.step("Скролл списка до созданной новости и кликаем на нее");
        newsEditPage.scrollAndClickToNewsWithTittle(Data.tittleNews);
    }

    @Step("Открыть новость на редактирование")
    public void editingNews() {
        Allure.step("Открыть новость на редактирование");
        newsEditPage.editNews(tittleNews);
    }

    @Step("Проверить сообщение о недопустимости наличия пустых полей при создании новости")
    public void neverFieldsDoesntBeEmptyMessage() {
        Allure.step("Проверить сообщение о недопустимости наличия пустых полей при создании новости");
        waitUntilVisible(DataHelper.checkToast(errorAddingMessageId, true));
    }

    @Step("Получить количество элементов в списке новостей")
    public int getItemCount() {
        Allure.step("Получить количество элементов в списке новостей");
        int itemCount = DataHelper.getRecyclerViewItemCount(R.id.news_list_recycler_view);
        return itemCount;
    }

    @Step("Получить дату первой новости из списка до сортировки")
    public String getFirstDateBeforeSorting() {
        Allure.step("Получить дату первой новости из списка до сортировки");
        String firstDateBeforeSorting = DataHelper.getTextFromNews(R.id.news_item_publication_date_text_view, 0);
        return firstDateBeforeSorting;
    }

    @Step("Получить дату последней новости из списка до сортировки")
    public String getLastDateBeforeSorting(int position) {
        Allure.step("Получить дату последней новости из списка до сортировки");
        String lastDateBeforeSorting = DataHelper.getTextFromNews(R.id.news_item_publication_date_text_view, position);
        return lastDateBeforeSorting;
    }

    @Step("Скролл списка новостей до последнего элемента")
    public void scrollNewsToLastPosition(int itemCount) {
        Allure.step("Скролл списка новостей до последнего элемента");
        newsPage.scrollNewsToPosition(itemCount);
    }

    @Step("Произвести сортировку новостей ")
    public void sortingNewsStep() {
        Allure.step("Произвести сортировку новостей");
        newsPage.sortingNews();
    }

    @Step("Скролл списка новостей до первого элемента")
    public void scrollNewsToFirstPosition() {
        Allure.step("Скролл списка новостей до первого элемента");
        newsPage.scrollNewsToPosition(0);
    }

    @Step("Получить дату первой новости из списка после сортировки")
    public String getFirstDateAfterSorting() {
        Allure.step("Получить дату первой новости из списка после сортировки");
        String firstDateBeforeSorting = DataHelper.getTextFromNews(R.id.news_item_publication_date_text_view, 0);
        return firstDateBeforeSorting;
    }

    @Step("Получить дату последней новости из списка после сортировки")
    public String getLastDateAfterSorting(int position) {
        Allure.step("Получить дату последней новости из списка после сортировки");
        String lastDateBeforeSorting = DataHelper.getTextFromNews(R.id.news_item_publication_date_text_view, position);
        return lastDateBeforeSorting;
    }

    @Step("Проверить, что дата первой новости до сортировки равна дате последней новости после сортировки")
    public void checkDateAfterSortingOne(String firstDateBeforeSorting, String lastDateAfterSorting) {
        Allure.step("Проверить, что дата первой новости до сортировки равна дате последней новости после сортировки");
        assertEquals(firstDateBeforeSorting, lastDateAfterSorting);
    }

    @Step("Проверить, что дата последней новости до сортировки равна дате первой новости после сортировки")
    public void checkDateAfterSortingTwo(String lastDateBeforeSorting, String firstDateAfterSorting) {
        Allure.step("Проверить, что дата последней новости до сортировки равна дате первой новости после сортировки");
        assertEquals(lastDateBeforeSorting, firstDateAfterSorting);
    }

    @Step("Произвести фильтрацию новостей по статусу Активна")
    public void filterNewsByStatusActive() {
        Allure.step("Произвести фильтрацию новостей по статусу Активна");
        newsPage.filterNewsByStatus(true, false);
    }

    @Step("Проверить, что во всех элементах списка новостей статус Активна")
    public void isStatusActive(int itemCount) {
        Allure.step("Проверить, что во всех элементах списка новостей статус Активна");
        for (int i = 0; i < itemCount; i++) {
            NewsEditPage.scrollNews(i);
            String actualStatus = DataHelper.getTextFromNews(R.id.news_item_published_text_view, i);
            assertEquals(Data.statusActive, actualStatus);
        }
    }

    @Step("Произвести фильтрацию новостей по статусу Неактивна")
    public void filterNewsByStatusNotActive() {
        Allure.step("Произвести фильтрацию новостей по статусу Неактивна");
        newsPage.filterNewsByStatus(false, true);
    }

    @Step("Проверить, что во всех элементах списка новостей статус Неактивна")
    public void isStatusNotActive(int itemCount) {
        Allure.step("Проверить, что во всех элементах списка новостей статус Неактивна");
        for (int i = 0; i < itemCount; i++) {
            NewsEditPage.scrollNews(i);
            String actualStatus = DataHelper.getTextFromNews(R.id.news_item_published_text_view, i);
            assertEquals(Data.statusNotActive, actualStatus);
        }
    }

    @Step("Произвоести фильтрацию новостей по статусу Активна и дате публикации")
    public void filterNewsByStatusActiveAndPublishDate() {
        Allure.step("Произвести фильтрацию новостей по статусу Активна и дате публикации");
        newsPage.filterNewsByStatusAndDate(true, false, Data.dateNews, Data.dateNews);
    }

    @Step("Проверить, что во всех элементах списка новостей статус Активна и дата публикации равна дате фильтрации")
    public void isStatusActiveAndPublishDateEqualsFilterDate(int itemCount) {
        Allure.step("Проверить, что во всех элементах списка новостей статус Активна и дата публикации равна дате фильтрации");
        for (int i = 0; i < itemCount; i++) {
            NewsEditPage.scrollNews(i);
            String actualStatus = DataHelper.getTextFromNews(R.id.news_item_published_text_view, i);
            String actualDate = DataHelper.getTextFromNews(R.id.news_item_publication_date_text_view, i);
            assertEquals(Data.statusActive, actualStatus);
            assertEquals(Data.dateNews, actualDate);
        }
    }

    @Step("Произвести смену статуса новости на Неактивна")
    public void changeStatusNewsToNotActive() {
        Allure.step("Произвести смену статуса новости на Неактивна");
        newsEditPage.changeNewsStatus(tittleNews);
    }

    @Step("Проверить, что статус новости Неактивна")
    public void checkNotActiveStatus() {
        Allure.step("Проверить, что статус новости Неактивна");
        onView(withText(Data.statusNotActive)).check(matches(isDisplayed()));
    }

    @Step("Произвести фильтрацию новостей по статусу Неактивна и дате публикации")
    public void filterNewsByStatusNotActiveAndPublishDate() {
        Allure.step("Произвести фильтрацию новостей по статусу Неактивна и дате публикации");
        newsPage.filterNewsByStatusAndDate(false, true, Data.dateNews, Data.dateNews);
    }

    @Step("Проверить, что во всех элементах списка новостей статус Неактивна и дата публикации равна дате фильтрации")
    public void isStatusNotActiveAndPublishDateEqualsFilterDate(int itemCount) {
        Allure.step("Проверить, что во всех элементах списка новостей статус Неактивна и дата публикации равна дате фильтрации");
        for (int i = 0; i < itemCount; i++) {
            NewsEditPage.scrollNews(i);
            String actualStatus = DataHelper.getTextFromNews(R.id.news_item_published_text_view, i);
            String actualDate = DataHelper.getTextFromNews(R.id.news_item_publication_date_text_view, i);
            assertEquals(Data.statusNotActive, actualStatus);
            assertEquals(Data.dateNews, actualDate);
        }
    }

    @Step("Создать новость с незаполненным полем Категория")
    public void addNewsWithEmptyFieldCategory() {
        Allure.step("Создать новость с незаполненным полем Категория");
        addingNewsPage.addNews("", tittleNews, Data.dateNews, Data.timeNews, Data.descriptionNews);
    }

    @Step("Создать новость с незаполненным полем Заголовок")
    public void addNewsWithEmptyFieldTittle() {
        Allure.step("Создать новость с незаполненным полем Заголовок");
        addingNewsPage.addNews(Data.categoryFifth, "", Data.dateNews, Data.timeNews, Data.descriptionNews);
    }

    @Step("Создать новость с незаполненным полем Дата")
    public void addNewsWithEmptyFieldDate() {
        Allure.step("Создать новость с незаполненным полем Дата");
        addingNewsPage.addNews(Data.categoryFifth, tittleNews, "", Data.timeNews, Data.descriptionNews);
    }

    @Step("Создать новость с незаполненным полем Время")
    public void addNewsWithEmptyFieldTime() {
        Allure.step("Создать новость с незаполненным полем Время");
        addingNewsPage.addNews(Data.categoryFifth, tittleNews, Data.dateNews, "", Data.descriptionNews);
    }

    @Step("ПСоздать новость с незаполненным полем Описание")
    public void addNewsWithEmptyFieldDescription() {
        Allure.step("Создать новость с незаполненным полем Описание");
        addingNewsPage.addNews(Data.categoryFifth, tittleNews, Data.dateNews, Data.timeNews, "");
    }

    @Step("Заполнить все поля создаваемой новости")
    public void fillingAllFieldsNews() {
        Allure.step("Заполнить все поля создаваемой новости");
        addingNewsPage.fillingNewsFields(Data.categoryFifth, tittleNews, Data.dateNews, Data.timeNews, Data.descriptionNews);
    }

    @Step("Нажать Отмена")
    public void pressCancelButton() {
        Allure.step("Нажиать Отмена");
        addingNewsPage.cancelButton.perform(click());
    }

    @Step("Подтвердить отмену создания новости")
    public void confirmCancelAddingNews() {
        Allure.step("Подтвердить отмену создания новости");
        addingNewsPage.cancelMessage.check(matches(isDisplayed()));
        addingNewsPage.confirmCancelAddingNewsButton.perform(click());
    }

    @Step("Проверить, что новость не создана")
    public void isNewsNotCreated(int itemCount) {
        Allure.step("Проверить, что новость не создана");
        for (int i = 0; i < itemCount; i++) {
            NewsEditPage.scrollNews(i);
            String actualTittle = DataHelper.getTextFromNews(R.id.news_item_title_text_view, i);
            assertNotEquals(tittleNews, actualTittle);
        }
    }

    @Step("Удалить созданную новость")
    public void deleteAddedNews() {
        Allure.step("Удалить созданную новость");
        newsEditPage.deleteNews(tittleNews);
        DataHelper.waitElement(R.id.news_list_recycler_view);
    }

    @Step("Проверить, что новость удалена")
    public void isNewsDeleted(int itemCount) {
        Allure.step("Проверить, что новость удалена");
        for (int i = 0; i < itemCount; i++) {
            NewsEditPage.scrollNews(i);
            String actualTittle = DataHelper.getTextFromNews(R.id.news_item_title_text_view, i);
            assertNotEquals(tittleNews, actualTittle);
        }
    }

    @Step("Изменить атрибуты созданной новости")
    public void changeCreatedNewsAttributes() {
        Allure.step("Изменить атрибуты созданной новости");
        editNews.changeNewsAttribute(Data.newTittleNews, Data.dateNewsNextDay, Data.newTimeNews, Data.newDescriptionNews);
    }

    @Step("Проверить, что атрибуты созданной новости изменились")
    public void checkChangedNewsAttributes() {
        Allure.step("Проверить, что атрибуты созданной новости изменились");
        onView(withText(Data.newTittleNews)).check(matches(isDisplayed()));
        onView(withText(Data.dateNewsNextDay)).check(matches(isDisplayed()));
        onView(withText(Data.newTimeNews)).check(matches(isDisplayed()));
        onView(withText(Data.newDescriptionNews)).check(matches(isDisplayed()));
    }
}