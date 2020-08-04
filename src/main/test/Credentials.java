package test;

public enum Credentials {

    TEST_ACCOUNT("jasex11393@in4mail.net", "qaz123");

    public String login;
    public String password;

    Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
