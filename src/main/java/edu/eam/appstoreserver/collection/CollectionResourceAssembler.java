package edu.eam.appstoreserver.collection;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class CollectionResourceAssembler implements ResourceAssembler<Collection, Resource<Collection>> {
    @Override
    public Resource<Collection> toResource(Collection collection) {
        return new Resource<>(
                collection,
                linkTo(methodOn(CollectionController.class).one(collection.getId())).withSelfRel(),
                linkTo(methodOn(CollectionController.class).all()).withRel("rows")
                );
    }
}
