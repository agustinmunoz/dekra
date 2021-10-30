package es.agustin.munoz.dekra.repository;

import es.agustin.munoz.dekra.model.UserDekra;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDekraRepository extends MongoRepository<UserDekra,String> {
}
