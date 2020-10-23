package org.vaadin.example.bookstore.backend.data.Status;

public class Coming extends StatusDecorator {
    public Coming(Status status){
        super(status);
    }

    @Override
    public String toString() {
        return "Coming";
    }
}
