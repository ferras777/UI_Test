package lesson1.test.enums;

public enum Credentials {
    TEST_ACCOUNT_NEW_USER("jasex11393@in4mail.net", "qaz123"),
    WRONG_CREDENTIALS("test","test");

    public String LOGIN;
    public String PASSWORD;

    Credentials(String login, String password) {
        this.LOGIN = login;
        this.PASSWORD = password;
    }
}
