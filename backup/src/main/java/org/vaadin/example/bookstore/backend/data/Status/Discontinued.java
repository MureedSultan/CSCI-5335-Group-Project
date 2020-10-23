package org.vaadin.example.bookstore.backend.data.Status;

public class Discontinued extends StatusDecorator {
    public Discontinued(Status status){
        super(status);
    }

    @Override
    public String toString() {
        return "Discontinued";
    }
}
