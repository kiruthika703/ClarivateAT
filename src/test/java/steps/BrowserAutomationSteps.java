package steps;

import enums.BrowserType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.Logfile;
import managers.WebDriverManager;
import pages.GoogleSearchPage;
import pages.SearchResultsPage;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

/**
 * This is a step definitions class for Browser Related Steps
 *
 * @author Amritansh Diwakar
 */

public class BrowserAutomationSteps extends BaseUtil {
    private final BaseUtil base;
    Logfile log = new Logfile();

    public BrowserAutomationSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I open Chrome Browser")
    public void openChromeBrowser() throws IOException {
        WebDriverManager webDriverManager = new WebDriverManager();
        base.webDriver = webDriverManager.initDriver(BrowserType.CHROME);
        log.info("Chrome Browser is opened");
    }

    @When("I navigate to google.com")
    public void navigateToGoogleCom() throws IOException {
        base.webDriver.get(configProp.getProperty("google_url"));
        log.info("Navigated to Google Home Page");
    }

    @Given("search for {string}")
    public void searchFor(String searchQuery) throws IOException {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(base.webDriver);
        googleSearchPage.searchForKeyword(searchQuery);
        log.info("Search results got displayed");
    }

    @Then("first search result should be {string}")
    public void verifyFirstSearchResult(String expectedURL) throws IOException {
        SearchResultsPage searchResultsPage = new SearchResultsPage(base.webDriver);
        assertEquals(searchResultsPage.getFirstSearchResult().getAttribute("href"), expectedURL);
        log.info("First result is expected URL");
    }

}