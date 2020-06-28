package org.sid.lightecom;

import net.bytebuddy.utility.RandomString;
import org.sid.lightecom.dao.CategoryRepository;
import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class LightEcomApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(LightEcomApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        categoryRepository.save(new Category(null, "Ordinateurs", null, null));
        categoryRepository.save(new Category(null, "Imprimante", null, null));
        categoryRepository.save(new Category(null, "Smartphone", null, null));

        Random rnd= new Random();
        categoryRepository.findAll().forEach(c-> {
            for (int i = 0; i < 10; i++) {
                Product p = new Product();
                p.setNom(RandomString.make(18));
                p.setCurrentPrice(100 + rnd.nextInt(100000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                productRepository.save(p);
            }

        });
    }

}
