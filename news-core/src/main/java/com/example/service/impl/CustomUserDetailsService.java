package com.example.service.impl;

import com.example.converter.UserConverter;
import com.example.dto.MyUserDetail;
import com.example.dto.RoleDTO;
import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final Logger log = Logger.getLogger(CustomUserDetailsService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		UserDTO userDTO = userConverter.convertToDto(userEntity);

		if(userDTO == null) {
			log.error("user not found");
			throw new UsernameNotFoundException("Username not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleDTO role: userDTO.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}

		MyUserDetail myUserDetail = new MyUserDetail(username, userDTO.getPassword(), true, true, true, true, authorities);
		BeanUtils.copyProperties(userDTO, myUserDetail);
		return myUserDetail;
	}
}
