package edu.eam.appstoreserver.legacy;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
class AppProductController {
//    private final String base_uri = "/api/v1";
    private final AppProductRepository repository;
    private final AppProductResourceAssembler assembler;

    AppProductController(AppProductRepository repository,
                       AppProductResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    @GetMapping(value="/apps/getAll", produces = "application/json; charset=UTF-8")
    Resources<Resource<AppProduct>> getall(){
        List<Resource<AppProduct>> AppProducts = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(AppProducts,
                linkTo(methodOn(AppProductController.class).getall()).withSelfRel());
    }


    //@GetMapping("/apps") 98.01.29; Erfan. Changed to below just for good seen in Browsers. (It works find by Test Tools)
    @GetMapping(value="/apps", produces = "application/json; charset=UTF-8")
    Resources<Resource<AppProduct>> all(){
        List<Resource<AppProduct>> AppProducts = repository.findAll().stream()
                .map(assembler::toResource)
                /*.map(AppProduct -> new Resource<>(AppProduct,
                        linkTo(methodOn(AppProductController.class).one(AppProduct.getId())).withSelfRel(),
                        linkTo(methodOn(AppProductController.class).all()).withRel("AppProducts")))*/
                .collect(Collectors.toList());
        return new Resources<>(AppProducts,
                linkTo(methodOn(AppProductController.class).all()).withSelfRel());
    }
    /* 98.01.29; Erfan.  Made it RESTful
    List<AppProduct> all() {
        return repository.findAll();
    }*/

    @PostMapping("/apps")
    ResponseEntity<?> newAppProduct(@RequestBody AppProduct newAppProduct) throws URISyntaxException {
        Resource<AppProduct> resource = assembler.toResource(repository.save(newAppProduct));
        return ResponseEntity
                .created( new URI(resource.getId().expand().getHref())) //Erfan Notice: Dont confuse Resource.getId() with AppProduct.getId(). this IDs are different things
                .body(resource);
    }
    /*AppProduct newAppProduct(@RequestBody AppProduct newAppProduct) {
        return repository.save(newAppProduct);
    }*/


    @GetMapping(value="/apps/getAppInfo/{appCode}", produces = "application/json; charset=UTF-8")
//    Resource<AppProduct> getone(@RequestParam("appCode") long app_code){
    Resource<AppProduct> getone(@PathVariable Long appCode){
            final long apid =1;
        AppProduct AppProduct = repository.findById(apid)
                .orElseThrow(()-> new AppProductNotFoundException(appCode));

        return assembler.toResource(AppProduct);
    }


    //@GetMapping("/apps/{id}") 98.01.29; Erfan. Changed to below just for good seen in Browsers. (It works find by Test Tools)
    @GetMapping(value="/apps/{id}", produces = "application/json; charset=UTF-8")
    Resource<AppProduct> one(@PathVariable Long id){
        AppProduct AppProduct = repository.findById(id)
                .orElseThrow(()-> new AppProductNotFoundException(id));

        return assembler.toResource(AppProduct);
        /* 98.01.29; Erfan. Change to use ResourceAssembler. (It can be done just in Java 8+)
        return new Resource<>(AppProduct,
                linkTo(methodOn(AppProductController.class).one(id)).withSelfRel(),
                linkTo(methodOn(AppProductController.class).all()).withRel("AppProducts"));
         */

    }
    /*  98.01.29; Erfan.  Made it RESTful
    AppProduct one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()-> new AppProductNotFoundException(id));
    }*/

    @PutMapping("/apps/{id}")
    ResponseEntity<?> replaceAppProduct(@RequestBody AppProduct newAppProduct, @PathVariable Long id) throws URISyntaxException {
        AppProduct updatedAppProduct = repository.findById(id)
                .map(AppProduct -> {
                    //AppProduct.setTitle(newAppProduct.getTitle());
                    AppProduct.setVersion(newAppProduct.getVersion());
                    AppProduct.setCategory(newAppProduct.getCategory());
                    return repository.save(AppProduct);
                })
                .orElseGet(() -> {
                    newAppProduct.setId(id);
                    return repository.save(newAppProduct);
                });
        Resource<AppProduct> resource = assembler.toResource(updatedAppProduct);
        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }
    /*AppProduct replaceAppProduct(@RequestBody AppProduct newAppProduct, @PathVariable Long id) {

        return repository.findById(id)
                .map(AppProduct -> {
                    AppProduct.setName(newAppProduct.getName());
                    AppProduct.setRole(newAppProduct.getRole());
                    return repository.save(AppProduct);
                })
                .orElseGet(() -> {
                    newAppProduct.setId(id);
                    return repository.save(newAppProduct);
                });
    }*/

    @DeleteMapping("/apps/{id}")
    ResponseEntity<?> deleteAppProduct(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    /*void deleteAppProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }*/
}
