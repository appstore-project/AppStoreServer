package edu.eam.appstoreserver.collection;

import edu.eam.appstoreserver.app.App;
import edu.eam.appstoreserver.app.AppController;
import edu.eam.appstoreserver.app.AppResourceAssembler;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class CollectionResourceAssembler implements ResourceAssembler<Collection, Resource<Collection>> {
    @Override
    public Resource<Collection> toResource(Collection collection) {
//        AppResourceAssembler appResourceAssembler = new AppResourceAssembler();
//        List<Resource<App>> appList = collection.getApps().stream()
//                .map(appResourceAssembler::toResource)
//                .collect(Collectors.toList());

        return new Resource<>(
                collection,
                linkTo(methodOn(CollectionController.class).one(collection.getId())).withSelfRel(),
//                linkTo(methodOn(CollectionController.class).all()).withRel("rows")
                linkTo(methodOn(AppController.class).appOfCollection(collection.getId())).withRel("rowApps")
                );
    }
}

//linkTo(methodOn(FileBodyController.class).getImage(app.getIconFileId())).withRel("icon")