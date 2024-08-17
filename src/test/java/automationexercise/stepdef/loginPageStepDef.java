package automationexercise.stepdef;

import com.opencsv.CSVReader;
import automationexercisepage.loginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusablefunctions.ReadExcelFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class loginPageStepDef {

    public WebDriver driver;
    loginPage LoginPage;


    @Before
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Given("I am on the automationexercise Home page and home page is visible")
    public void I_am_on_the_automationexercise_Home_page_and_home_page_is_visible() {
        driver.get("http://automationexercise.com/");
        LoginPage = new loginPage(driver);
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Welcome Page is not displayed");

    }


    @Given("I clicked on SignupLogin button")
    public void I_clicked_on_SignupLogin_button() {
        LoginPage.clickSignupLoginButton();

    }

    @And("verify 'Login to your account' is visible")
    public void verify_Login_to_your_account_is_visible() {

        Assert.assertEquals(LoginPage.checkLoginToYourAccount(), true, "Login to your account is not visible");
    }

    @Given("I have submitted a valid username and Password")
    public void i_have_entered_a_valid_username_and_password() {
        LoginPage.enterEmail("Manwendranegi865@gmail.com");
        LoginPage.enterPassword("M@n1draa");
        LoginPage.clickLoginButton();
    }

    @And("I have submitted invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        LoginPage.enterEmail(username);
        LoginPage.enterPassword(password);
        LoginPage.clickLoginButton();
    }


    @Then("Verify that 'Logged in as username' is visible")
    public void Verify_that_Logged_in_as_username_is_visible() {
        Assert.assertEquals(LoginPage.LoggedInAsUsername(), true, "Logged in as username is not visible");
    }


    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        // Assert that an error message is displayed on the page matching the expected error message
        Assert.assertEquals(LoginPage.checkErrorMessage().getText(), errorMessage, "Your email or password is incorrect!' is not visible");
    }


    @Given("I have Add products to cart")
    public void I_have_Add_products_to_cart() throws InterruptedException {
        LoginPage.performMousehover();
        LoginPage.clickusingjavascriptExecuterAddcart();
    }


    @When("i clicked on view cart button")
    public void I_clicked_on_cart_button() {
        LoginPage.clickusingjavascriptExecuterviewcart();

    }

    @And("Verify that cart page is displayed")
    public void Verify_that_cart_page_is_displayed() {

        Assert.assertEquals(LoginPage.shoppingCartVisible(), true, "cart page is not displayed");
    }

    @Then("Click 'X' button corresponding to particular product")
    public void Click_cross_button_and_Verify_product_is_removed() throws InterruptedException {
        LoginPage.clickcrossButton();

    }

    @And("Verify that empty cart page is displayed")
    public void Verify_that_empty_cart_page_is_displayed() {

        Assert.assertEquals(LoginPage.cartempty(), true, "blue top item is present");
    }

    @Then("Click Proceed To Checkout")
    public void click_proceed_to_checkout() {
        LoginPage.ClickProceedtoCheckoutButton();

    }

    @Then("Verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() {
        Assert.assertEquals(LoginPage.DeliveryTextisDisplayed(), true, "Address details is incorrect");
        Assert.assertEquals(LoginPage.ReviewOrderblueTopisDisplayed(), true, "order details is incorrect");
    }

    @Then("Enter description in comment text area and click on Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {
        LoginPage.EnterDescriptionBoxMessage("Order Address and order Details are correct");
        LoginPage.ClickPlaceOrderButton();

    }

    @Then("Enter payment details: Name on Card, Card Number, CVC, Expiration date with following details")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date_with_following_details(DataTable dataTable) {

        List<Map<String, String>> Payment = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> e : Payment) {

            LoginPage.EnterNameOnCard(e.get("NameOnCard"));
            LoginPage.EnterCardNo(e.get("CardNumber"));
            LoginPage.EnterCVV(e.get("CVV"));
            LoginPage.EnterExpirationMonth(e.get("ExpirationMonth"));
            LoginPage.EnterExpirationYear(e.get("ExpirationYear"));

        }

    }

    @Then("Click Pay and Confirm Order button")
    public void click_Pay_andConfirm_button() throws InterruptedException {
        LoginPage.ClickPayAndConfirmButton();
        Thread.sleep(1000);
    }

    @Then("Verify success message Your order has been placed successfully")
    public void verify_order_placed_success_message() {
        Assert.assertEquals(LoginPage.OrderPlacedTextisDisplayed(), true, "order is not placed successfully");
    }

    @Then("click on Logout Button")
    public void click_Logout_button() {

        LoginPage.clickLogoutButton();
    }


    @Then("Verify New User Signup! is visible")
    public void verify_new_user_signup_is_visible() {
        Assert.assertEquals(LoginPage.NewUserSignupTextisDisplayed(), true, "New User Signup! Text is not visible");

    }

    @Test(dataProvider = "readExcel")
    @Then("I filled all the necessary details to To create a Account and click create Account button")

    public void i_filled_all_the_necessary_details_to_to_create_a_account_and_click_create_account_button() throws IOException {


        // LoginPage.entervalues(Name,Email,Password,Day,Month,Year,FirstName,LastName,Company,Address1,Address2,Country,State,City,Zip,MobileNo);

        ReadExcelFile reader = new ReadExcelFile();
        String[][] values = reader.readExcel("C:\\Training\\TestExcel.xlsx", "Testing");
        for (String[] entries : values) {
            LoginPage.EnteruserNameAndEmail(entries[0], entries[1]);
            LoginPage.EnterSinupPassword(entries[2]);
            LoginPage.EnterdropdownDay(entries[3]);
            LoginPage.EnterdropdownMonth(entries[4]);
            LoginPage.EnterdropdownYear(entries[5]);
            LoginPage.EnterSignUpFirstname(entries[6]);
            LoginPage.EnterSignUpLastname(entries[7]);
            LoginPage.EnterCompanyname(entries[8]);
            LoginPage.EnterSignUpAddress1Locator(entries[9]);
            LoginPage.EnterSignUpAddress2Locator(entries[10]);
            LoginPage.EnterdropdownCountry(entries[11]);
            LoginPage.EnterState(entries[12]);
            LoginPage.Entercity(entries[13]);
            LoginPage.Enterzip(entries[14]);
            LoginPage.EnterMobileNo(entries[15]);


        }
    }

    @Then("Verify that ACCOUNT CREATED! is visible")
    public void verify_that_account_created_is_visible() {

        Assert.assertEquals(LoginPage.VerifyAccountCreatedTextisDisplayed(), true, "ACCOUNT CREATED! Text is not visible");
    }

    @Then("Click on Continue button")
    public void click_on_continue_button() {

        LoginPage.ClickContinueButton();
    }

    @Then("I Click Delete Account button")
    public void i_click_delete_account_button() {

        LoginPage.ClickDeleteAccountButton();

    }

    @Then("Verify that that ACCOUNT DELETED! is visible")
    public void verify_that_that_account_deleted_is_visible() {

        Assert.assertEquals(LoginPage.VerifyAccountDeletedTextisDisplayed(), true, "ACCOUNT DELETED! Text is not visible");

    }

    @Then("Click Register Login button")
    public void click_register_login_button() {
        LoginPage.clickRegisterLoginButton();
    }

    @Then("Click Cart button")
    public void click_cart_button() {
        LoginPage.clickCartButton();
    }

    @Then("Click Download Invoice button and verify invoice is downloaded successfully")
    public void click_download_invoice_button_and_verify_invoice_is_downloaded_successfully() {

        LoginPage.clickDownloadInvoiceButton();
    }

    @Then("I  Fill all details in Signup and create account")
    public void i_fill_all_details_in_signup_and_create_account() throws IOException, InterruptedException {

        CSVReader reader = new CSVReader(new FileReader("C:\\Training\\RegisterExcel.csv"));

        String csvCell[];

        while ((csvCell = reader.readNext()) != null) {
            String Name = csvCell[0];
            String Email = csvCell[1];
            String Password = csvCell[2];
            String Day = csvCell[3];
            String Month = csvCell[4];
            String Year = csvCell[5];
            String FirstName = csvCell[6];
            String LastName = csvCell[7];
            String Company = csvCell[8];
            String Address1 = csvCell[9];
            String Address2 = csvCell[10];
            String Country = csvCell[11];
            String State = csvCell[12];
            String City = csvCell[13];
            String Zip = csvCell[14];
            String MobileNo = csvCell[15];



            LoginPage.EnteruserNameAndEmail(Name,Email);
            LoginPage.ClickSignupButton();
            LoginPage.ClickTitleRadioButton();
            LoginPage.EnterSinupPassword(Password);
            LoginPage.EnterdropdownDay(Day);
            LoginPage.EnterdropdownMonth(Month);
            LoginPage.EnterdropdownYear(Year);
            LoginPage.CheckNewsletterButton();
            LoginPage.CheckRecieveSpeialOfferButton();
            LoginPage.EnterSignUpFirstname(FirstName);
            LoginPage.EnterSignUpLastname(LastName);
            LoginPage.EnterCompanyname(Company);
            LoginPage.EnterSignUpAddress1Locator(Address1);
            LoginPage.EnterSignUpAddress2Locator(Address2);
            LoginPage.EnterdropdownCountry(Country);
            LoginPage.EnterState(State);
            LoginPage.Entercity(City);
            LoginPage.Enterzip(Zip);
            LoginPage.EnterMobileNo(MobileNo);


            Thread.sleep(5000);
            LoginPage.ClickCreateAccountButton();

        }


    }
}