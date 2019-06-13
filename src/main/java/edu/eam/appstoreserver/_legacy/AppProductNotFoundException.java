package edu.eam.appstoreserver._legacy;

class AppProductNotFoundException extends RuntimeException{

    AppProductNotFoundException(Long id) {
        super("Could not find app " + id);
    }
}
