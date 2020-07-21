package enums;

/**
 * This is a enum to handle Browser Types and their corresponding system properties
 *
 * @author Amritansh Diwakar
 */
public enum BrowserType {
    FIREFOX("webdriver.gecko.driver"),
    CHROME("webdriver.chrome.driver");

    private final String systemProperty;

    BrowserType(String systemProperty) {
        this.systemProperty = systemProperty;
    }

    /**
     * This method is used to get a enum value
     *
     * @return Enum parameter value
     */
    public String getSystemProperty() {
        return String.valueOf(this.systemProperty);
    }
}
