package org.vaadin.example.bookstore.backend.mock;

import org.vaadin.example.bookstore.backend.data.Category;

import java.util.*;

public class GenerateCateogry implements Generate<Category, Category> {

//    private static final Random random = new Random(1);

    private static int nextCategoryId = 1;
    private static final String[] categoryNames = new String[] {
            "Children's books", "Best sellers", "Romance", "Mystery",
            "Thriller", "Sci-fi", "Non-fiction", "Cookbooks" };

    @Override
    public Category createSingle(String name) {
        Category c = new Category();
        c.setId(nextCategoryId++);
        c.setName(name);
        return c;
    }

    @Override
    public List<Category> createMultiple(List<Category> categories) {
        for (String name : categoryNames) {
            Category c = createSingle(name);
            categories.add(c);
        }
        return categories;
    }

    @Override
    public Set<Category> getRandom(List<Category> categories, int min, int max) {
        int nr = Generate.random.nextInt(max) + min;
        HashSet<Category> productCategories = new HashSet<Category>();
        for (int i = 0; i < nr; i++) {
            productCategories.add(categories.get(random.nextInt(categories
                    .size())));
        }

        return productCategories;
    }
}
