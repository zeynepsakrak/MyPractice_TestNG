package tests.practice;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GittiGidiyorPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Random;

public class C05_GittiGidiyor{


    private static final Logger logger = LogManager.getLogger(C05_GittiGidiyor.class);
    @Test
    public void test01() throws InterruptedException {
        GittiGidiyorPage gittiGidiyorPage=new GittiGidiyorPage();
        //- www.gittigidiyor.com sitesi açılır.
       //- Arama kutucuğuna bilgisayar kelimesi girilir.
        Driver.getDriver().get(ConfigReader.getProperty("GittiGidiyorUrl"));
       gittiGidiyorPage.aramaKutusu.sendKeys("bilgisayar"+Keys.ENTER);
        //- Arama sonuçları sayfasından 2.sayfa açılır.
        //- 2.sayfanın açıldığı kontrol edilir.
        String ilkSayfaWHD= Driver.getDriver().getWindowHandle();
        String ilkSayfaURL= Driver.getDriver().getCurrentUrl();
       Driver.getDriver().switchTo().newWindow(WindowType.TAB).get(ilkSayfaURL);
        String ikinciSayfaWHD= Driver.getDriver().getWindowHandle();
        Assert.assertNotEquals(ilkSayfaWHD,ikinciSayfaWHD);

        //- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
       gittiGidiyorPage.cookies.click();
        Random rnd = new Random();
        int sayi = rnd.nextInt(gittiGidiyorPage.urunlerList.size());
        gittiGidiyorPage.urunlerList.get(sayi+1).getText();

        //- Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
       logger.info( gittiGidiyorPage.urunlerList.get(sayi+1).getText());

        //- Seçilen ürün sepete eklenir.

   gittiGidiyorPage.urunlerList.get(sayi+1).click();
      gittiGidiyorPage.sepeteEkle.click();

            Thread.sleep(1000);

        //- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        String urunFiyati=gittiGidiyorPage.urunfiyat.getText();
        System.out.println("urunFiyati = " + urunFiyati);
        //gittiGidiyorPage.sepetim.click();
        gittiGidiyorPage.sepetegit.click();
        String sepettekiFiyati=gittiGidiyorPage.sepettekiFiyat.getText();
        Assert.assertEquals(urunFiyati,sepettekiFiyati);
        //- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        gittiGidiyorPage.urunadedi.click();
        Assert.assertTrue(gittiGidiyorPage.urunadedi.getText().contains("2"));
        //- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
    gittiGidiyorPage.urundelete.click();
    Thread.sleep(1000);
    Assert.assertTrue(gittiGidiyorPage.bosSepet.isDisplayed());

    }
}
