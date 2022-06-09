package tests.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShoppingPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Random;

public class C01_List {
    @Test
    public void test01() {
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        ShoppingPage shoppingPage = new ShoppingPage();
        Driver.getDriver().get(ConfigReader.getProperty("shoppingUrl"));
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin

        ArrayList<String> urunisimArrayList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            System.out.println((i + 1) + ".ürün: " + (shoppingPage.urunlerIsim.get(i).getText()) + " ürün fiyatı: " + shoppingPage.urunFiyat.get(i).getText());
            urunisimArrayList.add(shoppingPage.urunlerIsim.get(i).getText());
        }

        ArrayList<Double> urunFiyatArrayList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            urunFiyatArrayList.add(Double.parseDouble(shoppingPage.urunFiyat.get(i).getText().replace("$", "")));
        }

        System.out.println(urunFiyatArrayList);

// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
// (Her ürün 1 defadan fazla eklenemez!)

        ArrayList<Integer> randomSayiList = new ArrayList<>(); //önce 5 tane random sayı belirleyelim

        double urunToplamFiyat = 0;


        while (randomSayiList.size() < 5) {
            Random rnd = new Random();

            int sayi = rnd.nextInt(15);

            if (!(randomSayiList.contains(sayi + 1))) {
                randomSayiList.add(sayi + 1);

                System.out.println(shoppingPage.urunlerIsim.get(sayi+1).getText()); //eklediğimiz ürünün ismini yazdırdık

                System.out.println(urunFiyatArrayList.get(sayi+1).doubleValue());
                urunToplamFiyat += (urunFiyatArrayList.get(sayi+1).doubleValue());
            }
        }

        System.out.println(randomSayiList);


        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın

        for (int e : randomSayiList) {

            shoppingPage.Addtocart.get(e).click(); //sepete ekledik


            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }


            shoppingPage.sepetiKapat.click(); //her seçilen ürün sonrası ürün sepeti ekranını kapattık

        }

        System.out.println("eklenen ürünlerin toplam fiyatı: " + urunToplamFiyat);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shoppingPage.sepetimButton.click(); //sepetim ekranını açtık

        double actualToplamFiyat = Double.parseDouble(shoppingPage.subTotal.getText().replace("$", ""));


        // 7.Checkout'a tıklayın
        shoppingPage.Checkout.click();


// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin

        Assert.assertEquals( (int)actualToplamFiyat, (int)urunToplamFiyat, "test pass");

    }
}