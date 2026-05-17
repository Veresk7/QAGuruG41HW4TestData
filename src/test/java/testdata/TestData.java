package testdata;

public class TestData {
//Test data
    public static String firstName = "Sergei";
    public static String lastName = "Sergeev";
    public static String eMail = "sergei_sergeev@mail.ru";
    public static String phoneNumber = "8003002000";
    public static String gender = "Male";
    public static String subjectPattern = "hi";
    public static String subjectName = "Hindi";
    public static String day = "05";
    public static String year = "2070";
    public static String month = "September";
    public static String hobby1 = "Sports";
    public static String hobby2 = "Reading";
    public static String studentPhoto = "example_image_hw4.jpg";
    public static String studentAddress = "Surviver Shtrasse 1";
    public static String state = "Uttar Pradesh";
    public static String city = "Agra";

//Expected modified data
    public static String expectedName = (firstName + " " + lastName);
    public static String expectedHobby = (hobby1 + ", " + hobby2);
    public static String expectedStateCity = (state + " " + city);
    public static String expectedBirthDate = (day +" " + month + "," + year);

}
