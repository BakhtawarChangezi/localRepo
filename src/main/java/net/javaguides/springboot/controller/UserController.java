package net.javaguides.springboot.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.ErrorDetails;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Tag(

        name="CRUD REST APIS FOR USER RESOURCE",
        description = "Create User,Update User,Get User,GET ALL USERS,Delete User"

)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final WebRequest webRequest;
    private UserService userService;



@Operation(

        summary = "Create User Rest Api",
        description = "CReate user rest api  is used to save user in a database"
)
@ApiResponse(
        responseCode="201",
        description="HTTP STATUS 201 CREATED"
)
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }


    @Operation(

            summary = "GET USER BY ID  Rest Api",
            description = "Get user rest api  is used to  get a single user from database"
    )
    @ApiResponse(
            responseCode="200",
            description="HTTP STATUS 200 CREATED"
    )

    @RequestMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userid) {
        UserDto user = userService.getUserById(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }


    @Operation(

            summary = "Get All User Rest Api",
            description = "Get all user rest api  is used to get all user from a database"
    )
    @ApiResponse(
            responseCode="200",
            description="HTTP STATUS 200 CREATED"
    )

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @Operation(

            summary = "Update User Rest Api",
            description = " Update user rest api  is used to update particular user from a database"
    )
    @ApiResponse(
            responseCode="200",
            description="HTTP STATUS 200 success"
    )



    @PutMapping("{id}")
    public ResponseEntity<UserDto> getAllUsersById(@Valid @PathVariable("id") long id, @RequestBody UserDto user) {

        user.setId(id);
        UserDto updateduser = userService.updateUser(user);
        return new ResponseEntity<>(updateduser, HttpStatus.OK);

    }


    @Operation(

            summary = "Delete User Rest Api",
            description = "Delete user rest api  is used to delete particular user from a database"
    )
    @ApiResponse(
            responseCode="200",
            description="HTTP STATUS 200 Success"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
    }



}
