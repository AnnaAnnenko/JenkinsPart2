package qa.annenko.properties;

public class Properties {

    public static String browser() {
        return System.getProperty("browser", "chrome");
    }

    public static String browserVersion() {
        return System.getProperty("browserVersion", "100");
    }

    public static String screenSize() {
        return System.getProperty("screenSize", "1920x1080");
    }

    public static String remoteBrowser() {
        return System.getProperty("remoteBrowser");
    }
}
