package org.example.useridcard;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;

@Path("/api/v1/users/{id}/cards")
@Produces(MediaType.APPLICATION_JSON)
public class UserIdCardResource {

    private final UserIdCardService userIdCardService;

    private final ModelMapper modelMapper;

    @Inject
    public UserIdCardResource(UserIdCardService userIdCardService,
                        ModelMapper modelMapper) {
        this.userIdCardService = userIdCardService;
        this.modelMapper = modelMapper;
    }

    @POST
    @Timed
    @UnitOfWork
    public void createUserIdCard(@Valid UserIdCardInsertDTO userIdCardInsertDTO) {
        UserIdCard userIdCard = modelMapper.map(userIdCardInsertDTO, UserIdCard.class);
        userIdCardService.create(userIdCard);
    }

    @GET
    @Path(value = "{id}")
    @Timed
    @UnitOfWork
    public UserIdCardDTO getById(@PathParam("id") Long id){
        return modelMapper.map(userIdCardService.findById(id), UserIdCardDTO.class);
    }

}
