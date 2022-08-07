package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DrgAndDrpTest {
    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    @Test
    void dad(){
        //- Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("/drag_and_drop");
        //проверка начального положения
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        // - Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        // - Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
