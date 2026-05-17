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
        Configuration.holdBrowserOpen =  false;

    }

    //Шаги теста
    @Test
    void positiveMaxFormTest() {
        open("/automation-practice-form"); //Добавление в URL path-параметра для открытия нужной страницы

        element("#firstName").setValue(firstName);
        element("#lastName").setValue(lastName);
        element("#userEmail").setValue(eMail);
        element("#genterWrapper").$(byText(gender)).click();
        element("#userNumber").setValue(phoneNumber);
        element("#dateOfBirthInput").click();
        element(".react-datepicker__year-select").$(byText(year)).click();
        element(".react-datepicker__month-select").$(byText(month)).click();
        element(".react-datepicker__day--0" + day).click();
        element("#subjectsInput").setValue(subjectPattern);
        element(".subjects-auto-complete__option").scrollTo();
        element(".subjects-auto-complete__menu-list").$(byText(subjectName)).click();
        element("#hobbiesWrapper").$(byText(hobby1)).click();
        element("#hobbiesWrapper").$(byText(hobby2)).click();
        element("#uploadPicture").uploadFromClasspath(studentPhoto);
        element("#currentAddress-wrapper .form-control").setValue(studentAddress);
        element("#react-select-3-input").click();
        element(".css-1nmdiq5-menu").$(byText(state)).click();
        element("#react-select-4-input").click();
        element(".css-1nmdiq5-menu").$(byText(city)).click();
        element("#submit").click();

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
