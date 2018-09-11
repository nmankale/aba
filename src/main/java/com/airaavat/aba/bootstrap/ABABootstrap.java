package com.airaavat.aba.bootstrap;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.airaavat.aba.model.Organization;
import com.airaavat.aba.model.Users;
import com.airaavat.aba.repository.OrganizationReository;
import com.airaavat.aba.repository.UsersRepository;

@Component
public class ABABootstrap implements ApplicationListener<ContextRefreshedEvent>{


	private OrganizationReository orgRepository;
	
	private UsersRepository userRepository;

	public ABABootstrap(OrganizationReository org, UsersRepository user)
	{
		this.orgRepository = org;
		this.userRepository = user;
		
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		this.initData();
		
		
	}
	
	private void initData()
	{
		// Set<Users> admin = new Set<Users>();
		
		Users u = new Users();

		// admin.add(u);
		
		u.setActive(true);
		u.setName("Nandini");
		u.setPassword("nand");
		
		userRepository.save(u);
		
		Organization org = new Organization();
		
		org.setName("Relevance Lab");
		org.setCountry("India");
		org.setAddress("37, Sarjapur Road");
		org.getUsers().add(u);
		
		orgRepository.save(org);
	}
}
