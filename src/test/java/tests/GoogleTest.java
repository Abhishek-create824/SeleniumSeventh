package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import main.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.GooglePageObject;

import java.io.File;
import java.io.IOException;

public class GoogleTest extends Base {

    public static Logger log= LogManager.getLogger(GoogleTest.class.getName());

    ExtentReports extent;

    ExtentTest logger;

    @BeforeTest
    public void startReport() throws IOException {
     driver=capabilities();
     log.info("capabilities of driver");
     extent=new ExtentReports(System.getProperty("user.dir")+"//reports/google.html",true);
        log.info("report location");
     extent.addSystemInfo("tester","abhishek");
        log.info("environment variables");
     extent.loadConfig(new File(System.getProperty("user.dir")+"//extent-config.xml"));
        log.info("report structure");
    }

    @Test
    public void test1()
    {
        logger=extent.startTest("pass test");
        log.info("test is passed");
driver.get(props.getProperty("url"));
        log.info("navigating to url");
GooglePageObject gpo=new GooglePageObject(driver);
        log.info("object creation");
gpo.getSearchItem().sendKeys("latest songs 2023");
        log.info("item is displayed");
gpo.getSearch().sendKeys(Keys.ENTER);
        log.info("key is entered");
    }

    @Test
//    public void test2()
//    {
//logger=extent.startTest("fail test");
//        log.info("test is failed");
//String title=driver.getTitle();
//        log.info("title is");
//String url=driver.getCurrentUrl();
//        log.info("url is");
//Assert.assertEquals(title,"no title");
//        log.info("compare string");
//Assert.assertEquals(url,"no url");
//        log.info("compare string");
//    }

//    @Test
//    public void test3()
//    {
//logger=extent.startTest("skip test");
//        log.info("test skip");
//throw new SkipException("test is skipped");
//    }

    @AfterTest
    public void endReport()
    {
extent.flush();
extent.close();
        log.info("closing report");
driver.close();
        log.info("closing current window");
driver.quit();
        log.info("closing all window");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
    if(result.getStatus()==result.FAILURE)
    {
        logger.log(LogStatus.FAIL,"test is failed"+result.getName());
        logger.log(LogStatus.FAIL,"test is failed"+result.getThrowable());
        String screen=Base.getScreenshot(driver,result.getName());
        logger.log(LogStatus.FAIL,logger.addScreencast(screen));
    }
        logger.log(LogStatus.SKIP,"test is skipped"+result.getName());
    }
}
