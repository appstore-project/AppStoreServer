package edu.eam.appstoreserver.category;

import edu.eam.appstoreserver.AStoreConfig;
import edu.eam.appstoreserver.EntityNotFoundException;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AStoreConfig.apiBaseURL)
public class CategoryController {
    private final ApsCategories apsCategories;
    private final CategoryResourceAssembler assembler;

    public CategoryController(ApsCategories apsCategories, CategoryResourceAssembler assembler) {
        this.apsCategories = apsCategories;
        this.assembler = assembler;
    }

    @GetMapping(value="/categories", produces = "application/json; charset=UTF-8")
    Iterable<ApsCategory> all() {return apsCategories.findAll();}


    @GetMapping(value="/categories/{id}", produces = "application/json; charset=UTF-8")
    Resource<ApsCategory> one(@PathVariable String id) {
        ApsCategory apsCategory = apsCategories.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return assembler.toResource(apsCategory);
    }
}
