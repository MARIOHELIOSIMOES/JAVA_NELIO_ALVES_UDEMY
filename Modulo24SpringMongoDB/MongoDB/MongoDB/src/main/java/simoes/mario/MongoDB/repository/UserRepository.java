package simoes.mario.MongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import simoes.mario.MongoDB.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
