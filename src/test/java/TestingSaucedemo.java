import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestingSaucedemo {
    WebDriver _globalDriver;

    @BeforeTest
    public void setUp() {
        _globalDriver = new ChromeDriver();
        _globalDriver.get("https://www.saucedemo.com/");
    }



    @Test
    public void Test1(){

        _globalDriver.findElement(By.id("user-name")).sendKeys("standard_user");// user
        _globalDriver.findElement(By.id("password")).sendKeys("secret_sauce");// password
        _globalDriver.findElement(By.id("login-button")).click(); //login

    }















}
