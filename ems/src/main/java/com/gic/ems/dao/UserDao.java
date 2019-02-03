package com.gic.ems.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.entity.User;

import lombok.NonNull;

/**
 * The Interface UserDao.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 26, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.dao </BR>
 *        UserDao.java </BR>
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

	/**
	 * Exists by email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	boolean existsByEmailAndDeleteFlag(@NonNull String email, @NonNull DeleteFlag deleteFlag);

	/**
	 * Find all by email and delete flag.
	 *
	 * @param email the email
	 * @return Collection
	 */
	Collection<User> findAllByEmailAndDeleteFlag(@NonNull String email);

	/**
	 * Find by email and delete flag.
	 *
	 * @param email      the email
	 * @param deleteFlag the delete flag
	 * @return Optional
	 */
	Optional<User> findByEmailAndDeleteFlag(@NonNull String email, @NonNull DeleteFlag deleteFlag);

	/**
	 * Find by id and delete flag.
	 *
	 * @param id         the id
	 * @param deleteFlag the delete flag
	 * @return Optional
	 */
	Optional<User> findByIdAndDeleteFlag(@NonNull Long id, @NonNull DeleteFlag deleteFlag);
}