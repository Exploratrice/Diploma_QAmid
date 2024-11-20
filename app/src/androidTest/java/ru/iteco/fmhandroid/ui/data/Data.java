package ru.iteco.fmhandroid.ui.data;


import static ru.iteco.fmhandroid.ui.data.DataHelper.getStringFromResource;

import net.datafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ru.iteco.fmhandroid.R;

public class Data {

    public static final String correctLogin = "login2";
    public static final String correctPassword = "password2";
    public static final String wrongLogin = "log1234";
    public static final String wrongPassword = "pass1234";


    public static final String urlPrivacyPolicy = "https://vhospice.org/#/privacy-policy/";
    public static final String urlTermsOfUse = "https://vhospice.org/#/terms-of-use";
    public static final String categoryFirst = "Объявление";
    public static final String categorySecond = "День рождения";
    public static final String categoryThird = "Зарплата";
    public static final String categoryForth = "Профсоюз";
    public static final String categoryFifth = "Праздник";
    public static final String categorySixth = "Массаж";
    public static final String categorySeventh = "Благодарность";
    public static final String categoryEighth = "Нужна помощь";
    public static final String statusActive = getStringFromResource(R.string.news_control_panel_active);
    public static final String statusNotActive = getStringFromResource(R.string.news_control_panel_not_active);
    private static final Faker faker = new Faker();
    public static final String tittleNews = "Tittle_" + faker.number().numberBetween(1, 9999999);
    public static final String newTittleNews = "NewTittle_" + faker.number().numberBetween(1, 9999999);
    public static final String descriptionNews = "Description" + faker.simpsons().toString();
    public static final String newDescriptionNews = "NewDescription" + faker.simpsons().toString();
    private static final LocalDateTime date = LocalDateTime.now();
    private static final DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final String dateNews = formatterDate.format(date);
    public static final String dateNewsNextDay = formatterDate.format(date.plusDays(1));
    public static final String dateNewsPreviousDay = formatterDate.format(date.minusDays(1));
    private static final DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("hh:mm");
    public static final String timeNews = formatterTime.format(date);
    public static final String newTimeNews = formatterTime.format(date.plusHours(1));
}