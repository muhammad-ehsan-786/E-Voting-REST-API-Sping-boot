package com.springboot.evoting.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.evoting.model.RolesEntity;
import com.springboot.evoting.model.UsersEntity;
import com.springboot.evoting.repository.UsersRepo;

@Service

public class UserService implements UserDetailsService {
	
	@Autowired
	private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
       UsersEntity userEntity = usersRepo.findByuserEmail(userEmail)
               .orElseThrow(() ->
                       new UsernameNotFoundException("User not found with  email:" + userEmail));
        return new org.springframework.security.core.userdetails.User(userEntity.getUserEmail(),
                userEntity.getPassword(), mapRolesToAuthorities(userEntity.getRoles()));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<RolesEntity> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
	
	
	

}
