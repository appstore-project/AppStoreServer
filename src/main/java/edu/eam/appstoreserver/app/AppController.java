package edu.eam.appstoreserver.app;

import edu.eam.appstoreserver.EntityNotFoundException;
import edu.eam.appstoreserver.AStoreConfig;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AStoreConfig.apiBaseURL)
public class AppController {
    private final Apps apps;
    private final AppResourceAssembler assembler;

    AppController (Apps apps, AppResourceAssembler assembler){
        this.apps = apps;
        this.assembler = assembler;
    }

    //TODO: Remove this functionality.
    @GetMapping(value="/apps", produces = "application/json; charset=UTF-8")
    List<App> all() {return apps.findAll();}


    @GetMapping(value="apps/{id}", produces = "application/json; charset=UTF-8")
    Resource<App> one(@PathVariable Long id){
        App app = apps.findById(id).orElseThrow(()-> new EntityNotFoundException(id));
        return assembler.toResource(app);
    }

}
