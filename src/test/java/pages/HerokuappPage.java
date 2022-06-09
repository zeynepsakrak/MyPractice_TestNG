package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HerokuappPage {
    public HerokuappPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@onclick='addElement()']")
    public WebElement AddElement;

    @FindBy(xpath = "//button[@onclick='deleteElement()']")
    public List<WebElement> DeleteButton;
}
