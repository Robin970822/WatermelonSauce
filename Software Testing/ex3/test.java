import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import static org.openqa.selenium.OutputType.*;

public class hanxy {
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
    	System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe"); 
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void hanxy() {
        wd.get("https://www.jd.com/");
        wd.findElement(By.id("key")).click();
        wd.findElement(By.id("key")).clear();
        wd.findElement(By.id("key")).sendKeys("电脑");
        wd.findElement(By.cssSelector("button.button")).click();
        try {
 			Thread.sleep(4000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        wd.findElement(By.id("key")).click();
        wd.findElement(By.linkText("京东")).click();
        try {
 			Thread.sleep(4000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        wd.findElement(By.linkText("你好，请登录")).click();
        wd.findElement(By.cssSelector("div.login-tab.login-tab-l")).click();
        try {
 			Thread.sleep(4000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        wd.navigate().back();
        wd.findElement(By.linkText("北京")).click();
        wd.findElement(By.linkText("陕西")).click();
        try {
 			Thread.sleep(4000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        wd.findElement(By.linkText("手机")).click();
        try {
 			Thread.sleep(4000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
