package com.richiecodes.inventorymanager.controller;

import com.richiecodes.inventorymanager.exception.ResourceNotFoundException;
import com.richiecodes.inventorymanager.model.Product;
import com.richiecodes.inventorymanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // CREATE
    @PostMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Product createProduct(@RequestBody Product p) {
        return repository.save(p);
    }

    // READ
    @GetMapping("{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No products with ID " + id));

        return ResponseEntity.ok(product);
    }

    // UPDATE
    @PostMapping("{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product details) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No products with ID " + id));

        product.setName(details.getName());
        product.setPrice(details.getPrice());
        product.setPerishable(details.isPerishable());
        product.setQty(details.getQty());

        repository.save(product);

        return ResponseEntity.ok(product);
    }

    // DELETE
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No products with ID " + id));

        repository.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
