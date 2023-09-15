package com.api.rest.controller;

import com.api.rest.domain.Product;
import com.api.rest.service.ProductService;
import com.api.rest.util.Message;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/product")
@AllArgsConstructor
@Tag(name = "API REST", description = "All verbs Http-Rest")
public class ProductController {

    /**
     * @Dependency-Injection.
     * @Author Julian1699.
     * @Description Dependency injection of the ProductService.
     * @JpaRepository -> ProductRepository -> ProductService -> ProductController.
     */
    @Autowired
    private final ProductService productService;

    @Operation(
            summary = "Get all products", description = "Returns a list of all available products in the database.",
            tags = {"Gets"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "List of products retrieved successfully"),
            @ApiResponse(responseCode = "404",description = "No products found in the database"),
            @ApiResponse(responseCode = "400",description = "Bad Request")
    })
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        try {
            List<Product> products = productService.getProducts();
            if (products.isEmpty()) {
                return new ResponseEntity<>(Message.EMPTY,HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(products);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());
        }
    }
    @Operation(
            summary = "Add a new product",
            description = "Adds a new product to the database.",
            tags = {"Posts"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Product added successfully"),
            @ApiResponse(responseCode = "400",description = "Bad Request")
    })
    @PostMapping("/post")
    public ResponseEntity<?> postProduct(@Validated @RequestBody Product product) {
        try {
            Product savedProduct = productService.saveProduct(product);
            return new ResponseEntity<>(Message.PRODUCT_SAVED,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Message.BAD_REQUEST,HttpStatus.BAD_REQUEST);
        }
    }
    @Operation(
            summary = "Update an existing product",
            description = "Updates an existing product in the database.",
            tags = {"Puts"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Product added successfully"),
            @ApiResponse(responseCode = "404",description = "Not Found")
    })
    @PutMapping("/put/{id}")
    public ResponseEntity<?> putProduct(@PathVariable Long id, @RequestBody Product product) {
        try {
            Product updatedProduct = productService.updateProduct(id, product);
            return new ResponseEntity<>(Message.PRODUCT_UPDATED,HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body ("Product not found with id: " + id );
        }
    }
    @Operation(
            summary = "Delete an existing product",
            description = "Delete an existing product in the database.",
            tags = {"Delets"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404",description = "Not Found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(Message.PRODUCT_DELETED,HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body ("Product not found with id: " + id );
        }
    }
    @Operation(
            summary = "Get an existing product by his ID",
            description = "Get an existing product in the database.",
            tags = {"Gets"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Get product successfully"),
            @ApiResponse(responseCode = "404",description = "Not Found")
    })
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Product product = productService.findById(id);
            return new ResponseEntity<>(product,HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(Message.PRODUCT_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
    }
    @Operation(
            summary = "Retrieve an existing product by searching by its name, reference, or category",
            description = "Get an existing product in the database using characters for searching.",
            tags = {"Gets"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Product get successfully"),
            @ApiResponse(responseCode = "404",description = "Not Found")
    })
    @GetMapping("/search/{search}")
    public ResponseEntity<?> getBySearch(@PathVariable String search) {
        try {
            Product product =  productService.findAllChars(search);
            return ResponseEntity.ok(product);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with search: " + search);
        }
    }

}
