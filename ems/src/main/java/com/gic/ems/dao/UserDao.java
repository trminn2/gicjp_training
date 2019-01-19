package com.gic.ems.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gic.ems.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	Optional<User> findById(Long id);
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
}