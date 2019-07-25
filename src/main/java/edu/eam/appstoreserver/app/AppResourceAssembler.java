package edu.eam.appstoreserver.app;

import edu.eam.appstoreserver.appreview.ApsAppReviewController;
import edu.eam.appstoreserver.file.FileBodyController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Component
public
class AppResourceAssembler implements ResourceAssembler<App, Resource<App>> {
    @Override
    public Resource<App> toResource (App app) {
        return new Resource<>(
                app,
                linkTo(methodOn(AppController.class).one(app.getId())).withSelfRel(),
                linkTo(methodOn(ApsAppReviewController.class).getCommentsOfApp(app.getId())).withRel("appComments"),
                linkTo(methodOn(FileBodyController.class).getFile(app.getIconFileId())).withRel("icon")
                //Todo: Erfan: remove this link
                //linkTo(methodOn(AppController.class).all()).withRel("apps")

                //Todo: Erfan; Add extra links: category, install(), comment(), rate()
                //Todo: Erfan; Add more functionality (by or without links):  new,
        );
    }

}
