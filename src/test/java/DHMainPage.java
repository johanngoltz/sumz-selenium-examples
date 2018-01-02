import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DHMainPage
{
   private final String url = "https://karlsruhe.dhbw.de";
   @FindBy(id = "ke_search_sword")
   public WebElement searchField;
   @FindBy(id = "show-menu")
   public WebElement menuToggle;
   private WebDriver driver = new EdgeDriver();

   @FindBy(className = "result-list-item")
   public List<WebElement> results;

   public DHMainPage()
   {
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      PageFactory.initElements(this.driver, this);
   }

   public void searchGlobally(String searchTerm)
   {
      if (!searchField.isDisplayed())
         menuToggle.click();

      searchField.click();
      searchField.sendKeys(searchTerm);
      searchField.submit();
   }

   public boolean hasResult(String keyword)
   {
      return this.results.stream().anyMatch(element -> element.getText().contains(keyword));
   }

   public void load()
   {
      this.driver.get(url);
   }

   public void close()
   {
      this.driver.close();
   }
}
