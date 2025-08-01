package net.javaguides.springboot.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Schema(
        description = "UserDto model Information"
)

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto
{


    private Long id;
    @Schema(
            description = "User first Name"
    )

    //User first name should not be null or empty
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstname;
    @Schema(
            description = "User last Name"
    )

    //User last name should not be null or empty
    @NotEmpty(message = "User last name should not be null or empty")
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastname;


    @Schema(
            description = "User email"
    )
    //User email should not be null or empty
    //Email address should be valid
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email address should be valid")
    private  String email;

}
