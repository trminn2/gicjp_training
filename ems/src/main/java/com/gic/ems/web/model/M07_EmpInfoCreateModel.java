/*
   * 作成日 : 2019/01/26
   * 作成者 : テッ　テッ　カイン
   * 画面名 : M07_個人情報登録画面
 */
package com.gic.ems.web.model;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class M07_EmpInfoCreateModel extends BaseModel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** 社員番号 */
	private String employeeId;
	
	/** 姓 */
	private String firstName;
	
	/** 名 */
	private String lastName;
	
	/** セイ */
	private String firstNameKana;
	
	/** メイ  */
	private String lastNameKana;
	
	/** 郵便番号 */
	private String postalCode;
	
	/** 住所 */
	private String address;
	
	/** 性別 */
	private String gender;
	
	/** 国籍・地域  */
	private String nationality;
	
	/** 電話番号 */
	private String phone;
	
	/** メール */
	private String email;
	
	/** 在留番号 */
	private String residenceNo;
	
	/** 在留資格 */
	private String residenceStatus;
	
	/** 在留期間 */
	private String residencePeriod;
	
	/** パスポートの種類 */
	private String passportType;
	
	/** passportNum */
	private String passportNum;
	
	/** パスポート国番号  */
	private String passportCountryCode;
	
	/** パスポート機関 */
	private String passportAuthority;
	
	/** 銀行口座 */
	private String bankAccount;
	
	/** 保険タイプ */
	private String insuranceType;
	
	/** 被保険者番号 */
	private String insuredNum;
	
	/** 保険会社番号 */
	private String insurerNum;
	
	/** 保険会社名 */
	private String insurerName;
	
	/** 個人番号 */
	private String myNumber;
	
	/** 開始駅 */
	private String startStation;
	
	/** 終了駅 */
	private String endStation;
	
	/** 考え方 */
	private String wayOfThinking;
	
	/** 自信あること */
	private String confidenceSkill;
	
	/** 得意分野 */
	private String speciality;
	
	/** グループID */
	private int groupId;
	
	/** バンド */
	private int band;
	
	/** 部署ID */
	private int departmentId;
	
	/** 資格ID */
	private int certificateId;
	
	/** 生年月日 */
	private Date birthDate;
	
	/** 入社日 */
	private Date hiredDate;
	
	/** パスポート有効期限 */
	private Date passportIssuedDate;
	
	/** パスポート機関 */
	private Date passportExpiredDate;
	
	/**  被保険者認定日*/
	private Date insuredQualifiedDate;
	
	/** 定期券パス有効期限 */
	private Date commuterPassExpiredDate;
}