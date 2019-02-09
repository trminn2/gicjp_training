package com.gic.ems.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M12_EmpDetailModel.
 *
 * @author MOEPWINTPHYU Jan 26, 2019 <BR>
 *         The Class M12_EmpDetailModel.
 */
@Getter
@Setter

/**
 * Instantiates a new m 12 emp detail model.
 */
@NoArgsConstructor
public class M12_EmpDetailModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp info create model. */
	private M12_EmplnfoSubModel m12_EmplnfoSubModel;

	/** The emp experience create model. */
	private M12_EmpExpSubModel m12_EmpExpSubModel;

	/** The emp skill create model. */
	private M12_EmpSkillSubModel m12_EmpSkillSubModel;

	/** The emp dispatch create model. */
	private M12_EmpDispatchSubModel m12_EmpDispatchSubModel;


	/**
	 * Instantiates a new experience.
	 *
	 * @param id                  the id
	 * @param uuid                the uuid
	 * @param empInfoCreateModel  the empInfoCreateModel
	 * @param empExpModel         the empExpModel
	 * @param empSkillModel       the empSkillModel
	 * @param empExpDispatchModel the empExpDispatchModel
	 */
	@Builder
	public M12_EmpDetailModel(Long id, String uuid, M12_EmplnfoSubModel m12_EmplnfoSubModel,
			M12_EmpExpSubModel m12_EmpExpSubModel, M12_EmpSkillSubModel m12_EmpSkillSubModel,
			M12_EmpDispatchSubModel m12_EmpDispatchSubModel) {
		super(id, uuid);
		this.m12_EmplnfoSubModel = m12_EmplnfoSubModel;
		this.m12_EmpExpSubModel = m12_EmpExpSubModel;
		this.m12_EmpSkillSubModel = m12_EmpSkillSubModel;
		this.m12_EmpDispatchSubModel = m12_EmpDispatchSubModel;
	}
	
}