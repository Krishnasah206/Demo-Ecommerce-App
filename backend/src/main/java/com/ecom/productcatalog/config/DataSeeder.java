package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Create and save categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        Category books = new Category();
        books.setName("Books");

        Category sports = new Category();
        sports.setName("Sports");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home, books, sports));

        // Create and save products
        List<Product> products = new ArrayList<>();

        // Electronics
        products.add(createProduct("Smartphone", "Latest smartphone with amazing features", "https://placehold.co/600x400", 699.99, electronics));
        products.add(createProduct("Laptop", "High-performance laptop", "https://placehold.co/600x400", 1299.99, electronics));
        products.add(createProduct("Headphones", "Noise-cancelling headphones", "https://placehold.co/600x400", 199.99, electronics));
        products.add(createProduct("Smartwatch", "Fitness smartwatch", "https://placehold.co/600x400", 149.99, electronics));
        products.add(createProduct("Bluetooth Speaker", "Portable speaker", "https://placehold.co/600x400", 89.99, electronics));

        // Clothing
        products.add(createProduct("T-Shirt", "100% cotton", "https://placehold.co/600x400", 19.99, clothing));
        products.add(createProduct("Jeans", "Slim-fit jeans", "https://placehold.co/600x400", 49.99, clothing));
        products.add(createProduct("Jacket", "Winter jacket", "https://placehold.co/600x400", 89.99, clothing));
        products.add(createProduct("Sneakers", "Comfortable sneakers", "https://placehold.co/600x400", 59.99, clothing));
        products.add(createProduct("Hat", "Stylish hat", "https://placehold.co/600x400", 14.99, clothing));

        // Home and Kitchen
        products.add(createProduct("Blender", "Multi-speed blender", "https://placehold.co/600x400", 49.99, home));
        products.add(createProduct("Cookware Set", "10-piece cookware set", "https://placehold.co/600x400", 129.99, home));
        products.add(createProduct("Vacuum Cleaner", "Cordless vacuum", "https://placehold.co/600x400", 199.99, home));
        products.add(createProduct("Coffee Maker", "Automatic coffee machine", "https://placehold.co/600x400", 89.99, home));
        products.add(createProduct("Air Fryer", "Healthy cooking fryer", "https://placehold.co/600x400", 109.99, home));

        // Books
        products.add(createProduct("Java Programming", "Complete Java guide", "https://placehold.co/600x400", 39.99, books));
        products.add(createProduct("Spring Boot", "Guide to Spring Boot", "https://placehold.co/600x400", 44.99, books));
        products.add(createProduct("Data Structures", "DSA explained", "https://placehold.co/600x400", 29.99, books));
        products.add(createProduct("Clean Code", "Best practices for coding", "https://placehold.co/600x400", 49.99, books));
        products.add(createProduct("System Design", "Basics of system design", "https://placehold.co/600x400", 54.99, books));

        // Sports
        products.add(createProduct("Football", "Standard football", "https://placehold.co/600x400", 24.99, sports));
        products.add(createProduct("Basketball", "Outdoor basketball", "https://placehold.co/600x400", 29.99, sports));
        products.add(createProduct("Yoga Mat", "Non-slip mat", "https://placehold.co/600x400", 19.99, sports));
        products.add(createProduct("Tennis Racket", "Lightweight racket", "https://placehold.co/600x400", 89.99, sports));
        products.add(createProduct("Skipping Rope", "Speed jump rope", "https://placehold.co/600x400", 9.99, sports));

        productRepository.saveAll(products);
    }

    private Product createProduct(String name, String description, String imageUrl, double price, Category category) {
        Product p = new Product();
        p.setName(name);
        p.setDescription(description);
        p.setImageUrl(imageUrl);
        p.setPrice(price);
        p.setCategory(category);
        return p;
    }

}
