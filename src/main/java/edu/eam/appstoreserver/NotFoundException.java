package edu.eam.appstoreserver;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id) {
        super("Could not find resource with id " + id);
    }
}
