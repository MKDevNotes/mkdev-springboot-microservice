package com.mkdev.rest.v1.example.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mkdev.rest.v1.example.exception.DnResourceNotFoundException;
import com.mkdev.rest.v1.example.model.DnUser;
import com.mkdev.rest.v1.example.repository.DnUserRepository;

/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-May-02 6:21:16 pm
 */
@Service
@Scope("singleton")
public class DnUserService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7118642542393122160L;

	@Autowired
	DnUserRepository userRepository;

	public List<DnUser> getUserList() throws DnResourceNotFoundException {

		List<DnUser> users = (List<DnUser>) userRepository.findAll();

		if (!users.isEmpty()) {
			return users;
		} else {
			return new ArrayList<DnUser>();
		}
	}

	public DnUser getUserById(Long id) throws DnResourceNotFoundException {
		Optional<DnUser> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new DnResourceNotFoundException("No User record exist for given id");
		}
	}

	public DnUser createOrUpdateUser(DnUser entity) {

		if (entity.getUserId() == null) {
			entity = userRepository.save(entity);
			return entity;
		} else {
			Optional<DnUser> dnUserObj = userRepository.findById(entity.getUserId());

			if (dnUserObj.isPresent()) {
				DnUser newEntity = dnUserObj.get();
				BeanUtils.copyProperties(entity, newEntity);
				newEntity = userRepository.save(newEntity);

				return newEntity;
			} else {
				entity = userRepository.save(entity);
				return entity;
			}
		}
	}

	public void deleteUserById(Long id) throws DnResourceNotFoundException {
		Optional<DnUser> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new DnResourceNotFoundException("No User record exist for given id");
		}
	}

}
