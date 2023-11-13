import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJSocialinsurance {
    private WebDriver driver;

    public void setUp(){
        System.out.println("setUp");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("lang", "zh_CN.UTF-8");
        prefs.put("prompt_for_download", true);
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProject\\selenium\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");
        prefs.put("download.prompt_for_download", true);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }

    public void login() throws InterruptedException {
        driver.get("https://portal.ustraveldocs.com/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        // 输入账号
        WebElement usernameInput = driver.findElement(By.id("loginPage:SiteTemplate:siteLogin:loginComponent:loginForm:username"));
        usernameInput.sendKeys("888889lv@gmail.com");

        // 输入密码
        WebElement passwordInput = driver.findElement(By.id("loginPage:SiteTemplate:siteLogin:loginComponent:loginForm:password"));
        passwordInput.sendKeys("li123123123");

        // 勾选复选框
        WebElement checkbox = driver.findElement(By.name("loginPage:SiteTemplate:siteLogin:loginComponent:loginForm:j_id167"));

        // 检查复选框是否已被选中
        if (!checkbox.isSelected()) {
            // 如果未被选中，则点击选中
            checkbox.click();
        }

        // 登录
        WebElement loginBtn = driver.findElement(By.id("loginPage:SiteTemplate:siteLogin:loginComponent:loginForm:loginButton"));
        loginBtn.click();


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("请先登录,登录完按回车执行后续任务 :)");
//        try {
//            br.readLine();
//        } catch (IOException ex) {
//        }
//        Thread.sleep(2000);
//        driver.switchTo().frame("center");
//        driver.switchTo().frame("leftFrame");
//        Thread.sleep(2000);
//        driver.findElement(By.id("link000")).click();
    }

    private void apply(){

        driver.findElement(By.id("dataNormalAdd.idCard")).click();

        driver.findElement(By.id("dataNormalAdd.idCard")).clear();

        driver.findElement(By.id("dataNormalAdd.idCard")).sendKeys("");

        Select personType = new Select(driver.findElement(By.id("personType")));
        personType.selectByIndex(0);
    }

    public void tearDown(){
        driver.quit();
    }

    @Test
    public void main() throws InterruptedException {
        this.setUp();
        this.login();
//        apply();
//        tearDown();
    }
}
