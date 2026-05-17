package textbox;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class PracticeFormTest {

    //Предусловие теста - настройка конфигерации
    @BeforeAll
    static void configuration() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen =  true;

    }

    //Шаги теста
    @Test
    void positiveMaxFormTest() {
        open("/automation-practice-form"); //Добавление в URL path-параметра для открытия нужной страницы
//        executeJavaScript("$('#fixedban').remove()"); //Убираем банеры
//        executeJavaScript("$('footer').remove()"); //Убираем футер
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(eMail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText(birthYear)).click();
        $(".react-datepicker__month-select").$(byText(birthMonth)).click();
        $(".react-datepicker__day--005").click();
        $("#subjectsInput").setValue(subjectPattern);
        $(".subjects-auto-complete__option").scrollTo();
        $(".subjects-auto-complete__menu-list").$(byText(subjectName)).click();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#uploadPicture").uploadFromClasspath(studentPhoto);
        $("#currentAddress-wrapper .form-control").setValue(studentAddress);
        $("#react-select-3-input").click();
        $(".css-1nmdiq5-menu").$(byText(state)).click();
        $("#react-select-4-input").click();
        $(".css-1nmdiq5-menu").$(byText(city)).click();
        $("#submit").click();

        //Проверка заполения таблицы
        element(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(expectedName));
        element(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(eMail));
        element(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        element(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
        element(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(expectedBirthDate)); //Баг - нет проверки на невозможность ввести будущее время
        element(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjectName));
        element(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(expectedHobby));
        element(".table-responsive").$(byText("Picture")).parent().shouldHave(text(studentPhoto));
        element(".table-responsive").$(byText("Address")).parent().shouldHave(text(studentAddress));
        element(".table-responsive").$(byText("State and City")). parent().shouldHave(text(expectedStateCity));



    }
}
