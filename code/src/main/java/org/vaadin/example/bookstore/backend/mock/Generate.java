package org.vaadin.example.bookstore.backend.mock;

import java.util.List;
import java.util.Random;
import java.util.Set;

public interface Generate<T, Y> {

    Random random = new Random(1);

    T createSingle(String input);

    List<T> createMultiple(List<Y> input);

    Set<T> getRandom(List<T> input, int min, int max);
}
