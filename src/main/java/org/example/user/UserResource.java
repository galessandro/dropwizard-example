package org.example.user;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Path("/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @Inject
    public UserResource(UserService userService,
                        ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GET
    @Path(value = "{userId}")
    @Timed
    @UnitOfWork
    public UserDTO getUserById(@PathParam("userId") Long id){
        User user = userService.findById(id);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @GET
    @UnitOfWork
    public List<UserDTO> getAllUsers(){
        return userService
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @POST
    @Timed
    @UnitOfWork
    public void createUser(@Valid UserInsertDTO userInsertDTO){
        User user = modelMapper.map(userInsertDTO, User.class);
        userService.create(user);
    }

}
