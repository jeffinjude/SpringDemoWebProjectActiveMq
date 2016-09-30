package com.springdemo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.jmsmessaging.MessageSender;
import com.springdemo.models.UserDetails;
import com.springdemo.repositories.UserRepository;

@Component
public class UserDetailsDao {
	@Resource
	UserDetails userDetails;
	@Resource
	UserRepository userRepository;
	@Autowired
    MessageSender messageSender;
	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	public void insertData(String userName, String phoneNumber)
	{
		userDetails.setUserName(userName);
		userDetails.setPhoneNumber(phoneNumber);
		
		//send the object to queue
		messageSender.sendMessage(userDetails);
		
		//persist the object using spring jpa
		userRepository.save(userDetails);
	}
	
	public List<UserDetails> fetchAllUserDetails()
	{
		return userRepository.findAll();
	}
}
