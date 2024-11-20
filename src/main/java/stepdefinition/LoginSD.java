package stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static stepdefinition.Hooks.driver;

public class LoginSD {
   // WebDriver driver;
    @Given("I am on login page")
    public void i_am_on_login_page() {

        System.out.println("I am on login page");

        driver.get("https://stock.scriptinglogic.in/");
     }

   /* @Given ("I am on login page")
    public void anyNameFunction()
    {

    }*/


    @When("I enter correct username and password")
    public void i_enter_correct_username_and_password() {
        System.out.println("I enter correct username and password");

        driver.findElement(By.id("login-username")).sendKeys("admin");
        driver.findElement(By.id("login-password")).sendKeys("admin");

    }
    @When("I click on login button")
    public void i_click_on_login_button() {
        System.out.println("I click on login button");
        driver.findElement(By.name("submit")).click();

    }
    @Then("I should be redirected to home page")
    public void i_should_be_redirected_to_home_page() {
        System.out.println("I should be redirected to home page");
        String expected = "https://stock.scriptinglogic.in/dashboard.php";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(expected,actual);
     }

    @When("I enter incorrect username and password")
    public void iEnterIncorrectUsernameAndPassword() {
        driver.findElement(By.id("login-username")).sendKeys("sdsds");
        driver.findElement(By.id("login-password")).sendKeys("dsdsds");


    }

    @Then("I should get an error")
    public void iShouldGetAnError() {

        String expected = "POSNIC - Login to Control Panel";
        String actual = driver.getTitle();
        Assert.assertEquals(expected,actual);
    }

    @When("I enter blank username and password")
    public void iEnterBlankUsernameAndPassword() {

        driver.findElement(By.id("login-username")).sendKeys("");
        driver.findElement(By.id("login-password")).sendKeys("");

    }

    @When("I enter username as {string} and password as {string}")
    public void iEnterUsernameAsAndPasswordAs(String username, String password) {
        driver.findElement(By.id("login-username")).sendKeys(username);
        driver.findElement(By.id("login-password")).sendKeys(password);
    }

    @Given("I am on contact us page")
    public void iAmOnContactUsPage() {

        driver.get("https://scriptinglogic.org/contact");
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {

/*        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        WebElement submitBtn = driver.findElement(By.name("submit"));*/

      //  driver.findElement(By.name("submit")).click();

   //     js.executeScript("arguments[0].click()",submitBtn);
    }

    @When("I enter below data")
    public void iEnterBelowData(DataTable dataTable) {

        List<List<String>> data = dataTable.asLists();
        driver.findElement(By.xpath("//input[@placeholder='Whats App number']")).sendKeys(data.get(0).get(0));
        driver.findElement(By.xpath("//input[@placeholder='Your email address']")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("//textarea[@placeholder='Enter your message']")).sendKeys(data.get(0).get(2));


    }

    @When("I enter {} , {} ,{}")
    public void iEnter(String number, String email, String message) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");

        driver.findElement(By.xpath("//input[@placeholder='Whats App number']")).sendKeys(number);
        driver.findElement(By.xpath("//input[@placeholder='Your email address']")).sendKeys(email);
        driver.findElement(By.xpath("//textarea[@placeholder='Enter your message']")).sendKeys(message);

    }

    @Given("open the browser")
    public void openTheBrowser() {
        driver = new ChromeDriver();

    }

    @And("I maximixe it")
    public void iMaximixeIt() {
        driver.manage().window().maximize();
    }

    @Given("I am logged in with valid credentials")
    public void iAmLoggedInWithValidCredentials() {
        
    }

    @And("I click on add button")
    public void iClickOnAddButton() {
    }

    @When("I add this data {} , {} , {} , {}")
    public void iAddThisData(String name, String address, String contact1, String contact2) {


        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("contact1")).sendKeys(contact1);
        driver.findElement(By.name("contact2")).sendKeys(contact2);
        driver.findElement(By.name("Submit")).click();
    }

    @And("I go to add customer page")
    public void iGoToAddCustomerPage() {
        WebElement lnkAddCustomer = driver.findElement(By.partialLinkText("d Cust"));
        lnkAddCustomer.click();
    }
}
