package org.vaadin.example.bookstore.backend.mock;

import com.sun.tools.javac.jvm.Gen;
import org.vaadin.example.bookstore.backend.data.Availability;
import org.vaadin.example.bookstore.backend.data.Category;
import org.vaadin.example.bookstore.backend.data.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GenerateProduct implements Generate<Product, Category>{

    private static int nextProductId = 1;
//    private static final Random random = new Random(1);
    private static final String[] word1 = new String[] { "The art of", "Mastering",
            "The secrets of", "Avoiding", "For fun and profit: ",
            "How to fail at", "10 important facts about",
            "The ultimate guide to", "Book of", "Surviving", "Encyclopedia of",
            "Very much", "Learning the basics of", "The cheap way to",
            "Being awesome at", "The life changer:", "The Vaadin way:",
            "Becoming one with", "Beginners guide to",
            "The complete visual guide to", "The mother of all references:" };

    private static final String[] word2 = new String[] { "gardening",
            "living a healthy life", "designing tree houses", "home security",
            "inter-galaxy travel", "meditation", "ice hockey",
            "children's education", "computer programming", "Vaadin TreeTable",
            "winter bathing", "playing the cello", "dummies", "rubber bands",
            "feeling down", "debugging", "running barefoot",
            "speaking to a big audience", "creating software", "giant needles",
            "elephants", "keeping your wife happy" };

    @Override
    public Product createSingle(String name) {
        Product p = new Product();
        p.setId(nextProductId++);
        if(name.isEmpty()){
            p.setProductName(generateName());
        } else {
            p.setProductName(name);
        }

        p.setPrice(new BigDecimal((Generate.random.nextInt(250) + 50) / 10.0));
        p.setAvailability(Availability.values()[random.nextInt(Availability
                .values().length)]);
        if (p.getAvailability() == Availability.AVAILABLE) {
            p.setStockCount(random.nextInt(523));
        }

        List<Category> categories = Generator.getAllCategories();
        Set<Category> productCategories =  Generator.getInstance().getRandomCategory(categories, 1, 2);
        p.setCategory(productCategories);
        return p;
    }

    @Override
    public List<Product> createMultiple(List<Category> categories) {
        List<Product> products = new ArrayList<Product>();
        for (int i = 0; i < 100; i++) {
            Product p = createSingle("");
            products.add(p);
        }

        return products;
    }

    @Override
    public Set<Product> getRandom(List<Product> input, int min, int max) {
        return null;
    }

    private static String generateName() {
        return word1[random.nextInt(word1.length)] + " "
                + word2[random.nextInt(word2.length)];
    }
}
