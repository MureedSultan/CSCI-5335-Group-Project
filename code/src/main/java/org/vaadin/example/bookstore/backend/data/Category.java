package org.vaadin.example.bookstore.backend.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Category implements Serializable {

    @NotNull
    private int id = -1;
    @Size(min = 2, message = "Category name must be at least two characters")
    private String name;
    private List<Category> subCategories;

    public Category(){
        subCategories = new ArrayList<Category>();
    }

    public void addSubCategory(Category c){
        subCategories.add(c);
    }

    public void removeSubCategory(Category c) {
        subCategories.remove(c);
    }

    public List<Category> getSubCategories(){
        return subCategories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    /*
     * Vaadin DataProviders rely on properly implemented equals and hashcode
     * methods.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || id == -1) {
            return false;
        }
        if (obj instanceof Category) {
            return id == ((Category) obj).id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (id == -1) {
            return super.hashCode();
        }

        return Objects.hash(id);
    }
}
