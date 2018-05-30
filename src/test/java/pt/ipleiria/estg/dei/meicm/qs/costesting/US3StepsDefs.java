package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class US3StepsDefs {
    private WebDriver driver;
    private String baseURL;


    @Before
    public void setUp()throws Exception{
        driver = new HtmlUnitDriver(true);
        baseURL = System.getProperty("baseUrl");
        if (baseURL == null)
            baseURL = "http://35.195.26.198";
    }

    @After
    public void tearDown()throws Exception{

    }

    @Given("^I access the landing page without saved data$")
    public void iAccessTheLandingPage() throws Throwable {
        driver.get(baseURL+"/?clear_session=true");
    }

    @Then("^The filtering options should be \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theFilteringOptionsShouldBeAnd(String facebookStr, String linkedinStr) throws Throwable {
        assertEquals(driver.findElement(By.xpath("//label")).getText(), facebookStr);
        assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), linkedinStr);
    }

    @Then("^The names of the columns of the filtering table are \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theNamesOfTheColumnsOfTheFilteringTableAreAnd(String idStr, String nameStr, String emailStr, String actionStr, String sourceStr) throws Throwable {
        assertEquals(driver.findElement(By.xpath("//td[1]")).getText(), idStr);
        assertEquals(driver.findElement(By.xpath("//td[2]")).getText(), nameStr);
        assertEquals(driver.findElement(By.xpath("//td[3]")).getText(), emailStr);
        assertEquals(driver.findElement(By.xpath("//td[4]")).getText(), actionStr);
        assertEquals(driver.findElement(By.xpath("//td[5]")).getText(), sourceStr);
    }

    @When("^I click the Solve Duplicated Button$")
    public void iClickTheSolveDuplicatedButton() throws Throwable {
        driver.findElement(By.xpath("//a")).click();
    }

    @Then("^I access the Solve Duplicated Page$")
    public void iAccessTheSolveDuplicatedPage() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains("Contacts Orchestrator Solution - Duplicated contacts"));
        assertEquals(driver.getTitle(), "Contacts Orchestrator Solution - Duplicated contacts");
    }


    @When("^I choose disable the \"([^\"]*)\" filter to show contacts with \"([^\"]*)\" on source field$")
    public void iChooseDisableTheFilterToShowContactsWithOnSourceField(String sourceToDisable, String textToExpect) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,15);
        if(sourceToDisable.equals("Facebook")){
            ((JavascriptExecutor)driver).executeScript("document.getElementById(\"facebook_checkbox\").click();");
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//tbody/tr[2]/td[5]"),textToExpect));
        }else{
            ((JavascriptExecutor)driver).executeScript("document.getElementById(\"linked_in_checkbox\").click();");
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//tbody/tr[1]/td[5]"),textToExpect));
        }
    }

    @Then("^In all the rows the source column should have only  the text \"([^\"]*)\"$")
    public void inAllTheRowsTheSourceColumnShouldHaveOnlyTheText(String expectedText) throws Throwable {
        List<WebElement> contactsList = driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        for (WebElement elem: contactsList) {
            String text = elem.findElements(By.tagName("td")).get(4).getText();
            assertEquals(text, expectedText);
        }
    }

    @When("^I disable the filtering options of the switches$")
    public void iDisableTheFilteringOptionsOfTheSwitches() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,15);
        ((JavascriptExecutor)driver).executeScript("document.getElementById(\"facebook_checkbox\").click();");
        ((JavascriptExecutor)driver).executeScript("document.getElementById(\"linked_in_checkbox\").click();");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/h3")));
    }

    @Then("^the table will have the value \"([^\"]*)\"$")
    public void theTableWillHaveTheValue(String expectedText) throws Throwable {
        assertEquals(driver.findElement(By.xpath("//div[3]/h3")).getText(), expectedText);
    }

    @Then("^In all the rows the source column can have the text \"([^\"]*)\" or \"([^\"]*)\"$")
    public void inAllTheRowsTheSourceColumnCanHaveTheTextOr(String facebookStr, String linkedinStr) throws Throwable {
        List<WebElement> contactsList = driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        for (WebElement elem: contactsList) {
            String text = elem.findElements(By.tagName("td")).get(4).getText();
            if(text.equals(facebookStr)){
                assertEquals(text, facebookStr);
            }else if(text.equals(linkedinStr)){
                assertEquals(text, linkedinStr);
            }else{
                //just to make the assert fail
                assertEquals(text,facebookStr);
            }
        }
    }

    @When("^I click the  text \"([^\"]*)\"$")
    public void iClickTheText(String optionText) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,15);
        if(optionText.equals("Facebook")){
            ((JavascriptExecutor)driver).executeScript("document.getElementById(\"facebook_only_toggle\").click();");
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//tbody/tr[1]/td[5]"),optionText));
        }else{
            ((JavascriptExecutor)driver).executeScript("document.getElementById(\"linkedin_only_toggle\").click();");
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//tbody/tr[2]/td[5]"),optionText));
        }
    }

    @Then("^The number of table rows should be the same as the field \"([^\"]*)\"$")
    public void theNumberOfTableRowsShouldBeTheSameAsTheField(String id) throws Throwable {
        List<WebElement> contactsList = driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        String numContacts = driver.findElement(By.id(id)).getText();
        assertEquals(numContacts,Integer.toString(contactsList.size()));
    }

    @And("^I access the landing page again$")
    public void iAccessTheLandingPageAgain() throws Throwable {
        driver.get(baseURL);
    }
}
