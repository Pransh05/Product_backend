package com.productmanagement.ProductManagement.service;

import com.productmanagement.ProductManagement.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Priya
 */
@Service
public class ProductService {

    private final List<Product> productsList = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    public List<Product> getAllProducts() {
        return productsList;
    }

    public Product createProduct(Product product) {
        product.setId(idGenerator.getAndIncrement());

        productsList.add(product);
        return product;
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> productOpt = productsList.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setDescription(updatedProduct.getDescription());
            product.setCategory(updatedProduct.getCategory());
            product.setPrice(updatedProduct.getPrice());
            product.setSpecial(updatedProduct.isSpecial());
            return product;
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public void deleteProduct(Long id) {
        productsList.removeIf(product -> product.getId().equals(id));
    }
}
