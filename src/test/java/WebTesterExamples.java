import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.WebDriverBrowser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.edge.EdgeDriver;

public class WebTesterExamples
{
   private Browser browser;

   @BeforeClass
   public static void setDriver()
   {
      System.setProperty("webdriver.edge.driver", "C:\\Users\\D064986\\Documents\\DHBW\\seleniumexamples\\lib\\MicrosoftWebDriver.exe");
   }

   @Before
   public void setup()
   {
      browser = WebDriverBrowser.forWebDriver(new EdgeDriver()).build();
   }

   @Test
   public void one()
   {
   }
}

