package edu.eam.appstoreserver.app;

import edu.eam.appstoreserver.EntityNotFoundException;
import edu.eam.appstoreserver.AStoreConfig;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

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
    //List<App> all() {return apps.findAll();}
    Resources<Resource<App>> all() {
        List<Resource<App>> appList = apps.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(appList, linkTo(methodOn(AppController.class).all()).withSelfRel());

    }


    @GetMapping(value="/apps/{id}", produces = "application/json; charset=UTF-8")
    Resource<App> one(@PathVariable Long id){
        App app = apps.findById(id).orElseThrow(()-> new EntityNotFoundException(id));
        return assembler.toResource(app);
    }


    @GetMapping(value="/apps/collection/{colId}", produces = "application/json; charset=UTF-8")
    public Resources<Resource<App>> appOfCollection(@PathVariable Long colId) {
        List<App> appLs = apps.findMemberOfCollection(colId);
        List<Resource<App>> appList = appLs.stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(appList, linkTo(methodOn(AppController.class).all()).withSelfRel());

    }
}
