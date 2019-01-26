package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gic.ems.entity.Experience;

/**
 * The Interface ExperienceDao.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Interface ExperienceDao.
 */
public interface ExperienceDao extends JpaRepository<Experience, Long> {

}