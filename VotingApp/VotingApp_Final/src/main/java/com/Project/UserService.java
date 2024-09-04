package com.Project;

import java.util.List;

import com.Project.model.User;
import com.Project.repository.CandidateRepository;
import com.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CandidateRepository canRepo;
	
	public User addUser(User user)
	{
		user.setRole("ROLE_NORMAL");
		
		return this.userRepo.save(user);
	}
	
	public List<User> getAllUsers()
	{
		return this.userRepo.findAll();
	}
	
	public User getUserById(int id)
	{
		return this.userRepo.getById(id);
	}
	
	public void deleteUser(int id)
	{
		this.userRepo.deleteById(id);
	}
	
	public User getUserByEmail(String email)
	{
		return this.userRepo.getUserByEmail(email);
	}
	

	

}
