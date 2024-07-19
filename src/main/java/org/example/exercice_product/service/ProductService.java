package org.example.exercice_product.service;

import org.example.exercice_product.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {
    private final Map<UUID, Product> products;

    public ProductService() {
        products = new HashMap<>();

        Product product1 = Product.builder()
                .id(UUID.randomUUID())
                .name("Sandwich")
                .category("Food")
                .price(10)
                .build();

        Product product2 = Product.builder()
                .id(UUID.randomUUID())
                .name("Phone")
                .category("Electronics")
                .price(200)
                .build();

        Product product3 = Product.builder()
                .id(UUID.randomUUID())
                .name("Puzzle")
                .category("Game")
                .price(20)
                .build();

        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
    }

    public List<Product> getAllProducts() { return products.values().stream().toList();}
    public Product getProductById(UUID id) { return products.get(id);}
    public List<Product> getProductByPrice(double maxPrice, String category) {
        return products.values().stream().filter(product -> product.getPrice() <= maxPrice && product.getCategory().equals(category)).toList();
    }
}
