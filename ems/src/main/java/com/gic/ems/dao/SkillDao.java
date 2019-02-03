package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gic.ems.entity.Skill;

/**
 * The Interface SkillDao.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 26, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.dao </BR>
 *        SkillDao.java </BR>
 */
public interface SkillDao extends JpaRepository<Skill, Long> {

}