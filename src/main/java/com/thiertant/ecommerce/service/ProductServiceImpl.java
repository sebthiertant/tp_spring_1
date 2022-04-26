package com.thiertant.ecommerce.service;

import com.thiertant.ecommerce.exception.ResourceNotFoundException;
import com.thiertant.ecommerce.exception.StockException;
import com.thiertant.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("products")
public class ProductServiceImpl implements ProductService{
    private final List<Product> allProducts = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return allProducts;
    }

    @Override
    public Product getProductById(Long id) throws ResourceNotFoundException {
        boolean productNotFound = true;

        for (Product allProduct : allProducts) {
            if (Objects.equals(allProduct.getId(), id)) {
                productNotFound = false;
                return allProduct;
            }
        }

        if (Objects.equals(productNotFound, true)) {
            throw new ResourceNotFoundException();
        }
        return allProducts.get(1);
    }

    @Override
    public Product save(Product product) {
        allProducts.add(product);
        return product;
    }

    @Override
    public boolean isProductAvailable(Product product, int quantity) {
        return false;
    }

    @Override
    public void removeProduct(Product product, int quantity) throws StockException {
        boolean productNotFound = true;
        try {
            for (Product allProduct : allProducts) {
                if (Objects.equals(allProduct.getId(), product.getId())) {
                    productNotFound = false;
                    allProduct.setQuantity(allProduct.getQuantity() - quantity);
                }
            }
            throw new StockException("Stock insuffisant");
        }
        catch(StockException e) {
            System.err.println("StockException: " + e.getMessage());
        }

        if (productNotFound) {
            System.out.println("Aucun produit n'a été trouvé.");
        }
    }
}
