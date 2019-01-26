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
	private M12_EmplnfoModel empInfoCreateModel;

	/** The emp experience create model. */
	private M12_EmpExpModel empExpModel;

	/** The emp skill create model. */
	private M12_EmpSkillModel empSkillModel;

	/** The emp dispatch create model. */
	private M12_EmpDispatchModel empExpDispatchModel;

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
	public M12_EmpDetailModel(Long id, String uuid, M12_EmplnfoModel empInfoCreateModel, M12_EmpExpModel empExpModel,
			M12_EmpSkillModel empSkillModel, M12_EmpDispatchModel empExpDispatchModel){
		super(id, uuid);
		this.empInfoCreateModel = empInfoCreateModel;
		this.empExpModel = empExpModel;
		this.empSkillModel = empSkillModel;
		this.empExpDispatchModel = empExpDispatchModel;
	}
}