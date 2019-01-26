package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gic.ems.entity.Skill;

/**
 * The Interface SkillDao.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Interface SkillDao.
 */
public interface SkillDao extends JpaRepository<Skill, Long> {

}