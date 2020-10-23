package org.vaadin.example.bookstore.backend.data.Status;

public abstract class StatusDecorator implements Status {
    private final Status status;

    public StatusDecorator(Status status){
        this.status = status;
    }


}
