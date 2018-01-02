import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Examples
{
   @BeforeClass
   public static void setDriver()
   {
      System.setProperty("webdriver.edge.driver", "C:\\Users\\D064986\\Documents\\DHBW\\seleniumexamples\\lib\\MicrosoftWebDriver.exe");
   }

   @Test
   public void one() throws Exception
   {
      WebDriver driver = new EdgeDriver();
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

      driver.get("https://karlsruhe.dhbw.de");

      WebElement studentsLinkElement = driver.findElement(By.linkText("Studierende"));
      studentsLinkElement.click();

      WebElement linksForStudents = driver.findElement(By.className("fce-menu"));

      assertEquals("Studierendenvertretung StuV", linksForStudents.findElement(By.cssSelector(":first-child h2")).getText());
      assertEquals(7, linksForStudents.findElements(By.className("menu-item")).size());

      driver.findElement(By.id("show-menu")).click();

      WebElement searchField = driver
            .findElement(By.id("form_kesearch_pi1"))
            .findElement(By.id("ke_search_sword"));
      searchField.sendKeys("sumz");
      searchField.submit();

      assertThat(
            driver.findElement(By.className("result-teaser")).getText(),
            containsString("Stochastische Unternehmensbewertung")
      );

      driver.close();
   }

   @Test
   public void two()
   {
      DHMainPage page = new DHMainPage();

      page.load();

      page.searchGlobally("sumz");

      assertTrue(page.hasResult("Stochastische Unternehmensbewertung"));

      page.close();
   }
}
