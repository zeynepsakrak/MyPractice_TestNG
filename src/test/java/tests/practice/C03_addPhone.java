package tests.practice;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.addPhonePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;

public class C03_addPhone {
    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
*/
    /*
     ~ http://tutorialsninja.com/demo/index.php?route=common/home adresine gidin
     ~ Telefonlar ve PDA'lara tıklayın
     ~ telefonların marka adını alın
     ~ tüm öğeler için ekle düğmesine tıklayın

     ~ siyah toplam eklenen sepet düğmesine tıklayın
     ~ listenin isimlerini sepetten alın
     ~ listeden ve sepet listesinden isimleri karşılaştırın
*/

    @Test
    public void test01() {
        addPhonePage addPhonePage=new addPhonePage();
        Driver.getDriver().get(ConfigReader.getProperty("addPhoneUrl"));

        addPhonePage.PhonePDA.click();
        ArrayList<String> brandNameOfPhones=new ArrayList<>();
        for (WebElement e:addPhonePage.brandNamesOfPhones) {
            brandNameOfPhones.add(e.getText());
        }

        for (WebElement e:addPhonePage.addToCartButtons) {
           e.click();
        }

        addPhonePage.totalAddedCartButton.click();
        ArrayList<String> namesOFlistFromTheCart=new ArrayList<>();
        for (WebElement e:addPhonePage.cartList) {
            namesOFlistFromTheCart.add(e.getText());
        }
        Assert.assertTrue(brandNameOfPhones.containsAll(namesOFlistFromTheCart));

        Driver.closeDriver();
    }
}
