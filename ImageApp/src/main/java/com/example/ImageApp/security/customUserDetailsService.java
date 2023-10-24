//package com.example.ImageApp.security;
//
//import org.apache.el.stream.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.example.ImageApp.entity.user;
//import com.example.ImageApp.repository.imageAppRepository;
//import org.springframework.stereotype.Service;
//
//
//
//@Service
//public class customUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	public imageAppRepository repo;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		user user = repo.findByName(username);
//		if(user==null)
//			throw new UsernameNotFoundException("404");
//		return new userDetailsInfo(user);
//	}
//
//}
