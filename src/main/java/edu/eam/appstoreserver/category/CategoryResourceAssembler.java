package edu.eam.appstoreserver.category;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
class CategoryResourceAssembler implements ResourceAssembler<ApsCategory, Resource<ApsCategory>> {
    @Override
    public Resource<ApsCategory> toResource (ApsCategory aspCategory) {
        return new Resource<>(
                aspCategory,
                linkTo(methodOn(CategoryController.class).one(aspCategory.getName())).withSelfRel(),
                //Todo: Erfan: remove this link
                linkTo(methodOn(CategoryController.class).all()).withRel("categories")

        );
    }

}