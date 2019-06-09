package edu.eam.appstoreserver.app;

class AppNotFoundException extends RuntimeException{
    AppNotFoundException(Long id) {
        super("Could not find app " + id);
    }
}
