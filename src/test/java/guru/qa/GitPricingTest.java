package guru.qa;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class GitPricingTest {
    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    @Test
    void gitP(){
        //открыть GitHub
        open("/");
        //ввод курсора в область страницы сайта (ибо если курсор был до этого на меню брузера, то курсор наводится на "Pricing", но dropdown не появляется)
        $("html").hover();
        //навестись на Pricing
        $(".HeaderMenu").find(byText("Pricing")).hover();
        //Выбрать Compare Plans в Pricing
        $(".HeaderMenu").$(byText("Pricing")).parent().find(byText("Compare plans")).click();
        // Убедитесь что загрузилась нужная страница (например что заголовок - "Choose the plan that’s right for you."
        $("h1.h2-mktg").shouldHave(text("Choose the plan that’s right for you."));
    }

}
