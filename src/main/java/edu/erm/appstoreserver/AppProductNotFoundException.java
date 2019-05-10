package edu.erm.appstoreserver;

class AppProductNotFoundException extends RuntimeException{

    AppProductNotFoundException(Long id) {
        super("Could not find Application " + id);
    }
}
