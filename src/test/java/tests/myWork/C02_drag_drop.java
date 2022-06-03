package tests.myWork;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoPages;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class C02_drag_drop {
    /*
     http://demo.guru99.com/test/drag_drop.html url e git
      */
    @Test
    public void test01(){
        DemoPages demoPages=new DemoPages();
        Driver.getDriver().get(ConfigReader.getProperty("demoUrl"));
        Actions actions=new Actions(Driver.getDriver());

        //  WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
//DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        actions.dragAndDrop(demoPages.BANK, demoPages.DEBITSIDEAccount).
                // wait.until(ExpectedConditions.visibilityOf(demoPages.SALES));
//CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        dragAndDrop(demoPages.SALES, demoPages.CREDITSIDEAccount).

                // wait.until(ExpectedConditions.visibilityOf(demoPages.ikinciBesBin));

                //DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
                        dragAndDrop(demoPages.ilkBesBin, demoPages.DEBITSIDEAmount).

                // wait.until(ExpectedConditions.visibilityOf(demoPages.ikinciBesBin));
                //CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
                        dragAndDrop(demoPages.ikinciBesBin, demoPages.CREDITSIDEAmount).perform();

        //  wait.until(ExpectedConditions.visibilityOf(demoPages.perfect));
        //Perfect butonun goruntulendigini dogrulayin

        Assert.assertTrue(demoPages.perfect.isDisplayed());
        Driver.closeDriver();

    }
}
