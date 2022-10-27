package simoes.mario.MongoDB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simoes.mario.MongoDB.domain.User;
import simoes.mario.MongoDB.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	public List<User> findAll(){
		return repository.findAll();
	}
}
