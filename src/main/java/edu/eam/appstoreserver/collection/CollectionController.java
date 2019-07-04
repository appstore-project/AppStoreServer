package edu.eam.appstoreserver.collection;

import edu.eam.appstoreserver.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CollectionController {
    private final static String BASE_URI="/api/store/collections";
    private final Collections rows;
    private final CollectionResourceAssembler assembler;

    CollectionController(Collections rows, CollectionResourceAssembler assembler) {
        this.rows = rows;
        this.assembler = assembler;
    }

    @GetMapping(value=BASE_URI, produces = "application/json; charset=UTF-8")
    Resources<Resource<Collection>> all() {
        List<Resource<Collection>> collections =
                rows.findAll(Sort.by("position"))
                    .stream()
                    .map(assembler::toResource)
                    .collect(Collectors.toList());
        return new Resources<>(
                collections,
                //Todo: Erfan; If this link is not usable remove it.
                linkTo(methodOn(CollectionController.class).all()).withSelfRel()
        );
    }

    @GetMapping(value=BASE_URI+"/{id}", produces = "application/json; charset=UTF-8")
    Resource<Collection> one(@PathVariable Long id){
        Collection row = rows.findById(id).orElseThrow(()-> new EntityNotFoundException(id));
        return assembler.toResource(row);
    }


}
