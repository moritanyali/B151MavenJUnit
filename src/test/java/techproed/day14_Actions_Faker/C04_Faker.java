package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C04_Faker {
    @Test
    public void test01() {
          /*
        Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir
         */
        Faker faker = new Faker();

        //faker objesini kullanarak bir isim yazdıralım
        System.out.println(faker.name().firstName());

        //faker objesini kullanarak bir lastName yazdıralım
        System.out.println(faker.name().lastName());
        //faker objesini kullanarak bir fullName yazdıralım
        System.out.println(faker.name().fullName());
        //faker objesini kullanarak bir address yazdıralım
        System.out.println(faker.address().fullAddress());
        //faker objesini kullanarak bir tel_no yazdıralım
        System.out.println(faker.phoneNumber().cellPhone());

        //Rastgele 15 haneli bir numara yazdıralım
        System.out.println(faker.number().digits(15));

        System.out.println(faker.shakespeare().hamletQuote());
        System.out.println(faker.backToTheFuture().character());
        System.out.println(faker.beer().name());
        System.out.println(faker.elderScrolls().city());
    }
}
