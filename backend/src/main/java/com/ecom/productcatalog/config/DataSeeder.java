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
        products.add(createProduct("Smartphone", "Latest smartphone with amazing features",
                "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9", 699.99, electronics));
        products.add(createProduct("Laptop", "High-performance laptop",
                "https://images.unsplash.com/photo-1517336714731-489689fd1ca8", 1299.99, electronics));
        products.add(createProduct("Headphones", "Noise-cancelling headphones",
                "https://images.unsplash.com/photo-1580894894513-fd9358dfe111", 199.99, electronics));
        products.add(createProduct("Smartwatch", "Fitness smartwatch",
                "https://images.unsplash.com/photo-1516574187841-cb9cc2ca948b", 149.99, electronics));
        products.add(createProduct("Bluetooth Speaker", "Portable speaker",
                "https://images.unsplash.com/photo-1519985176271-adb1088fa94c", 89.99, electronics));

// Clothing
        products.add(createProduct("T-Shirt", "100% cotton",
                "https://images.unsplash.com/photo-1585386959984-a415522c2643", 19.99, clothing));
        products.add(createProduct("Jeans", "Slim-fit jeans",
                "https://images.unsplash.com/photo-1602810311491-6c75b19f48d8", 49.99, clothing));
        products.add(createProduct("Jacket", "Winter jacket",
                "https://images.unsplash.com/photo-1582727461515-8c207c6b06d6", 89.99, clothing));
        products.add(createProduct("Sneakers", "Comfortable sneakers",
                "https://images.unsplash.com/photo-1519744792095-2f2205e87b6f", 59.99, clothing));
        products.add(createProduct("Hat", "Stylish hat",
                "https://images.unsplash.com/photo-1573497019410-0369a794ec0f", 14.99, clothing));

// Home and Kitchen
        products.add(createProduct("Blender", "Multi-speed blender",
                "https://images.unsplash.com/photo-1606813908332-1f4b2b2a07aa", 49.99, home));
        products.add(createProduct("Cookware Set", "10-piece cookware set",
                "https://images.unsplash.com/photo-1611599533459-76637bd97d9e", 129.99, home));
        products.add(createProduct("Vacuum Cleaner", "Cordless vacuum",
                "https://images.unsplash.com/photo-1616627985665-e2f2b3f828b1", 199.99, home));
        products.add(createProduct("Coffee Maker", "Automatic coffee machine",
                "https://images.unsplash.com/photo-1527515637462-cff94eecc1ac", 89.99, home));
        products.add(createProduct("Air Fryer", "Healthy cooking fryer",
                "https://images.unsplash.com/photo-1603398938378-d6f0ec53f1e1", 109.99, home));

// Books
        products.add(createProduct("Java Programming", "Complete Java guide",
                "https://images.unsplash.com/photo-1524995997946-a1c2e315a42f", 39.99, books));
        products.add(createProduct("Spring Boot", "Guide to Spring Boot",
                "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c", 44.99, books));
        products.add(createProduct("Data Structures", "DSA explained",
                "https://images.unsplash.com/photo-1531219432768-a9e9cdbc0e9b", 29.99, books));
        products.add(createProduct("Clean Code", "Best practices for coding",
                "https://images.unsplash.com/photo-1517430816045-df4b7de11d1d", 49.99, books));
        products.add(createProduct("System Design", "Basics of system design",
                "https://images.unsplash.com/photo-1531497865144-0464ef8fb9da", 54.99, books));

// Sports
        products.add(createProduct("Football", "Standard football",
                "https://images.unsplash.com/photo-1584820927493-cfdb7c84de9d", 24.99, sports));
        products.add(createProduct("Basketball", "Outdoor basketball",
                "https://images.unsplash.com/photo-1556125574-d7f27ec36a2e", 29.99, sports));
        products.add(createProduct("Yoga Mat", "Non-slip mat",
                "https://images.unsplash.com/photo-1608661669035-345763a9d9fa", 19.99, sports));
        products.add(createProduct("Tennis Racket", "Lightweight racket",
                "https://images.unsplash.com/photo-1552903023-33415a7360ec", 89.99, sports));
        products.add(createProduct("Skipping Rope", "Speed jump rope",
                "https://images.unsplash.com/photo-1611923489793-9f3532e70a9b", 9.99, sports));

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
