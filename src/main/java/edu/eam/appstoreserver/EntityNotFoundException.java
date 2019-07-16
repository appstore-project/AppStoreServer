package edu.eam.appstoreserver;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Long id) {
        super("Could not find resource with id " + id);
    }

    public EntityNotFoundException(String id) {
        super("Could not find resource with id " + id);
    }

}
