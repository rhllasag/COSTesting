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

import static junit.framework.TestCase.assertEquals;

public class US1StepsDef {
    private WebDriver driver;


    @Before
    public void setUp()throws Exception{
        driver = new HtmlUnitDriver();
    }

    @After
    public void tearDown()throws Exception{

    }

    @Given("^I access the landing page of COS$")
    public void iAccessTheLandingPageOfCOS() throws Throwable {
        driver.get("http://localhost:8080");
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

    @Then("^In the \"([^\"]*)\" should be the values \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void inTheShouldBeTheValuesAnd(String rownum, String id, String name, String email) throws Throwable {
        assertEquals(driver.findElement(By.xpath("//tbody/tr["+ rownum +"]/td[1]")).getText(), id);
        assertEquals(driver.findElement(By.xpath("//tbody/tr["+ rownum +"]/td[2]")).getText(), name);
        assertEquals(driver.findElement(By.xpath("//tbody/tr["+ rownum +"]/td[3]")).getText(), email);
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

    @Then("^the table should have four columns$")
    public void theTableShouldHaveColumns() throws Throwable {
        List<WebElement> columnsList = driver.findElement(By.id("contact-row-d4f8d88d-afe1-4c63-821a-278883d6bb49")).findElements(By.tagName("td"));
        assertEquals(columnsList.size(), 4);
    }

}
