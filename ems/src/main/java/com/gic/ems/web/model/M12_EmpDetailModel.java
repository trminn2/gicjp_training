package com.gic.ems.web.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M12_EmpDetailModel.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
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
	private M07_EmpInfoCreateModel empInfoCreateModel;
}