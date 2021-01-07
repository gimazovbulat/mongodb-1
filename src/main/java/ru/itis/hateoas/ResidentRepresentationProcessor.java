package ru.itis.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.controllers.TrashController;
import ru.itis.models.Resident;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ResidentRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Resident>> {
    @Override
    public EntityModel<Resident> process(EntityModel<Resident> model) {
        Resident resident = model.getContent();
        if (resident.getIsVip()) {
            model.add(linkTo(methodOn(TrashController.class).bookWholeFloor(resident)).withRel("bookWholeFloor"));
        }
        return model;
    }
}
