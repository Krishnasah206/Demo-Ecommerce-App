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
                "https://th.bing.com/th/id/OIP.gRJKV8f3c5QvkIjmA6aPUgHaE8?r=0&rs=1&pid=ImgDetMain", 699.99, electronics));
        products.add(createProduct("Laptop", "High-performance laptop",
                "https://th.bing.com/th/id/OIP.Dno__6b0G4ssuVwlsPp5GgHaHa?w=192&h=192&c=7&r=0&o=5&dpr=1.3&pid=1.7", 1299.99, electronics));
        products.add(createProduct("Headphones", "Noise-cancelling headphones",
                "https://th.bing.com/th/id/OIP.YtwLOiBXTxowid9HYrtCwwHaJR?r=0&rs=1&pid=ImgDetMain", 199.99, electronics));
        products.add(createProduct("Smartwatch", "Fitness smartwatch",
                "https://th.bing.com/th/id/OIP.kiAc12IquvExon2LjX5LFAHaHa?r=0&rs=1&pid=ImgDetMain", 149.99, electronics));
        products.add(createProduct("Bluetooth Speaker", "Portable speaker",
                "https://th.bing.com/th/id/OIP.gJpIPjTuaWu8oFuiDvGVBwHaHB?r=0&rs=1&pid=ImgDetMain", 89.99, electronics));

// Clothing
        products.add(createProduct("T-Shirt", "100% cotton",
                "https://cdn.pixabay.com/photo/2023/05/06/01/34/t-shirt-7973404_1280.jpg", 19.99, clothing));
        products.add(createProduct("Jeans", "Slim-fit jeans",
                "https://th.bing.com/th/id/OIP.mQD5mAAqdaAVfHitRShtugHaGh?r=0&rs=1&pid=ImgDetMain", 49.99, clothing));
        products.add(createProduct("Jacket", "Winter jacket",
                "https://static.vecteezy.com/system/resources/previews/021/600/121/original/jacket-mockup-with-white-background-free-photo.jpg", 89.99, clothing));
        products.add(createProduct("Sneakers", "Comfortable sneakers",
                "https://images.pexels.com/photos/1670766/pexels-photo-1670766.jpeg?cs=srgb&dl=pexels-mnzoutfits-1670766.jpg&fm=jpg", 59.99, clothing));
        products.add(createProduct("Hat", "Stylish hat",
                "https://th.bing.com/th/id/R.31bf3d96e3b4d3ce2cedf400a2773413?rik=vJcpPS2COERayA&pid=ImgRaw&r=0", 14.99, clothing));

// Home and Kitchen
        products.add(createProduct("Blender", "Multi-speed blender",
                "https://nomsmagazine.com/wp-content/uploads/2022/09/best-ninja-blender-on-amazon-Ninja-SS201-Foodi-Power-Pitcher2-900x900.jpg", 49.99, home));
        products.add(createProduct("Cookware Set", "10-piece cookware set",
                "https://th.bing.com/th/id/OIP.La-CcyX5cTYJp-9iBhBm8wHaHa?r=0&rs=1&pid=ImgDetMain", 129.99, home));
        products.add(createProduct("Vacuum Cleaner", "Cordless vacuum",
                "https://th.bing.com/th/id/OIP.7jnRSG21QajyhHTRHwZp_gHaFj?r=0&rs=1&pid=ImgDetMain", 199.99, home));
        products.add(createProduct("Coffee Maker", "Automatic coffee machine",
                "https://i5.walmartimages.com/asr/2be84a37-fe23-43d5-8f79-23365322e0d7.00c7772af3916e81e3e956618bf248b4.jpeg", 89.99, home));
        products.add(createProduct("Air Fryer", "Healthy cooking fryer",
                "https://as1.ftcdn.net/v2/jpg/05/85/96/96/1000_F_585969662_7Gy4JUupnH3ssTDwC6VRTqHqjTMA2H06.jpg", 109.99, home));

// Books
        products.add(createProduct("Java Programming", "Complete Java guide",
                "https://th.bing.com/th/id/OIP.fHwezjRSlNL9N9YsnDpdmQHaJz?r=0&rs=1&pid=ImgDetMain", 39.99, books));
        products.add(createProduct("Spring Boot", "Guide to Spring Boot",
                "https://th.bing.com/th/id/OIP.mT_4MpH8uGSvperVFnY7_QAAAA?r=0&rs=1&pid=ImgDetMain", 44.99, books));
        products.add(createProduct("Data Structures", "DSA explained",
                "https://m.media-amazon.com/images/I/61Z95xRpl9L._SL1500_.jpg", 29.99, books));
        products.add(createProduct("Clean Code", "Best practices for coding",
                "https://th.bing.com/th/id/R.d54a5779f57c662caeec40a0addd8483?rik=qtEt3bSqabMF0w&pid=ImgRaw&r=0", 49.99, books));
        products.add(createProduct("System Design", "Basics of system design",
                "https://i0.wp.com/i.pinimg.com/564x/8f/06/a9/8f06a98dc2d55219beb640d91b2720db.jpg", 54.99, books));

// Sports
        products.add(createProduct("Football", "Standard football",
                "https://th.bing.com/th/id/R.38d505da022c387aa620b4a8cd61f5d8?rik=2znGpI2YOQDJug&riu=http%3a%2f%2fwww.baltana.com%2ffiles%2fwallpapers-2%2fSoccer-HD-Wallpapers-04301.jpg&ehk=XfTuh%2fGTm9GYk0VurZ93bjbi2dAWWIT%2bnq0SW25fCHU%3d&risl=&pid=ImgRaw&r=0", 24.99, sports));
        products.add(createProduct("Basketball", "Outdoor basketball",
                "https://th.bing.com/th/id/OIP.2S7vfMQQmEKnPNRMPNNTNAHaHP?r=0&rs=1&pid=ImgDetMain", 29.99, sports));
        products.add(createProduct("Yoga Mat", "Non-slip mat",
                "https://media.istockphoto.com/photos/yoga-mats-picture-id475133688?k=6&m=475133688&s=612x612&w=0&h=cvhGbb2zkDrInFm49jxqZUlm0b_P1Wh6p0CiyZN56kk=", 19.99, sports));
        products.add(createProduct("Tennis Racket", "Lightweight racket",
                "https://th.bing.com/th/id/OIP.CNVJjbJ5xwH15cS8lUPkswHaIn?r=0&rs=1&pid=ImgDetMain", 89.99, sports));
        products.add(createProduct("Skipping Rope", "Speed jump rope",
                "https://i.pinimg.com/originals/12/dc/68/12dc68a303a78b9ec3b3056e68253ff7.jpg", 9.99, sports));

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
