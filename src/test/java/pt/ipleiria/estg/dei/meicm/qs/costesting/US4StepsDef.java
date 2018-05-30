package pt.ipleiria.estg.dei.meicm.qs.costesting;

import com.github.tomakehurst.wiremock.WireMockServer;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import java.io.FileFilter;
import java.nio.file.FileSystems;
public class US4StepsDef {
    private WebDriver driver;
    private String baseURL;
    private Date date = new Date();
    //    private final WireMockServer wireMockServer = new WireMockServer();
//    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static String downloadPath = "C:\\Users\\homer\\Downloads";

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver(true);
        baseURL = System.getProperty("baseUrl");
        if (baseURL == null)
            baseURL = "http://35.195.26.198";
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
        driver.findElement(By.xpath("/html[1]/body[1]/div[@class=\"container\"]/div[1]/a[@class=\"btn btn-primary\"]")).click();
    }

    @When("^I click on the Export Button$")
    public void iClickOnTheExportButton() throws Throwable {
        driver.findElement(By.xpath("/html[1]/body[1]/div[@class=\"container\"]/div[1]/a[@class=\"btn btn-success\"]")).click();
    }

    @Then("^The file cvs is downloaded$")
    public void theFileCvsIsDownloaded() throws Throwable {
        Assert.assertTrue(isFileDownloaded());
    }

    public boolean isFileDownloaded() {
        String home = System.getProperty("user.home");
        home += "\\Downloads";
        home += "";
        boolean flag = false;
        File dir = new File(home);
        System.out.println(dir);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            String dat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            String fileName = "solved_duplicates_" + dat + ".csv";
            if (dir_contents[i].getName().equals(fileName))
                return flag = true;
        }
        return flag;
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


    @Given("^I click on the Solve Button of the row$")
    public void iClickOnTheSolveButtonOfTheRow() throws Throwable {
        driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[1]/a[@class=\"btn btn-success\"]")).click();

    }

    @Given("^I click on the Solve Button of the row name \"([^\"]*)\"$")
    public void iClickOnTheSolveButtonOfTheRowName(String Name) throws Throwable {
     assertEquals(driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[1]")).getText(),"Name: "+Name);
    }
    @Then("^The rows of \"([^\"]*)\" disappear$")
    public void theRowsOfDisappear(String name) throws Throwable {
        assertFalse(driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[1]")).getText()=="Name: "+name);
    }

    @Given("^I click on the \"([^\"]*)\" Button with the name \"([^\"]*)\"$")
    public void iClickOnTheButtonWithTheName(String cancel, String name) throws Throwable {
        assertEquals(driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[3]/a[@class=\"btn btn-default\"]")).getText(),cancel);
    }

    @Given("^I click on the \"([^\"]*)\" Button of the row name \"([^\"]*)\"$")
    public void iClickOnTheButtonOfTheRowName(String solve, String name) throws Throwable {
        assertEquals(driver.findElement(By.xpath("id(\"duplicate_contacts_table_holder\")/table[@class=\"table table-striped\"]/tbody[1]/tr[1]/td[3]/a[@class=\"btn btn-success\"]")).getText(),solve);

    }

    @Then("^I recive \"([^\"]*)\" in the View$")
    public void iReciveInTheView(String name) throws Throwable {
        assertEquals(driver.findElement(By.xpath("id(\"solve_duplicate_content\")/table[@class=\"table table-bordered\"]/tbody[1]/tr[1]/td[2]/div[@class=\"radio\"]/label[1]")).getText(),name);
    }

    @Given("^I send the \"([^\"]*)\" and \"([^\"]*)\" which parameters in the url$")
    public void iSendTheAndWhichParametersInTheUrl(String name, String surname) throws Throwable {
        driver.get(baseURL+"/solve_duplicate.php?duplicate_field=Name&key="+name+"%20"+surname);
        assertEquals("Contacts Orchestrator Solution - Solve duplicated contact", driver.getTitle());
    }
}