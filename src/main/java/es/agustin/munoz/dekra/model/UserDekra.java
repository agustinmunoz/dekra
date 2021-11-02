package es.agustin.munoz.dekra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@ToString
@Document(collection = "userdekra")
public class UserDekra {


        public UserDekra() {
        }

        @ApiModelProperty(position = 1,required = true)
        @NotBlank(message = "Username cannot be null")
        @Id
        private String username;
        @ApiModelProperty(position = 2,required = true)
        @NotBlank(message = "Name cannot be null")
        private String name;
        @ApiModelProperty(position = 3,required = true)
        @NotBlank(message = "Surname cannot be null")
        private String surname;
        @ApiModelProperty(position = 4,required = true)
        @NotBlank(message = "Email cannot be null")
        private String email;
        @ApiModelProperty(position = 5,required = true)
        @NotBlank(message = "Password cannot be null")
        private String password;
        @ApiModelProperty(position = 6,required = true)
        @NotNull(message = "Age cannot be null")
        private int age;
        @ApiModelProperty(position = 7,required = true)
        @NotNull(message = "Active be null")
        private boolean active;
        @ApiModelProperty(position=8,hidden=true,required = false)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        private LocalDateTime lastLogin;
        @ApiModelProperty(position=9,hidden=true,required = false)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        private LocalDateTime creationDate;




    }
