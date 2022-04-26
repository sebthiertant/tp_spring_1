package com.thiertant.ecommerce.service;

import com.thiertant.ecommerce.exception.StockException;
import com.thiertant.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product save(Product product);
    public boolean isProductAvailable(Product product, int quantity);
    public void removeProduct(Product product, int quantity) throws StockException;
}
