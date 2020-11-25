package org.vaadin.example.bookstore.backend.mock;

import org.vaadin.example.bookstore.backend.data.Category;
import org.vaadin.example.bookstore.backend.data.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Generator {

    private Generate<Category, Category> category;
    private Generate<Product, Category> product;

    private static List<Category> allCategories = new ArrayList<Category>();

    private Generator(){
        category = new GenerateCateogry();
        product = new GenerateProduct();
    }

    private static Generator instance = new Generator();

    public static  Generator getInstance(){
        return instance;
    }

    public Product createSingleProduct(String name){
        return product.createSingle(name);
    }

    public List<Product> createMultipleProducts(List<Category> categories){
        return product.createMultiple(categories);
    }

    public Category createSingleCategory(String name){
        return category.createSingle(name);
    }

    public List<Category> createMultipleCategories(List<Category> categories){
        allCategories = category.createMultiple(categories);
        return category.createMultiple(categories);
    }

    public static List<Category> getAllCategories(){
        return allCategories;
    }

    public Set<Category> getRandomCategory(List<Category> categories, int min, int max){
        return category.getRandom(categories, min, max);
    }

}
