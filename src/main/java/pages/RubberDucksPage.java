package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RubberDucksPage extends AbstractPage{

    By duckNameLocator = By.xpath("//a[@title]//div[@class='name']");

    public List<String> getDuckNames() {
        List<WebElement> duckNamesElements =
                driver.findElements(duckNameLocator);

        List<String> duckNames = new ArrayList<String>();
        for(WebElement duckNameElement : duckNamesElements) {
            duckNames.add(duckNameElement.getText());
        }
        return duckNames;
    }


}
