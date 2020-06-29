package org.sid.lightecom.web;

import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.entities.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class CatalogueRestController {
    private ProductRepository productRepository;

    // au lieu du contructeur on peut utiliser aussi @Autowired
    public CatalogueRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path="/photoProduct/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Product p = productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));
        /*File serverFile = new File(System.getProperty("user.home")+"/ecom/products/unknown.png");
        System.out.println("serverFile : " + serverFile);
        return Files.readAllBytes(serverFile.toPath());*/
    }
}
