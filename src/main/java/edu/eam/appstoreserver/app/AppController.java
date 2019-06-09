package edu.eam.appstoreserver.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private final static String BASE_URI="/api/store";
    private final AppRepository appRepository;

    AppController (AppRepository appRepository){
        this.appRepository=appRepository;
    }

    @GetMapping(value=BASE_URI+"/apps/{id}", produces = "application/json; charset=UTF-8")
    App one(@PathVariable Long id){
        return appRepository.findById(id).orElseThrow(()-> new AppNotFoundException(id));
    }

}
