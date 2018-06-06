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
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

public class US4StepsDef {
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

    @Given("^I access the Duplicate Contact page$")
    public void iAccessTheDuplicateContactPage() throws Throwable {
        driver.get(baseURL + "/duplicate.php");
        assertEquals("Contacts Orchestrator Solution - Duplicated contacts", driver.getTitle());
    }

    @Then("^The Manage Duplicate Contact Page appear with the title \"([^\"]*)\"$")
    public void theManageDuplicateContactPageAppearWithTheTitle(String title) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains(title));
    }

    @Then("^The table should have the columns: \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theTableShouldHaveTheColumnsAnd(String duplicate, String number, String action) throws Throwable {
        assertEquals(driver.findElement(By.xpath("//td[1]")).getText(), duplicate);
        assertEquals(driver.findElement(By.xpath("//td[2]")).getText(), number);
        assertEquals(driver.findElement(By.xpath("//td[3]")).getText(), action);
    }

    @When("^I click on the Back Button$")
    public void iClickOnTheBackButton() throws Throwable {
        driver.findElement(By.xpath("//a[1]")).click();
    }

    @When("^I click on the Export Button$")
    public void iClickOnTheExportButton() throws Throwable {
        driver.findElement(By.xpath("/html[1]/body[1]/div[@class=\"container\"]/div[1]/a[@class=\"btn btn-success\"]")).click();
    }

    @Then("^The file cvs is downloaded$")
    public void theFileCvsIsDownloaded() throws Throwable {
        Assert.assertTrue(isFileDownloaded());
    }

    public boolean isFileDownloaded() throws IOException {
        final Path dir = Paths.get(System.getProperty("java.io.tmpdir"));

        final DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir);

        for (Path p : dirStream) {
            String dat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            String fileName = "solved_duplicates_" + dat + ".csv";
            if (p.getFileName().equals(fileName))
                return true;
        }
        return false;
    }

    @Then("^For each duplicated contact i have the options to \"([^\"]*)\" and \"([^\"]*)\"$")
    public void forEachDuplicatedContactIHaveTheOptionsToAnd(String solve, String cancel) throws Throwable {
        driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[3]/a[@class=\"btn btn-success\"]"));
        driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[3]/a[@class=\"btn btn-default\"]"));
    }

    @Given("^I click on the Solve Button$")
    public void iClickOnTheSolveButton() throws Throwable {

    }
    @Then("^I access to the Solve duplicate page$")
    public void iAccessToTheSolveDuplicatePage() throws Throwable {
        driver.get(baseURL + "/solve_duplicate.php?duplicate_field=Name&key=Joao%20Santos");
        assertEquals("Contacts Orchestrator Solution - Solve duplicated contact", driver.getTitle());
    }
    @Given("^I click on the Cancel Button$")
    public void iClickOnTheCancelButton() throws Throwable {
        driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[3]/a[@class=\"btn btn-default\"]")).click();
    }


    @Given("^I click on the Solve Button of the row name \"([^\"]*)\"$")
    public void iClickOnTheSolveButtonOfTheRowName(String Name) throws Throwable {
        assertEquals(driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[1]")).getText(),"Name: "+Name);
    }
    @Then("^The rows of \"([^\"]*)\" disappear$")
    public void theRowsOfDisappear(String name) throws Throwable {
        assertFalse(driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[1]")).getText()=="Name: "+name);
    }



    @Given("^I click on the \"([^\"]*)\" Button of the row name \"([^\"]*)\"$")
    public void iClickOnTheButtonOfTheRowName(String solve, String name) throws Throwable {
        assertEquals(driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[3]/a[@class=\"btn btn-success\"]")).getText(),solve);

    }


    @Given("^I send the \"([^\"]*)\" and \"([^\"]*)\" which parameters in the url$")
    public void iSendTheAndWhichParametersInTheUrl(String name, String surname) throws Throwable {
        driver.get(baseURL+"/solve_duplicate.php?duplicate_field=Name&key="+name+"%20"+surname);
        assertEquals("Contacts Orchestrator Solution - Solve duplicated contact", driver.getTitle());
    }



    @Then("^I receive \"([^\"]*)\" \"([^\"]*)\" in the View$")
    public void iReceiveInTheView(String firstname, String surname) throws Throwable {
        assertEquals(driver.findElement(By.tagName("label")).getText(),firstname+" "+surname);
    }

    @Given("^I click on the \"([^\"]*)\" Button of the row name \"([^\"]*)\" with the \"([^\"]*)\"$")
    public void iClickOnTheButtonOfTheRowNameWithThe(String solve, String firstname, String surname) throws Throwable {
        driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[3]/a[@class=\"btn btn-success\"]")).click();

    }

    @Given("^I click on the \"([^\"]*)\" Button of the row number \"([^\"]*)\"$")
    public void iClickOnTheButtonOfTheRowNumber(String arg0, String arg1) throws Throwable {
        driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[23]/td[3]/a[@class=\"btn btn-success\"]")).click();
    }

    @Given("^I send the \"([^\"]*)\" which parameters in the url$")
    public void iSendTheWhichParametersInTheUrl(String number) throws Throwable {
        // solve_duplicate.php?duplicate_field=Phone&key=232582789
        driver.get(baseURL+"/solve_duplicate.php?duplicate_field=Phone&key="+number);
        assertEquals("Contacts Orchestrator Solution - Solve duplicated contact", driver.getTitle());
    }

    @Given("^I click on the \"([^\"]*)\" Button of the row email \"([^\"]*)\"$")
    public void iClickOnTheButtonOfTheRowEmail(String arg0, String arg1) throws Throwable {
        driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[23]/td[3]/a[@class=\"btn btn-success\"]")).click();
    }

    @Then("^I send the email \"([^\"]*)\" which parameters in the url$")
    public void iSendTheEmailWhichParametersInTheUrl(String email) throws Throwable {
        driver.get(baseURL+"/solve_duplicate.php?duplicate_field=Email&key="+email);
        assertEquals("Contacts Orchestrator Solution - Solve duplicated contact", driver.getTitle());
    }

    @Given("^I click on the \"([^\"]*)\" Button with the \"([^\"]*)\"$")
    public void iClickOnTheButtonWithThe(String cancel, String resource) throws Throwable {
        assertEquals(driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[3]/a[@class=\"btn btn-default\"]")).getText(),cancel);
    }

    @Then("^the landing page of should appear$")
    public void theLandingPageOfShouldAppear() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.titleContains("Contacts Orchestrator Solution"));
        assertEquals(driver.findElement(By.tagName("title")).getText(), "Contacts Orchestrator Solution");
    }
}