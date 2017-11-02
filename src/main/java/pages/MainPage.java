package pages;

import org.openqa.selenium.By;

public class MainPage extends AbstractPage{

    final String MAIN_PAGE_URL = "http://localhost/litecart";
    By rubberDuckButtonLocator = By.xpath("//nav[@id='site-menu']//li[@class='category-1']");

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);

        return this;
    }
    public RubberDucksPage openRubberDucksPage() {
        driver.findElement(rubberDuckButtonLocator).click();

        return new RubberDucksPage();
    }

}
