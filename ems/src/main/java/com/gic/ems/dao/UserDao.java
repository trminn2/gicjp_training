package com.gic.ems.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gic.ems.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);

	Collection<User> findAllByEmail(String email);

	Optional<User> findByEmail(String email);

	@Override
	Optional<User> findById(Long id);
}