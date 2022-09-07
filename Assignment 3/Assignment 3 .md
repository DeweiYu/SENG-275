## Assignment3

**Create an Account** 
``` 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;

public class CreateAccount {
    private WebDriver browser;
    private WebElement email;
    private WebElement create;
    private Random rand = new Random();

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Leo\\Documents\\SENG275_202205\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

       email = browser.findElement(By.id("email_create"));
       create = browser.findElement(By.id("SubmitCreate"));
    }

    @AfterEach
    public void tearDown() {
        browser.close();
    }

    // TC_CA_001
    @Test
    public void createAccountValid() {

        int randInt = rand.nextInt(10000);
        email.sendKeys("Users"+randInt+"@gmail.com");
        WebElement create = browser.findElement(By.id("SubmitCreate"));
        create.click();

        new WebDriverWait(browser, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstName = browser.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Dewei");
        WebElement lastName = browser.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Yu");
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys("passwordtrials");
        WebElement address = browser.findElement(By.id("address1"));
        address.sendKeys("123 shelbourne st.");
        WebElement city = browser.findElement(By.id("city"));
        city.sendKeys("Victoria");
        Select state = new Select(browser.findElement(By.id("id_state")));
        state.selectByIndex(1);
        WebElement postcode = browser.findElement(By.id("postcode"));
        postcode.sendKeys("11111");
        WebElement mobilePhone = browser.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("123-456-7789");
        WebElement submit = browser.findElement(By.id("submitAccount"));
        submit.click();
    }

    // TC_CA_002
    @Test
    public void invalidPassword(){

        int randInt = rand.nextInt(10000);
        email.sendKeys("Users"+randInt+"@gmail.com");
        WebElement create = browser.findElement(By.id("SubmitCreate"));
        create.click();

        create.click();
        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstName = browser.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Dewei");
        WebElement lastName = browser.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Yu");
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys("fail");
        WebElement address = browser.findElement(By.id("address1"));
        address.sendKeys("123 shelbourne st.");
        WebElement city = browser.findElement(By.id("city"));
        city.sendKeys("Victoria");
        Select state = new Select(browser.findElement(By.id("id_state")));
        state.selectByIndex(1);
        WebElement postcode = browser.findElement(By.id("postcode"));
        postcode.sendKeys("11111");
        WebElement mobilePhone = browser.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("123-456-7789");
        WebElement submit = browser.findElement(By.id("submitAccount"));
        submit.click();

        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("/html/body/div/div[2]/div/div[3]/div/div"))
                );
        assertTrue(browser.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div/div")).size() > 0);
    }

    // TC_CA_003
    @Test
    public void wrongPostalCode(){
        int randInt = rand.nextInt(10000);
        email.sendKeys("Users"+randInt+"@gmail.com");
        WebElement create = browser.findElement(By.id("SubmitCreate"));
        create.click();

        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));

        WebElement firstName = browser.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Dewei");
        WebElement lastName = browser.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Yu");
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys("passwordtrials");
        WebElement address = browser.findElement(By.id("address1"));
        address.sendKeys("123 shelbourne st.");
        WebElement city = browser.findElement(By.id("city"));
        city.sendKeys("Victoria");
        Select state = new Select(browser.findElement(By.id("id_state")));
        state.selectByIndex(1);
        WebElement postcode = browser.findElement(By.id("postcode"));
        postcode.sendKeys("111111");
        WebElement mobilePhone = browser.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("123-456-7789");
        WebElement submit = browser.findElement(By.id("submitAccount"));
        submit.click();

        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("/html/body/div/div[2]/div/div[3]/div/div")));
        assertTrue(browser.findElements(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div")).size() > 0);
    }

    // TC_CA_004
    @Test
    public void emailExists(){
        String email = "leoyu@uvic.ca";
        WebElement create = browser.findElement(By.id("email_create"));
        create.sendKeys(email);

        WebElement createAcc = browser.findElement(By.id("SubmitCreate"));
        createAcc.click();

        new WebDriverWait(browser, 5)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]"))
                );
        assertTrue(browser.findElements(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]")).size() > 0);
    }
}
```
![image](https://media.discordapp.net/attachments/360322626612101132/1005624044982386738/screenshot_1.PNG?width=878&height=367)

TC_CA_001  
![image](https://media.discordapp.net/attachments/360322626612101132/1005624630406549575/valid_account.PNG?width=878&height=562)    
TC_CA_002  
![image](https://media.discordapp.net/attachments/360322626612101132/1005624496360788058/invalid_password.PNG?width=878&height=407)   
TC_CA_003  
![image](https://media.discordapp.net/attachments/360322626612101132/1005624510197792768/invalid_ptcode.PNG?width=878&height=514)    
TC_CA_004  
![image](https://media.discordapp.net/attachments/360322626612101132/1005625958159622194/emailExists.PNG?width=782&height=405)    



**Log in functionalities**
```
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class LoginFunctionality {

        private WebDriver browser;
        private WebDriver email;


        @BeforeEach
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Leo\\Documents\\SENG275_202205\\chromedriver.exe");
            browser = new ChromeDriver();

            browser.manage().window().maximize();
            
        }

        @AfterEach
        public void cleanUp() {
            browser.quit();
        }
    // TC-01
    @Test
    public void ValidCredentials(){
        String emailInput = "yyfsd@gmail.com";
        String passwordInput = "passwordtrials";
        
        browser.get("http://automationpractice.com/index.php?controller=authentication");
        WebElement email = browser.findElement(By.xpath("email"));
        email.sendKeys("yyfsd@gmail.com");
        WebElement password = browser.findElement(By.xpath("passwd"));
        password.sendKeys("passwordtrials");
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));

        assertEquals("My account - My Store", browser.getTitle());
    }

    // TC-02
    @Test
    public void InvalidCredentials(){
        String emailInput = "invalyyfsd@gmail.com";
        String passwordInput = "invalpasswordtrial";
        browser.get("http://automationpractice.com/index.php?controller=authentication");
        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    // TC-03
    @Test
    public void ValidEmailInvalidPassword(){
        String emailInput = "yyfsd@gmail.com";
        String passwordInput = "invalpasswordtrials";
        browser.get("http://automationpractice.com/index.php?controller=authentication");
        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    // TC-04
    @Test
    public void InvalidEmailValidPassword(){
        String emailInput = "yyf@gmail.com";
        String passwordInput = "invalpasswordtrials";
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    // TC-05
    @Test
    public void NoCredentials(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");
        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();

        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    // TC-06
    @Test
    public void MultipleUnsuccessfulAttempts(){
        String emailInput = "yyfsd@gmail.com";
        String passwordInput = "invalpasswordtrials";
        for (int i = 0; i < 15; i++) {
            if (i != 0) {
                browser.get("http://automationpractice.com/index.php?controller=authentication");
            }
            WebElement email = browser.findElement(By.id("email"));
            email.sendKeys(emailInput);
            WebElement password = browser.findElement(By.id("passwd"));
            password.sendKeys(passwordInput);
            WebElement signIn = browser.findElement(By.id("SubmitLogin"));
            signIn.click();
        }
        assertTrue(browser.getPageSource().contains("There is 1 error"));
    }

    // TC-07
    @Test
    public void BrowsingDetails(){
        String emailInput = "yyfsd@gmail.com";
        String passwordInput = "passwordtrials";
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();

        boolean login = browser.getPageSource().contains("Dewei Yu");
        WebElement home = browser.findElement(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li/a/span")
        );
        home.click();

        assertEquals(login, browser.getPageSource().contains("Dewei Yu"));
    }

    // TC-09
    @Test
    public void signOutCheck(){
        String emailInput = "yyfsd@gmail.com";
        String passwordInput = "passwordtrials";
        browser.get("http://automationpractice.com/index.php?controller=authentication");
        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();
        boolean login = browser.getPageSource().contains("Dewei Yu");
        WebElement signOut = browser.findElement(
                By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")
        );
        signOut.click();
        boolean logout = browser.getPageSource().contains("Dewei Yu");
        // reopen browser
        browser.navigate().refresh();

        assertFalse(logout); assertTrue(login);
    }

    // TC-010
    @Test
    public void passwordHidden(){
        String emailInput = "yyfsd@gmail.com";
        String passwordInput = "passwordtrials";
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);

        assertTrue(browser.findElements(By.id("passwd")).size() > 0);
    }
    //TC-011
    @Test
    public void resetLinkExists(){
        browser.get("http://automationpractice.com/index.php?controller=authentication");
        browser.findElement(By.partialLinkText("Forgot your password")).click();
        assertTrue(browser.findElements(By.xpath("//form[@id='form_forgotpassword']/fieldset/p/button/span")).size() > 0);
    }
    //TC-012
    @Test
    public void sigOutworks(){
        String emailInput = "yyfsd@gmail.com";
        String passwordInput = "passwordtrials";
        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement email = browser.findElement(By.id("email"));
        email.sendKeys(emailInput);
        WebElement password = browser.findElement(By.id("passwd"));
        password.sendKeys(passwordInput);
        WebElement signIn = browser.findElement(By.id("SubmitLogin"));
        signIn.click();

        assertEquals("My account - My Store", browser.getTitle());

        browser.findElement(By.partialLinkText("Sign out")).click();
        assertTrue(browser.findElements(By.xpath("//form[@id='login_form']/h3")).size() > 0);
        }
   

}

```
![image](https://media.discordapp.net/attachments/360322626612101132/1005626711326597130/2.PNG)

TC_LF_001    
![image](https://media.discordapp.net/attachments/360322626612101132/1005627750943563836/Valid_cre.PNG?width=705&height=301)    
TC_LF_002  
![image](https://media.discordapp.net/attachments/360322626612101132/1005627506646319104/tc-02.PNG?width=705&height=351)  
TC_LF_003  
![image](https://media.discordapp.net/attachments/360322626612101132/1005627587239878676/tc-03.PNG?width=705&height=346)  
TC_LF_004  
![image](https://media.discordapp.net/attachments/360322626612101132/1005628257804234822/tc-04.PNG?width=705&height=352)  
TC_LF_005   
![image](https://media.discordapp.net/attachments/360322626612101132/1005628376758894592/tc-05.PNG?width=705&height=349)  
TC_LF_006  
![image](https://media.discordapp.net/attachments/360322626612101132/1005628605436538950/tc-06-01.PNG?width=705&height=348)  
TC_LF_007  
![image](https://media.discordapp.net/attachments/360322626612101132/1005628705835585597/tc-07.PNG?width=705&height=153)  
TC_LF_009  
![image](https://media.discordapp.net/attachments/360322626612101132/1005629318916997232/tc-08.PNG?width=705&height=108)  
TC_LF_010    
![image](https://media.discordapp.net/attachments/360322626612101132/1005629420377210970/tc-010.PNG?width=705&height=321)  
TC_LF_011  
![image](https://media.discordapp.net/attachments/360322626612101132/1005629532637757440/tc-011.PNG?width=705&height=268)  
TC_LF_012   
![image](https://media.discordapp.net/attachments/360322626612101132/1005629609628410007/tc-012.PNG?width=705&height=139)    
TC_LF_013  
![image](https://media.discordapp.net/attachments/360322626612101132/1005629609628410007/tc-012.PNG?width=705&height=139)   

**AddEditRemoveFromcart**
```
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AddEditRemoveFromCart {
    WebDriver browser;

    @BeforeEach

    public void setUp() {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Leo\\Documents\\SENG275_202205\\chromedriver.exe");
        browser = new ChromeDriver();

        browser.manage().window().maximize();


        browser.get("http://automationpractice.com/index.php?controller=authentication");

        WebElement email = browser.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys("yyfsd@gmail.com");

        WebElement password = browser.findElement(By.xpath("//*[@id=\"passwd\"]"));
        password.sendKeys("passwordtrials");

    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }

    //TC_ARC_002 
    @Test
    public void AddFromHome() throws InterruptedException {
        WebElement homeIcon = browser.findElement(By.cssSelector("#columns > div.breadcrumb.clearfix > a > i"));
        homeIcon.click();
        Actions act = new Actions(browser);

        WebElement ItemToAdd = browser.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img"));
        act.moveToElement(ItemToAdd).perform();
        Thread.sleep(2000);

        WebElement AddToCart = browser.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]/span"));
        AddToCart.click();
        Thread.sleep(2000);
        
        WebElement close = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
        Thread.sleep(2000);
        close.click();

        WebElement Cart = browser.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
        Cart.click();
        Thread.sleep(3000);

        WebElement Item = browser.findElement(By.xpath("//*[@id=\"product_2_7_0_723442\"]/td[2]/p/a"));
        assertEquals("Blouse", Item.getText());

    }

    //TC_ARC_003 
    @Test
    public void AddFromWomenPage() throws InterruptedException {
        WebElement homeIcon = browser.findElement(By.cssSelector("#columns > div.breadcrumb.clearfix > a > i"));
        homeIcon.click();

        WebElement women = browser.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
        women.click();
        Actions act = new Actions(browser);

        WebElement ItemToAdd = browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5/a"));
        act.moveToElement(ItemToAdd).perform();
        new WebDriverWait(browser, 5);

        WebElement AddToCart = browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span"));
        AddToCart.click();

        WebElement close = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
        Thread.sleep(3000);
        close.click();

        WebElement Cart = browser.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b"));
        Cart.click();

        WebElement Item = browser.findElement(By.xpath("//*[@id=\"product_2_7_0_723442\"]/td[2]/p/a"));
        assertEquals("Blouse", Item.getText());

    }

    //TC_ARC_004
    @Test
    public void AddFromDresses() throws InterruptedException {
        WebElement homeIcon = browser.findElement(By.cssSelector("#columns > div.breadcrumb.clearfix > a > i"));
        homeIcon.click();

        WebElement dresses = browser.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        dresses.click();
        Actions act = new Actions(browser);

        WebElement ItemToAdd = browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[3]/ul"));
        act.moveToElement(ItemToAdd).perform();
        new WebDriverWait(browser, 5);

        WebElement AddToCart = browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div[2]/div[2]/a[1]/span"));
        AddToCart.click();

        WebElement close = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
        Thread.sleep(3000);
        close.click();

        WebElement Cart = browser.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b"));
        Cart.click();
        Thread.sleep(3000);

        WebElement Item = browser.findElement(By.xpath("//*[@id="product_7_34_0_723442"]/td[2]/p/a));
        assertEquals("Printed Chiffon Dress", Item.getText());

    }

    //TC_ARC_005
    @Test
    public void AddFromTShirt() throws InterruptedException {
        WebElement homeIcon = browser.findElement(By.cssSelector("#columns > div.breadcrumb.clearfix > a > i"));
        homeIcon.click();

        WebElement T-shirt = browser.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a"));
        T-shirt.click();
        Actions action = new Actions(browser);

        WebElement ItemToAdd = browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
        action.moveToElement(ItemToAdd).perform();
        new WebDriverWait(browser, 5);

        WebElement AddToCart = browser.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span"));
        AddToCart.click();

        WebElement close = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
        Thread.sleep(3000);
        close.click();

        WebElement Cart = browser.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b"));
        Cart.click();

        WebElement Item = browser.findElement(By.xpath("//*[@id=\"product_1_1_0_723442"]/td[2]/p/a"));
        assertEquals("Faded Short Sleeve T-shirts", Item.getText());
    }
    
    //TC_ARC_006
    @Test
    public void FromWishlist(){
        WebElement homeIcon = browser.findElement(By.cssSelector("#columns > div.breadcrumb.clearfix > a > i"));
        homeIcon.click();

        WebElement ItemToAdd = browser.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a"));
        ItemToAdd.click();

        WebElement AddtoWishList = browser.findElement(By.xpath("//*[@id=\"wishlist_button\"]"));
        AddtoWishList.click();

        WebElement account = browser.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
        account.click();

        WebElement Wishlist = browser.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span"));
        Wishlist.click();

        WebElement List = browser.findElement(By.xpath("//*[@id=\"wishlist_51208\"]/td[1]/a"));
        List.click();
        new WebDriverWait(browser, 5);

        //assertThrows(browser.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).isDisplayed());
        try {
            WebElement AddtoCart = browser.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
        } catch (Exception e){
            String exception = e.getMessage();
            assertNotEquals(0, exception.length());
        }

        WebElement item = browser.findElement(By.cssSelector(""));
        item.click();
        
        WebElement AddtoCart = browser.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
        AddtoCart.click();
       
        WebElement Cart = browser.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b"));
        Cart.click();
        
        WebElement Item = browser.findElement(By.xpath("//*[@id=\"product_1_1_0_723442"]/td[2]/p/a"));
        assertEquals("Faded Short Sleeve T-shirts", Item.getText());*/

    }

    //TC_ARC_007
    @Test
    public void RemoveFromCart() throws InterruptedException {
        WebElement homeIcon = browser.findElement(By.cssSelector("#columns > div.breadcrumb.clearfix > a > i"));
        homeIcon.click();
        Actions action = new Actions(browser);

        WebElement ItemToAdd = browser.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
        action.moveToElement(ItemToAdd).perform();
        new WebDriverWait(browser, 5);

        WebElement AddToCart = browser.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span"));
        AddToCart.click();

        WebElement close = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
        Thread.sleep(2000);
        close.click();

        WebElement Cart = browser.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b"));
        Thread.sleep(2000);
        Cart.click();
        Thread.sleep(3000);

        WebElement delete = browser.findElement(By.cssSelector("#\\31 _1_0_723442 > i"));
        delete.click();
        Thread.sleep(2000);

        WebElement warning = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p"));
        //System.out.println(warning.getText());
        assertEquals("Your shopping cart is empty.",warning.getText());
    }

    //TC_ARC_008
    @Test
    public void IncreaseQuantity() throws InterruptedException {
        WebElement homeIcon = browser.findElement(By.cssSelector("#columns > div.breadcrumb.clearfix > a > i"));
        homeIcon.click();

        WebElement ItemToAdd = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul/li[2]/div/div[2]/h5/a"));
        ItemToAdd.click();

        WebElement IncreaseButton = browser.findElement(By.xpath("//html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/div/a[2]/span/i"));
        IncreaseButton.click();

        WebElement AddToCart = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/div[2]/a[1]/span"));
        AddToCart.click();

        WebElement close = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
        Thread.sleep(3000);
        close.click();

        WebElement Cart = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a"));
        Cart.click();

        WebElement quantity = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/input[2]"));
        assertEquals("2 Products", quantity.getText());
    }

    //TC_ARC_009
    @Test
    public void EditSize() throws InterruptedException {
        WebElement logout = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
        homeIcon.click();

        WebElement ItemToAdd = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul/li[2]/div/div[2]/h5/a"));
        ItemToAdd.click();
        new WebDriverWait(browser, 5);

        WebElement dropdown = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/div/fieldset[1]/div/div/select"));
        Select dropdown1 = new Select(dropdown);
        dropdown1.selectByVisibleText("L");

        WebElement AddToCart = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/div[2]/a[1]/span"));
        AddToCart.click();

        WebElement close = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
        Thread.sleep(3000);
        close.click();

        WebElement Cart = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a"));
        Cart.click();

        WebElement Size = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/small[2]/a"));
        assertEquals("Color : black, Size : L", Size.getText());

    }
    //TC_ARC_010
    @Test
    public void LogOUTAndInCart() throws InterruptedException {
        WebElement homeIcon = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/a/i"));
        homeIcon.click();

        WebElement ItemToAdd = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul/li[2]/div/div[2]/h5/a"));
        ItemToAdd.click();

        WebElement AddToCart = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button"));
        AddToCart.click();
        Thread.sleep(5000);

        WebElement close = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
        close.click();

        WebElement Cart = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/b"));
        Thread.sleep(2000);
        Cart.click();
        Thread.sleep(3000);

       
        WebElement tops = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a"));
        assertEquals("Blouse", tops.getText());

        
        WebElement signgout = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
        signout.click();
        Thread.sleep(5000);

        
        WebElement Signin = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a"));
        Signin.click();
        Thread.sleep(3000);

        WebElement email = browser.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys("yyfsd@gmail.com");

        WebElement password = browser.findElement(By.xpath("//*[@id=\"passwd\"]"));
        password.sendKeys("passwordtrials\n");
        Thread.sleep(4000);

        WebElement Cart1 = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/b"));
        Thread.sleep(3000);
        Cart1.click();
        Thread.sleep(3000);

        WebElement alert = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p"));
        Thread.sleep(3000);
        assertEquals("Your shopping cart is empty.", alert.getText());
        

    }
    //TC_ARC_011
    @Test
    public void LogOutCart() throws InterruptedException {
        WebElement signout = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
        signout.click();

        WebElement homeIcon = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/a/i"));
        homeIcon.click();

        WebElement ItemToAdd = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/h5/a"));
        ItemToAdd.click();
        

        WebElement AddToCart = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button"));
        AddToCart.click();
       
        WebElement Messages = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/div/div/div/dl/dt/div/div[1]/a"));
        Thread.sleep(4000);
        assertEquals("There is 1 item in your cart.", Messages.getText());

        WebElement Item = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/div[2]/span[1]"));
        Thread.sleep(3000);
        assertEquals("Blouse", Item.getText());

        WebElement close = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
        close.click();

        WebElement Cart = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/b"));
        Thread.sleep(3000);
        Cart.click();
        Thread.sleep(3000);

        WebElement topps = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a"));
        assertEquals("Blouse", topps.getText());

    }
    //TC_ARC_012
    @Test
    public void LogOutRemoveCart() throws InterruptedException {
        WebElement logout = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
        logout.click();

        WebElement homeIcon = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/a/i"));
        homeIcon.click();

        WebElement ItemToAdd = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/h5/a"));
        ItemToAdd.click();
       

        WebElement AddToCart = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button"));
        AddToCart.click();

        WebElement close = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span"));
        Thread.sleep(3000);
        close.click();

        WebElement Cart = browser.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/b"));
        Thread.sleep(2000);
        Cart.click();
        Thread.sleep(4000);

        WebElement delete = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a/i"));
        Thread.sleep(3000);
        delete.click();
        Thread.sleep(3000);

        WebElement alert = browser.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p"));
        Thread.sleep(3000);
        assertEquals("Your shopping cart is empty.", alert.getText());
    }
}

```
![image](https://media.discordapp.net/attachments/360322626612101132/1005634568851824811/screenshot_3.PNG)  
TC_ARC_002  
![image](https://media.discordapp.net/attachments/360322626612101132/1005804139290316820/TC-001.PNG?width=1024&height=568)  
TC_ARC_003  
![image](https://media.discordapp.net/attachments/360322626612101132/1005804139290316820/TC-001.PNG?width=1024&height=568)  
TC_ARC_004  
![image](https://media.discordapp.net/attachments/360322626612101132/1005805392225378406/Tc-004.PNG?width=938&height=494)  
TC_ARC_005  
![image](https://media.discordapp.net/attachments/360322626612101132/1005806357129211985/005.PNG?width=938&height=525)  
TC_ARC_006  
![image](https://media.discordapp.net/attachments/360322626612101132/1005806357129211985/005.PNG?width=938&height=525)  
TC_ARC_007  
![image](https://media.discordapp.net/attachments/360322626612101132/1005806885267587162/00000000.PNG?width=938&height=328)  
TC_ARC_008  
![image](https://media.discordapp.net/attachments/360322626612101132/1005803522291404820/2004.PNG?width=1348&height=676)  
TC_ARC_009  
![image](https://media.discordapp.net/attachments/360322626612101132/1005808142476660786/009.PNG?width=938&height=520)  
TC_ARC_010  
![image](https://media.discordapp.net/attachments/360322626612101132/1005803522291404820/2004.PNG?width=1348&height=676)  
TC_ARC_011  
![image](https://media.discordapp.net/attachments/360322626612101132/1005810460030930964/11.PNG?width=920&height=567)   
TC_ARC_012  
![image](https://media.discordapp.net/attachments/360322626612101132/1005810672724082719/warning.PNG?width=938&height=379)   
