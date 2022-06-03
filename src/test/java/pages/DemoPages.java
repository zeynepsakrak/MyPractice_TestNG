package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoPages {
    /*
    http://demo.guru99.com/test/drag_drop.html url e git
    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
    Perfect butonun goruntulendigini dogrulayin
     */

    public DemoPages() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//ol[@id='bank']//li[@class='placeholder']")
    public WebElement  DEBITSIDEAccount;

    @FindBy(xpath = "//a[contains(text(),'BANK')]")
    public WebElement BANK;

    @FindBy(xpath = "//ol[@id='loan']//li[@class='placeholder']")
    public WebElement  CREDITSIDEAccount;

    @FindBy(xpath = "//a[normalize-space()='SALES']")
    public WebElement SALES;

    @FindBy(xpath = "//ol[@id='amt7']//li[@class='placeholder']")
    public WebElement DEBITSIDEAmount;

    @FindBy(xpath = "//section[@id='g-container-main']//li[2]//a[1]")
    public WebElement ilkBesBin;

    @FindBy(xpath = "//ol[@id='amt8']//li[@class='placeholder']")
    public WebElement CREDITSIDEAmount;

    @FindBy(xpath = "//section[@id='g-container-main']//li[4]//a[1]")
    public  WebElement ikinciBesBin;

    @FindBy(xpath = "//a[normalize-space()='Perfect!']")
    public WebElement perfect;

}
