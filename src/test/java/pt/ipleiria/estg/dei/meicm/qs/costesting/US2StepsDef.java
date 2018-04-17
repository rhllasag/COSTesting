package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.json.*;


import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class US2StepsDef {
    private WebDriver driver;

    @Before
    public void setUp()throws Exception{
        driver = new HtmlUnitDriver();
    }

    @After
    public void tearDown()throws Exception{

    }

    @Given("^I access the details page of COS with \"([^\"]*)\"$")
    public void iAccessTheDetailsPageOfCOSWith(String id) throws Throwable {
        driver.get("http://localhost:8080/details.php?id="+id);
    }

    @Then("^the title of details the page should be \"([^\"]*)\"$")
    public void theTitleOfDetailsThePageShouldBe(String title) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains(title));
    }

    @Then("^the table should have eleven rows$")
    public void theTableShouldHaveElevenRows() throws Throwable {
       List<WebElement> rowsList = driver.findElement(By.tagName("table")).findElements(By.tagName("tr"));
       assertEquals(rowsList.size(), 11);
    }

    @Then("^the \"([^\"]*)\" should have \"([^\"]*)\" on the second column$")
    public void theShouldHaveOnTheSecondColumn(String rowNum, String rowValue) throws Throwable {
        assertEquals(driver.findElement(By.xpath("//tr["+rowNum+"]/td[2]")).getText(), rowValue);
    }

    @When("^I click the Go back button$")
    public void iClickTheGoBackButton() throws Throwable {
        driver.findElement(By.xpath("//a[contains(@href, 'index.php')]")).click();
    }

    @Then("^the landing page appears$")
    public void theLandingPageAppears() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains("Contacts Orchestrator Solution"));
        assertEquals(driver.findElement(By.tagName("title")).getText(), "Contacts Orchestrator Solution");
    }

    @Then("^the message \"([^\"]*)\" should be present$")
    public void theMessageShouldBePresent(String message) throws Throwable {
        String errorJson = driver.findElement(By.tagName("body")).getText();
        JSONObject obj = new JSONObject(errorJson);
        String errMsg = obj.getString("message");
        assertEquals(message, errMsg);
    }

    @Given("^I access the details page of COS with no guid$")
    public void iAccessTheDetailsPageOfCOS() throws Throwable {
        driver.get("http://localhost:8080/details.php");
    }
}
