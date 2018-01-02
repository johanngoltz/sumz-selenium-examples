import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class DataDrivenExamples
{
   private String searchTerm, expectedResult;
   private DHMainPage page;

   public DataDrivenExamples(String searchTerm, String expectedResult)
   {
      this.searchTerm = searchTerm;
      this.expectedResult = expectedResult;
   }

   @Parameters
   public static Collection searchTerms()
   {
      return Arrays.asList(new String[][]{
            {"sumz", "Stochastische Unternehmensbewertung"},
            {"pohl", "SUMZ"},
            {"ratz", "SUMZ"}
      });
   }

   @BeforeClass
   public static void setDriver()
   {
      System.setProperty("webdriver.edge.driver", "C:\\Users\\D064986\\Documents\\DHBW\\seleniumexamples\\lib\\MicrosoftWebDriver.exe");
   }

   @Test
   public void testSearch()
   {
      page.load();

      page.searchGlobally(this.searchTerm);
      assertTrue(page.hasResult(this.expectedResult));
      page.close();
   }

   @Before
   public void newPage()
   {
      page = new DHMainPage();
   }
}
