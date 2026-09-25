package test.accountsalesforce.utils.data.logindata;

public class LoginData {
    public static final String USERNAME_CORRECT = required("SF_USERNAME");
    public static final String PASSWORD_CORRECT = required("SF_PASSWORD");

    private static String required(String key) {
        String value = System.getenv(key);
        if (value == null || value.isBlank()) {
            value = System.getProperty(key);
        }
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Missing credential '" + key + "'. Export it as an environment variable or pass -D" + key + "=... (see .env.example)");
        }
        return value;
    }
}
