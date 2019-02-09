package com.gic.ems.web.model;

import java.util.Collection;
import com.gic.ems.entity.EmployeeSkill;
import com.gic.ems.entity.Skill;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M12_EmpSkillModel.
 *
 * @author MOEPWINTPHYU Jan 26, 2019 <BR>
 *         The Class M12_EmpSkillModel.
 */

@Getter
@Setter

/**
 * Instantiates a new m 12 emp skill model.
 */
@NoArgsConstructor
public class M12_EmpSkillSubModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The level code. */
	private int levelCode;

	/** The skill. */
	private Skill skill;

	/** The skill name. */
	private String skillName;

	/** The type. */
	private String type;

	/** The employee skills. */
	private Collection<EmployeeSkill> employeeskills;

	/**
	 * Instantiates a new experience.
	 *
	 * @param id             the id
	 * @param uuid           the uuid
	 * @param levelCode      the level code
	 * @param skill          the skill
	 * @param skillName      the skill name
	 * @param type           the type
	 * @param employeeskills the employee skills
	 */

	@Builder
	public M12_EmpSkillSubModel(Long id, String uuid, int levelCode, Skill skill, String skillName, String type,
			Collection<EmployeeSkill> employeeskills) {
		super(id, uuid);
		this.levelCode = levelCode;
		this.skill = skill;
		this.skillName = skillName;
		this.type = type;
		this.employeeskills = employeeskills;
	}
}