package tests.practice;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuappPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_peynirEkmek {
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
HerokuappPage herokuappPage=new HerokuappPage();
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("herokuappUrl"));
        for (int i = 1; i < 101; i++) {
            herokuappPage.AddElement.click();
        }
        Assert.assertEquals(herokuappPage.DeleteButton.size(),100,"did not click the desired number of AddElement buttons");
        int count=0;
        for (WebElement e: herokuappPage.DeleteButton
             ) {
            e.click();
            count++;
        }
Assert.assertEquals(count,100," buttons was not deleted");
        }


    }

