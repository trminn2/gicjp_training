package com.gic.ems.web.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M12_EmpExpModel.
 *
 * @author MOEPWINTPHYU Jan 26, 2019 <BR>
 *         The Class M12_EmpExpModel.
 */

@Getter
@Setter

/**
 * Instantiates a new m 12 emp exp model.
 */
@NoArgsConstructor
public class M12_EmpExpModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The job role. */
	private String jobRole;

	/** The num of member. */
	private int numOfMember;

	/** The position. */
	private String position;

	/** The project name. */
	private String projectName;

	/** The responsibilities. */
	private String responsibilities;

	/** The start date. */
	private LocalDate startDate;

	/** The end date. */
	private LocalDate endDate;

	/** The technologies. */
	private String technologies;

	/**
	 * Instantiates a new experience.
	 *
	 * @param id               the id
	 * @param uuid             the uuid
	 * @param jobRole          the job role
	 * @param numOfMember      the num of member
	 * @param position         the position
	 * @param projectName      the project name
	 * @param responsibilities the responsibilities
	 * @param startDate        the start date
	 * @param endDate          the end date
	 * @param technologies     the technologies
	 */

	@Builder
	public M12_EmpExpModel(Long id, String uuid, String jobRole, int numOfMember, String position, String projectName,
			String responsibilities, LocalDate startDate, LocalDate endDate, String technologies) {
		super(id, uuid);
		this.jobRole = jobRole;
		this.numOfMember = numOfMember;
		this.position = position;
		this.projectName = projectName;
		this.responsibilities = responsibilities;
		this.startDate = startDate;
		this.endDate = endDate;
		this.technologies = technologies;
	}
}