/*
   * 作成日 : 2019/01/26
   * 作成者 : テッ　テッ　カイン
   * 画面名 : M09_派遣先情報登録画面
 */
package com.gic.ems.web.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class M09_HakenCreateModel extends BaseModel{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** 部署ID */
	private String dispatchDepartmentId;
	
	/** 会社ID */
	private String companyId;
	
	/** 部署名 */
	private String name;
	
	/** メール  */
	private String contractEmail;
	
	/** 責任者前名 */
	private String contractPersonFirstName;
	
	/** 責任者後名  */
	private String contractPersonLastName;
	
	/** 責任者前名カタカナ */
	private String contractPersonFirstNameKana;
	
	/** 責任者後名カタカナ */
	private String contractPersonLastNameKana;
	
	/** 責任者電話番号 */
	private String contractPhone;
	
	/** 住所 */
	private String address;
	
	/** 郵便番号 */
	private String postalCode;
	
	/** 郵便番号 */
	private String dispatchStartDate;	
}