package com.api.rest.Repository;

import com.api.rest.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    /**
     * @Author Julian1699.
     * @Description This method is used for find objects of product by String.
     * @param search
     * @return JpaRepository.findAllBySearch(String);
     * @JpaRepository -> ProductRepository.
     */
    @Query(value = "SELECT * FROM product WHERE " +
            "CONCAT(name, reference, category) LIKE %:search%", nativeQuery = true)
    List<Product> findAllBySearch(@Param("search") String search);
}
