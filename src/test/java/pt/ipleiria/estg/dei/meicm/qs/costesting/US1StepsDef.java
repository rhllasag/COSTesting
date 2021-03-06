package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
public class US1StepsDef {
    private WebDriver driver;
    private String baseURL;


    @Before
    public void setUp()throws Exception{
        driver = new HtmlUnitDriver(true);
        baseURL = System.getProperty("baseUrl");
        if (baseURL == null)
            baseURL = "http://localhost:8080";
    }

    @After
    public void tearDown()throws Exception{

    }

    @Given("^I access the landing page of COS$")
    public void iAccessTheLandingPageOfCOS() throws Throwable {
        driver.get(baseURL);
        assertEquals ("Contacts Orchestrator Solution",driver.getTitle());
    }

    @Then("^the title of the page should be \"([^\"]*)\"$")
    public void theTitleOfThePageShouldBe(String title) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains(title));
    }

    @And("^I can see the text \"([^\"]*)\"$")
    public void iCanSeeTheText(String title) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.tagName("body")),title));
    }

    @Then("^Details Page appears$")
    public void detailsPageAppears() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains("Contacts Orchestrator Solution - Contact details"));
        assertEquals(driver.findElement(By.tagName("title")).getText(), "Contacts Orchestrator Solution - Contact details");
    }

    @When("^I click the details button$")
    public void iClickTheDetailsButton() throws Throwable {
        driver.findElement(By.xpath("(//a[contains(text(),'Details')])[1]")).click();
    }

    @Then("^the table should have five columns$")
    public void theTableShouldHaveColumns() throws Throwable {
        List<WebElement> columnsList = driver.findElement(By.id("contact-row-d4f8d88d-afe1-4c63-821a-278883d6bb49")).findElements(By.tagName("td"));
        assertEquals(columnsList.size(), 5);
    }

    @When("^I click the details button for the user with \"([^\"]*)\"$")
    public void iClickTheDetailsButtonForTheUserWith(String id) throws Throwable {
        String elementId = "contact-row-" + id;
        driver.findElement(By.xpath("//a[contains(@href, 'details.php?id="+id+"')]")).click();
    }

    @Then("^Details Page should have \"([^\"]*)\" on the second row$")
    public void detailsPageShouldHaveOnTheSecondRow(String id) throws Throwable {
        assertEquals(driver.findElement(By.xpath("//tr[2]/td[2]")).getText(), id);
    }

    @Then("^The number of table rows should match the number of contacts shown on the field \"([^\"]*)\"$")
    public void theNumberOfTableRowsShouldMatchTheNumberOfContactsShownOnTheField(String id) throws Throwable {
        List<WebElement> contactsList = driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        String numContacts = driver.findElement(By.id(id)).getText();
        assertEquals(numContacts,Integer.toString(contactsList.size()));
    }

    @Then("^the email field has a valid email for the user with \"([^\"]*)\"$")
    public void theEmailFieldHasAValidEmailForTheUserWith(String id) throws Throwable {
        List<WebElement> columnsList = driver.findElement(By.id("contact-row-"+id)).findElements(By.tagName("td"));
        String email = columnsList.get(2).getText();
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(email);
        assertTrue(matcher.find());
    }

    @Then("^the guid field has a valid guid for the user with \"([^\"]*)\"$")
    public void theGuidFieldHasAValidGuidForTheUserWith(String id) throws Throwable {
        List<WebElement> columnsList = driver.findElement(By.id("contact-row-"+id)).findElements(By.tagName("td"));
        String guid = columnsList.get(0).getText();
        Pattern p = Pattern.compile("^[a-z0-9]{8}-([a-z0-9]{4}-){3}[a-z0-9]{12}$");
        Matcher matcher = p.matcher(guid);
        assertTrue(matcher.find());
    }
}
