package automationexercisepage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reusablefunctions.ReadExcelFile;

import java.io.IOException;

public class loginPage {

     WebDriver driver;
    Actions action;

    // Locators
     By emailInputLocator = By.name("email");
     By passwordInputLocator = By.name("password");
     By loginButtonLocator = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");

     By SignupLoginButtonLocator=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    By LoginToYourAccountLocator=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");


     By LoggedInAsUsernameLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");

     By addtoCartbuttonLocator =By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a");

     By viewCartbuttonLocator=By.cssSelector("#cartModal > div > div > div.modal-body > p:nth-child(2) > a > u");

      By shoppingCartVisibleLocator=By.xpath( "//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]");

    By HowerCrossButtonLocator=By.xpath("//*[@id=\"product-1\"]/td[6]/a");

     By CrossButtonLocator=By.cssSelector( "#product-1 > td.cart_delete > a");


    By blueTopPresentornotLocator=By.xpath( "//*[@id=\"product-1\"]/td[2]/h4/a");
    By cartemptyLocator=By.xpath("//*[@id=\"empty_cart\"]/p/a/u");
    By MouseHowerblueTopLocator=By.xpath( "/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/img");



    By ProceedtoCheckoutButtonLocator=By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");

    By DeliveryTextLocator=By.xpath("//*[@id=\"address_delivery\"]/li[1]/h3");

    By ReviewOrderblueTopLocator=By.xpath( "//*[@id=\"product-1\"]/td[2]/h4/a");

    By DescriptionBoxLocator=By.xpath("//*[@id=\"ordermsg\"]/textarea");

    By PlaceOrderButtonLocator= By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");

    By NameOnCardLocator=By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input");

    By CardNoLocator=By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input");

    By CVVLocator=By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input");

    By ExpirationMonthLocator=By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input");
    By ExpirationYearLocator=By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input");

    By PayAndConfirmButtonLocator=By.xpath("//*[@id=\"submit\"]");

    By OrderPlacedSucessLocator=By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");

    By ErrorMessageLocator=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");

    By LogoutButtonLocator=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
//---------------------------------------------------------------------------------------------
    By NewUserSignupTextLocator=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");

    By NameSignupLocator=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");

    By emailSignupLocator=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");

    By SignUpButtonLocator=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");

    By AccountInformationTextLocator=By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");

    By TitleRadioButtonLocator=By.xpath("//*[@id=\"id_gender1\"]");

    By SinupPasswordLocator=By.xpath("//*[@id=\"password\"]");

    By DOBDayDropdownLocator=By.xpath("//*[@id=\"days\"]");
    By DOBMonthDropdownLocator=By.xpath("//*[@id=\"months\"]");
    By DOByearDropdownLocator=By.xpath("//*[@id=\"years\"]");

    By NewsLetterCheckboxLocator=By.xpath("//*[@id=\"newsletter\"]");

    By SpecialOfferCheckboxLocator=By.xpath("//*[@id=\"optin\"]");

    By SignUpFirstnameLocator=By.xpath("//*[@id=\"first_name\"]");

    By SignUpLastnameLocator=By.xpath("//*[@id=\"last_name\"]");

    By SignUpCompanyLocator=By.xpath("//*[@id=\"company\"]");

    By SignUpAddress1Locator=By.xpath("//*[@id=\"address1\"]");

    By SignUpAddress2Locator=By.xpath("//*[@id=\"address2\"]");

    By SignUpCountryLocator=By.xpath("//*[@id=\"country\"]");

    By SignUpStateLocator=By.xpath("//*[@id=\"state\"]");

    By SignUpCityLocator=By.xpath("//*[@id=\"city\"]");

    By SignUpZipLocator=By.xpath("//*[@id=\"zipcode\"]");

    By SignUpMobileNoLocator=By.xpath("//*[@id=\"mobile_number\"]");
    By CreateAccountButtonLocator=By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");

    By AccountCreatedTextLocator=By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");

    By ContinueButtonLocator=By.xpath("//*[@id=\"form\"]/div/div/div/div/a");


    By DeleteAccountButtonLocator=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

    By AccountDeletedTextLocator=By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");

//    By AccountDeletedContinueButtonLocator=By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    //*[@id="form"]/div/div/div/div/a
    //*[@id="form"]/div/div/div/div/a

 //-------------------------------------------------------------------------------------------------

By RegisterLoginButtonLocator=By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u");
By CartButtonLocator=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");

By DownloadInvoiceButtonLocator=By.xpath("//*[@id=\"form\"]/div/div/div/a");


    // Constructor
    public loginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();

    }

    public void clickRegisterLoginButton() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()",driver.findElement(RegisterLoginButtonLocator));
    }

    public  void clickCartButton() {
        WebElement cartButton = driver.findElement(CartButtonLocator);
        cartButton.click();
    }


    public  void clickDownloadInvoiceButton() {
        WebElement downloadButton = driver.findElement(DownloadInvoiceButtonLocator);
        downloadButton.click();
    }
    // page Methods
    public  void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public  void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public  void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void clickSignupLoginButton() {
        WebElement SignupLoginButton = driver.findElement(SignupLoginButtonLocator);
        SignupLoginButton.click();
    }

    public  boolean checkLoginToYourAccount(){
        return driver.findElement(LoginToYourAccountLocator).isDisplayed();
    }


    public void performMousehover() {
        action =new Actions(driver);
         action.moveToElement(driver.findElement(MouseHowerblueTopLocator)).build().perform();

    }

    public void clickusingjavascriptExecuterAddcart() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()",driver.findElement(addtoCartbuttonLocator));
        Thread.sleep(1000);

    }
    public void clickusingjavascriptExecuterviewcart() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()",driver.findElement(viewCartbuttonLocator));
    }




    public boolean shoppingCartVisible(){
        return driver.findElement(shoppingCartVisibleLocator).isDisplayed();
    }

    public void clickcrossButton() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()",driver.findElement(CrossButtonLocator));
        Thread.sleep(1000);
    }

    public boolean cartempty(){
        return driver.findElement(cartemptyLocator).isDisplayed();
    }
    public  boolean LoggedInAsUsername(){
        return driver.findElement(LoggedInAsUsernameLocator).isDisplayed();
    }

    public  WebElement checkErrorMessage() {
     return driver.findElement(ErrorMessageLocator);
    }
    public  void ClickProceedtoCheckoutButton() {
        WebElement ProceedtoCheckout = driver.findElement(ProceedtoCheckoutButtonLocator);
        ProceedtoCheckout.click();
    }

    public  boolean DeliveryTextisDisplayed(){
        return driver.findElement(DeliveryTextLocator).isDisplayed();
    }

    public  boolean ReviewOrderblueTopisDisplayed(){
        return driver.findElement(ReviewOrderblueTopLocator).isDisplayed();
    }

    public  void EnterDescriptionBoxMessage(String message) {
        WebElement DescriptionBoxMessage = driver.findElement(DescriptionBoxLocator);
        DescriptionBoxMessage.sendKeys(message);
    }
        public  void ClickPlaceOrderButton() {
            WebElement PlaceOrder = driver.findElement(PlaceOrderButtonLocator);
            PlaceOrder.click();
    }


    public  void EnterNameOnCard(String Name) {
       WebElement NameOnCard = driver.findElement(NameOnCardLocator);
       NameOnCard.sendKeys(Name);
    }

    public  void EnterCardNo(String cardNo) {
        WebElement card = driver.findElement(CardNoLocator);
        card.sendKeys(cardNo);
    }

    public  void EnterCVV(String CVV) {
        WebElement cvvLoc = driver.findElement(CVVLocator);
        cvvLoc.sendKeys(CVV);
    }
    public  void EnterExpirationMonth(String ExpirationMonth) {
        WebElement ExpMonth = driver.findElement(ExpirationMonthLocator);
        ExpMonth.sendKeys(ExpirationMonth);
    }
    public  void EnterExpirationYear(String ExpirationYear)  {
        WebElement ExpYear = driver.findElement(ExpirationYearLocator);
        ExpYear.sendKeys(ExpirationYear);

    }

    public  void ClickPayAndConfirmButton() {
        WebElement PayAndConfirm = driver.findElement(PayAndConfirmButtonLocator);
        PayAndConfirm.click();
    }

    public  boolean OrderPlacedTextisDisplayed(){
        return driver.findElement(OrderPlacedSucessLocator).isDisplayed();
    }


    public  void clickLogoutButton() {
      //  WebElement logoutButton = driver.findElement(LogoutButtonLocator);
        //logoutButton.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()",driver.findElement(LogoutButtonLocator));
    }
//-----------------------------------------------------------------------
    public  boolean NewUserSignupTextisDisplayed(){
        return driver.findElement(NewUserSignupTextLocator).isDisplayed();
    }
    public  void EnteruserNameAndEmail(String name,String SignupEmail) {
        WebElement nameInput = driver.findElement(NameSignupLocator);
        nameInput.sendKeys(name);
        WebElement SignupEmailInput = driver.findElement(emailSignupLocator);
        SignupEmailInput.sendKeys(SignupEmail);
    }

    public  void ClickSignupButton() throws InterruptedException {
        WebElement Signup = driver.findElement(SignUpButtonLocator);
        Signup.click();
        Thread.sleep(1000);
    }


    public  boolean AccountInformationTextisDisplayed(){
        return driver.findElement(AccountInformationTextLocator).isDisplayed();
    }
    public  void ClickTitleRadioButton() {
        WebElement TitleRadio = driver.findElement(TitleRadioButtonLocator);
        TitleRadio.click();
    }


    public  void EnterSinupPassword(String signpassword) {
        WebElement SinupPassword = driver.findElement(SinupPasswordLocator);
        SinupPassword.sendKeys(signpassword);
    }

    public  void EnterdropdownDay(String dropdownDay) {
        WebElement DOBday = driver.findElement(DOBDayDropdownLocator);
        DOBday.sendKeys(dropdownDay);
    }

    public  void EnterdropdownMonth(String dropdownMonth) {
        WebElement DOBMonth = driver.findElement(DOBMonthDropdownLocator);
        DOBMonth.sendKeys(dropdownMonth);
    }

    public  void EnterdropdownYear(String dropdownYear) {
        WebElement DOBYear = driver.findElement(DOByearDropdownLocator);
        DOBYear.sendKeys(dropdownYear);
    }

    public  void CheckNewsletterButton() {
        WebElement Newsletter = driver.findElement(NewsLetterCheckboxLocator);
        Newsletter.click();
    }

    public  void CheckRecieveSpeialOfferButton() {
        WebElement RecieveSpeialOffer = driver.findElement(SpecialOfferCheckboxLocator);
        RecieveSpeialOffer.click();
    }


    public  void EnterSignUpFirstname(String SignUpFirstname) {
        WebElement signFN = driver.findElement(SignUpFirstnameLocator);
        signFN.sendKeys(SignUpFirstname);
    }

    public  void EnterSignUpLastname(String SignUpLastname) {
        WebElement signLN = driver.findElement(SignUpLastnameLocator);
        signLN.sendKeys(SignUpLastname);
    }

    public  void EnterCompanyname(String Companyname) {
        WebElement CompName = driver.findElement(SignUpCompanyLocator);
        CompName.sendKeys(Companyname);
    }

    public  void EnterSignUpAddress1Locator(String SignUpAddress1) {
        WebElement signAd1 = driver.findElement(SignUpAddress1Locator);
        signAd1.sendKeys(SignUpAddress1);
    }

    public  void EnterSignUpAddress2Locator(String SignUpAddress2) {
        WebElement signAd2 = driver.findElement(SignUpAddress2Locator);
        signAd2.sendKeys(SignUpAddress2);
    }

    public  void EnterdropdownCountry(String dropdownCountry) {
        WebElement DrpCountry = driver.findElement(SignUpCountryLocator);
        DrpCountry.sendKeys(dropdownCountry);
    }
    public  void EnterState(String state) {
        WebElement StName = driver.findElement(SignUpStateLocator);
        StName.sendKeys(state);
    }

    public  void Entercity(String city) {
        WebElement CTName = driver.findElement(SignUpCityLocator);
        CTName.sendKeys(city);
    }

    public  void Enterzip(String zip) {
        WebElement ZipName = driver.findElement(SignUpZipLocator);
        ZipName.sendKeys(zip);
    }

    public  void EnterMobileNo(String MobileNo) {
        WebElement MNo = driver.findElement(SignUpMobileNoLocator);
        MNo.sendKeys(MobileNo);
    }


    public  void ClickCreateAccountButton() {
        WebElement CreateAccount = driver.findElement(CreateAccountButtonLocator);
        CreateAccount.click();

    }

    public  boolean VerifyAccountCreatedTextisDisplayed(){
        return driver.findElement(AccountCreatedTextLocator).isDisplayed();
    }

    public  void ClickContinueButton() {

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()",driver.findElement(ContinueButtonLocator));
    }



    public  void ClickDeleteAccountButton() {
        WebElement DeleteAccount = driver.findElement(DeleteAccountButtonLocator);
        DeleteAccount.click();
    }

    public  boolean VerifyAccountDeletedTextisDisplayed(){
        return driver.findElement(AccountDeletedTextLocator).isDisplayed();
    }

    @Test(dataProvider="readExcel")
    public void entervalues (String Name, String Email, String Password, String Day, String Month, String
        Year, String FirstName, String LastName, String Company, String Address1, String Address2, String
        Country, String State, String City, String Zip, String MobileNo){

        EnteruserNameAndEmail(Name, Email);
        EnterSinupPassword(Password);
        EnterdropdownDay(Day);
        EnterdropdownMonth(Month);
        EnterdropdownYear(Year);
        EnterSignUpFirstname(FirstName);
        EnterSignUpLastname(LastName);
        EnterCompanyname(Company);
        EnterSignUpAddress1Locator(Address1);
        EnterSignUpAddress2Locator(Address2);
        EnterdropdownCountry(Country);
        EnterState(State);
        Entercity(City);
        Enterzip(Zip);
        EnterMobileNo(MobileNo);

    }
    @DataProvider(name="readExcel")
    public String[][] readData() throws IOException
    {
        ReadExcelFile reader = new ReadExcelFile();
        String[][] values= reader.readExcel("C:\\Users\\850751\\LoginUserwithincorrectemailandpassword\\TestExcel.xlsx", "Testing");
        return values;

    }
//-----------------------------------------------------------------------
}
