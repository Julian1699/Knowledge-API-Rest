package com.api.rest.Service;

import com.api.rest.Domain.Product;
import com.api.rest.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ProductService {

    /**
     * @Dependency-Injection.
     * @Author Julian1699.
     * @Description Dependency injection of the JPA repository interface.
     * @JpaRepository -> ProductRepository -> ProductService.
     */
    @Autowired
    private final ProductRepository productRepository;

    /**
     * @Method-CREATE.
     * @Author Julian1699.
     * @Description This service is used for save objects of product.
     * @param product
     * @return JpaRepository.save(@Entity);
     */
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    /**
     * @Method-READ.
     * @Author Julian1699.
     * @Description This service is used for get all objects of product.
     * @return JpaRepository.findAll();
     */
    public List <Product> getProducts (){
        return productRepository.findAll();
    }

    /**
     * @Method-UPDATE.
     * @Author Julian1699.
     * @Description This service is used for update objects of product.
     * @param id
     * @param product
     * @return JpaRepository.save(@Entity);
     */
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product producUpdate = optionalProduct.get();
            producUpdate.setName(product.getName());
            producUpdate.setReference(product.getReference());
            producUpdate.setPrice(product.getPrice());
            producUpdate.setWeight(product.getWeight());
            producUpdate.setCategory(product.getCategory());
            producUpdate.setStock(product.getStock());

            return productRepository.save(producUpdate);
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

    /**
     * @Method-DELETE.
     * @Author Julian1699.
     * @Description This service is used for delete objects of product.
     * @return JpaRepository.save(@Entity);
     */
    public void deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productRepository.delete(product);
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

    /**
     * @Method-FIND_BY_ID.
     * @Author Julian1699.
     * @Description This service is used for find objects of product by ID.
     * @param id
     * @return JpaRepository.findById(id);
     */
    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

    /**
     * @Method-FIND_BY_ID.
     * @Author Julian1699.
     * @Description This service is used for find objects of product by String.
     * @param search
     * @return JpaRepository.findAllBySearch(String);
     */
    public Product findAllChars(String search){
        List<Product> searchAll = productRepository.findAllBySearch(search);
        if (searchAll.isEmpty()) {
            throw new EntityNotFoundException("Product not found with: " + search);
        }
        return searchAll.get(0);
    }

}
