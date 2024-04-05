import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestingSaucedemo {
    WebDriver _globalDriver;

    @BeforeTest
    public void setUp() {
        _globalDriver = new ChromeDriver();
        _globalDriver.get("https://www.saucedemo.com/");
    }


    @Test
    public void TestBuyingProcess() {

        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");// user
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");// password
        _globalDriver.findElement(By.id("login-button")).click(); //login

        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();//add to cart
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/button")).click();//add to cart
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]")).click();
        _globalDriver.findElement(By.id("checkout")).click();// checkout

        _globalDriver.findElement(By.id("first-name")).sendKeys("vaida");//ckeckout
        _globalDriver.findElement(By.id("last-name")).sendKeys("ziustr");//pavarde
        _globalDriver.findElement(By.id("postal-code")).sendKeys("44172"); //pasto kodas
        _globalDriver.findElement(By.id("continue")).click();//testi pereinant oprie apmokejimo
        _globalDriver.findElement(By.id("finish")).click();//finish

        WebElement itemBaught = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2"));// VIETOJ WebElement galima naudoti var
        Assert.assertEquals(itemBaught.getText(), "Thank you for your order!");
    }

//        var itemBaught = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2")).getText();//
//        Assert.assertEquals(itemBaught,"Thank you for your order!");
//        VIETOJ WebElement galima naudoti var


    @Test
    public void TestPriceEquality() {

        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");// user
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");// password
        _globalDriver.findElement(By.id("login-button")).click(); //login
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();//add to cart
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/button")).click();//add to cart
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]")).click();
        _globalDriver.findElement(By.id("checkout")).click();// checkou
        _globalDriver.findElement(By.id("first-name")).sendKeys("vaida");//ckeckout
        _globalDriver.findElement(By.id("last-name")).sendKeys("ziustr");//pavarde
        _globalDriver.findElement(By.id("postal-code")).sendKeys("44172"); //pasto kodas
        _globalDriver.findElement(By.id("continue")).click();//testi pereinant oprie apmokejimo

        String price1 = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")).getText().replace("$", "");
        String price2 = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/div[2]/div")).getText().replace("$", "");
        double priceInPage = Double.parseDouble(price1) + Double.parseDouble(price2); //suma turiu uzrasyti.konvertuoju i double

        String priceInCart = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[6]")).getText().replace("Item total: $", "");
        Assert.assertEquals(Double.parseDouble(priceInCart), priceInPage);
    }

//        if ( _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")));{
//            System.out.println("daiktas yra");
//        }
//        else () {
//            System.out.println("neideta");
//        }

        @Test

        public void ChangeingItemQuantityInCart () {
            _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");// user
            _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");// password
            _globalDriver.findElement(By.id("login-button")).click(); //login
            _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();//add to cart
            _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/button")).click();//add to cart
            _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]")).click();
            _globalDriver.findElement(By.id("checkout")).click();// checkou
            _globalDriver.findElement(By.id("first-name")).sendKeys("vaida");//ckeckout
            _globalDriver.findElement(By.id("last-name")).sendKeys("ziustr");//pavarde
            _globalDriver.findElement(By.id("postal-code")).sendKeys("44172"); //pasto kodas
            _globalDriver.findElement(By.id("continue")).click();//testi pereinant oprie apmokejimo
            _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[1]")).sendKeys("15");

            String ItemQuantityInCart= _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[1]")).getText();
            Assert.assertEquals(ItemQuantityInCart, "15"); //turi feilint testas nes nekeicia kiekio

    }

    @Test
    public void TestingEmptyCart () {
        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");// user
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");// password
        _globalDriver.findElement(By.id("login-button")).click(); //login
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();// cart
        _globalDriver.findElement(By.id("checkout")).click();// checkou
        _globalDriver.findElement(By.id("first-name")).sendKeys("vaida");//ckeckout
        _globalDriver.findElement(By.id("last-name")).sendKeys("ziustr");//pavarde
        _globalDriver.findElement(By.id("postal-code")).sendKeys("44172"); //pasto kodas
        _globalDriver.findElement(By.id("continue")).click();//testi pereinant oprie apmokejimo
        _globalDriver.findElement(By.id("finish")).click();//finish

        WebElement emptyCart = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2"));// VIETOJ WebElement galima naudoti var
        Assert.assertEquals(emptyCart.getText(), "sorry you have no items"); //kaip kitaip galima patikrinti


    }


    @Test
    public void TestingWrongFirstName () {
        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");// user
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");// password
        _globalDriver.findElement(By.id("login-button")).click(); //login
        _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();// cart
        _globalDriver.findElement(By.id("checkout")).click();// checkou
        _globalDriver.findElement(By.id("first-name")).sendKeys("***");//ckeckout
        _globalDriver.findElement(By.id("last-name")).sendKeys("ziustr");//pavarde
        _globalDriver.findElement(By.id("postal-code")).sendKeys("44172"); //pasto kodas
        _globalDriver.findElement(By.id("continue")).click();//testi pereinant oprie apmokejimo
        _globalDriver.findElement(By.id("finish")).click();//finish

        WebElement falseName = _globalDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2"));//
        Assert.assertEquals(falseName.getText(), "something wrong"); // test failed because it lets to finish having an empty cart


    }














}
