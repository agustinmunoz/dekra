package es.agustin.munoz.dekra.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@ToString
@Document(collection = "userdekra")
public class UserDekra {


        public UserDekra() {
        }

        @Id
        private String id;
        private String username;
        private String name;
        private String surname;
        private String email;
        private String password;
        private int age;
        private boolean active;
        private Date lastLogin;
        private Date creationDate;




    }
