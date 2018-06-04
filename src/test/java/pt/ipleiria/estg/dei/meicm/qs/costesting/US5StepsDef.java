package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;


public class US5StepsDef {
    private WebDriver driver;
    private String baseURL;
    private Date date = new Date();

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver(true);
        baseURL = System.getProperty("baseUrl");
        if (baseURL == null)
            baseURL = "http://localhost:8080";
    }

    @After
    public void tearDown() throws Exception {

    }

    @Given("^I access the Duplicate Contact page with a clean session$")
    public void iAccessTheDuplicateContactPageWithACleanSession() throws Throwable {
        driver.get(baseURL + "/duplicate.php?clear_session=true");
        assertEquals("Contacts Orchestrator Solution - Duplicated contacts", driver.getTitle());
    }

    @When("^I click on the first Solve Button$")
    public void iClickOnTheFirstSolveButton() throws Throwable {
        driver.findElement(By.xpath("//tr[1]/td[3]/a[1]")).click();
    }

    @Then("^I can see the fields \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iCanSeeTheFieldsAnd(String name, String photo, String email, String birthday, String company, String city, String occupation, String source, String streetAddr) throws Throwable {
       assertEquals(driver.findElement(By.xpath("//tr[1]/td[1]")).getText(), name);
       assertEquals(driver.findElement(By.xpath("//tr[2]/td[1]")).getText(), photo);
       assertEquals(driver.findElement(By.xpath("//tr[3]/td[1]")).getText(), email);
       assertEquals(driver.findElement(By.xpath("//tr[4]/td[1]")).getText(), birthday);
       assertEquals(driver.findElement(By.xpath("//tr[5]/td[1]")).getText(), company);
       assertEquals(driver.findElement(By.xpath("//tr[6]/td[1]")).getText(), city);
       assertEquals(driver.findElement(By.xpath("//tr[7]/td[1]")).getText(), occupation);
       assertEquals(driver.findElement(By.xpath("//tr[8]/td[1]")).getText(), source);
       assertEquals(driver.findElement(By.xpath("//tr[9]/td[1]")).getText(), streetAddr);
    }

    @Then("^the title should be \"([^\"]*)\"$")
    public void theTitleShouldBe(String title) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains(title));
        assertEquals(driver.findElement(By.tagName("title")).getText(), title);
    }

    @When("^I click on the go back button$")
    public void iClickOnTheGoBackButton() throws Throwable {
        driver.findElement(By.xpath("//a")).click();
    }

    @Then("^the manage duplicate contacts page should appear$")
    public void theManageDuplicateContactsPageShouldAppear() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains("Contacts Orchestrator Solution - Duplicated contacts"));
        assertEquals(driver.findElement(By.tagName("title")).getText(), "Contacts Orchestrator Solution - Duplicated contacts");
    }

    @And("^I click on the go save button$")
    public void iClickOnTheGoSaveButton() throws Throwable {
        driver.findElement(By.xpath("//button")).click();
    }

    @Then("^the manage duplicate contacts page should appear without the solved duplicate \"([^\"]*)\"$")
    public void theManageDuplicateContactsPageShouldAppearWithoutTheSolvedDuplicate(String name) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains("Contacts Orchestrator Solution - Duplicated contacts"));
        assertEquals(driver.findElement(By.tagName("title")).getText(), "Contacts Orchestrator Solution - Duplicated contacts");
        assertFalse(driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText()=="Name: "+name);
    }
}
