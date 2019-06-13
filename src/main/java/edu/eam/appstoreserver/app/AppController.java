package edu.eam.appstoreserver.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    private final static String BASE_URI="/api/store/apps";
    private final Apps apps;

    AppController (Apps apps){
        this.apps = apps;
    }

    @GetMapping(value=BASE_URI, produces = "application/json; charset=UTF-8")
    List<App> all() {
        return apps.findAll();
    }

    @GetMapping(value=BASE_URI+"/{id}", produces = "application/json; charset=UTF-8")
    App one(@PathVariable Long id){
        return apps.findById(id).orElseThrow(()-> new AppNotFoundException(id));
    }

}
