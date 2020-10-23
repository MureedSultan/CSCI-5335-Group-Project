package org.vaadin.example.bookstore.backend.data.Status;

public class Available extends StatusDecorator{
    public Available(Status status){
        super(status);
    }

    @Override
    public String toString() {
        return "Available";
    }
}
