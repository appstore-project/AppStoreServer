package edu.eam.appstoreserver._legacy;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
class AppProductResourceAssembler implements ResourceAssembler<AppProduct, Resource<AppProduct>> {
    @Override
    public Resource<AppProduct> toResource(AppProduct AppProduct) {
        return new Resource<>(AppProduct,
                linkTo(methodOn(AppProductController.class).one(AppProduct.getId())).withSelfRel(),
                linkTo(methodOn(AppProductController.class).all()).withRel("AppProducts"));
    }
}
